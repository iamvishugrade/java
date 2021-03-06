package com.servlet.upload;

import java.io.*;
import java.util.*;
import javax.servlet.*;

    public class MultipartRequest 
    {
      private static final int DEFAULT_MAX_POST_SIZE = 500*1024*1024;  // 1 Meg
      private ServletRequest req;
      private File dir;
      private int maxSize;
      private String Ext;
      private Hashtable parameters = new Hashtable();  // name - value
      private Hashtable files = new Hashtable();       // name - UploadedFile

	  public  MultipartRequest(ServletRequest request,String saveDirectory,String extension)throws IOException,FileCannotBeUploadException
	  {
	   this(request, saveDirectory, DEFAULT_MAX_POST_SIZE,extension);
	  } 
	  public  MultipartRequest(ServletRequest request,String saveDirectory,int maxPostSize)throws IOException,FileCannotBeUploadException
	  {
	   this(request, saveDirectory, DEFAULT_MAX_POST_SIZE," ");	    
	  } 

      public MultipartRequest(ServletRequest request,String saveDirectory) throws IOException,FileCannotBeUploadException
	  {
        this(request, saveDirectory, DEFAULT_MAX_POST_SIZE," ");
      }

      public MultipartRequest(ServletRequest request,String saveDirectory,int maxPostSize,String extension) throws IOException,FileCannotBeUploadException 
	  {
       // Sanity check values
       if (request == null)
        throw new IllegalArgumentException("request cannot be null");
       if (saveDirectory == null)
        throw new IllegalArgumentException("saveDirectory cannot be null");
       if (maxPostSize <= 0)
	   {
        throw new IllegalArgumentException("maxPostSize must be positive");
       }
        // Save the request, dir, Extension and max size	   
	   Ext=extension;
       req = request;
       dir = new File(saveDirectory);
       maxSize = maxPostSize;

       // Check saveDirectory is truly a directory
       if (!dir.isDirectory())
         throw new IllegalArgumentException("Not a directory: " + saveDirectory);

       // Check saveDirectory is writable
       if (!dir.canWrite())
         throw new IllegalArgumentException("Not writable: " + saveDirectory);

       // Now parse the request saving data to "parameters" and "files";
       // write the file contents to the saveDirectory
       readRequest();
      }

      public Enumeration getParameterNames() 
	  {
        return parameters.keys();
      }

      public Enumeration getFileNames() 
	  {
        return files.keys();
      }

      public String getParameter(String name) 
	  {
       try
	   {
        String param = (String)parameters.get(name);
        if (param.equals("")) 
		{
		 return null;
		}
        return param;
       }catch (Exception e){return null;}
      }

      public String getFilesystemName(String name) 
	  {
       try
	   {
        UploadedFile file = (UploadedFile)files.get(name);
        return file.getFilesystemName();  // may be null
       }catch (Exception e) {return null;}
      }

      public String getContentType(String name) 
	  {
       try 
	   {
        UploadedFile file = (UploadedFile)files.get(name);
        return file.getContentType();  // may be null
       }catch (Exception e) {return null;}
      }

      public File getFile(String name) 
	  {
       try
	   {
        UploadedFile file = (UploadedFile)files.get(name);
        return file.getFile();  // may be null
       }catch (Exception e) {return null;}
      }

      protected void readRequest() throws IOException,FileCannotBeUploadException
	  {
       // Check the content type to make sure it's "multipart/form-data"
       String type = req.getContentType();
       if (type == null ||!type.toLowerCase().startsWith("multipart/form-data"))
	   {
        throw new IOException("Posted content type isn't multipart/form-data");
       }
	   
	   // Check the content length to prevent denial of service attacks
       int length = req.getContentLength();
       if (length > maxSize)
	   {
        throw new IOException("Posted content length of " + length + " exceeds limit of " + maxSize);
       }
       // Get the boundary string; it's included in the content type.
       // Should look something like "------------------------12012133613061"
       String boundary = extractBoundary(type);
       if (boundary == null)
	   {
        throw new IOException("Separation boundary was not specified");
       }
	   // Construct the special input stream we'll read from
       MultipartInputStream in = new MultipartInputStream(req.getInputStream(), boundary, length);
	   // Read the first line, should be the first boundary
       String line = in.readLine();
       if (line == null)
	   {
        throw new IOException("Corrupt form data: premature ending");
       }       
	   // Verify that the line is the boundary
       if (!line.startsWith(boundary)) 
	   {
        throw new IOException("Corrupt form data: no leading boundary");
       }
       // Now that we're just beyond the first boundary, loop over each part
       boolean done = false;
       while (!done) 
	   {
	    done = readNextPart(in, boundary,Ext);
	   }
      }

      protected boolean readNextPart(MultipartInputStream in,String boundary,String Ext) throws IOException,FileCannotBeUploadException 
	  {
       // Read the first line, should look like this:
       // content-disposition: form-data; name="field1"; filename="file1.txt"
       String line = in.readLine();
       if (line == null) 
	   {
        // No parts left, we're done
        return true;
       }

       // Parse the content-disposition line
       String[] dispInfo = extractDispositionInfo(line);
       String disposition = dispInfo[0];
       String name = dispInfo[1];
       String filename = dispInfo[2];

       // Now onto the next line. This will either be empty 
       // or contain a Content-Type and then an empty line.
       line = in.readLine();
       if (line == null) 
	   {
        // No parts left, we're done
        return true;
       }

       // Get the content type, or null if none specified
       String contentType = extractContentType(line);
       if (contentType != null)
	   {
        // Eat the empty line
        line = in.readLine();
        if (line == null || line.length() > 0) 
		{
		 // line should be empty
         throw new IOException("Malformed line after content type: " + line);
        }
       }
       else 
	   {
        // Assume a default content type
        contentType = "application/octet-stream";
       }
	  // Now, finally, we read the content (end after reading the boundary)
       if (filename == null) 
	   {
        // This is a parameter
        String value = readParameter(in, boundary);
        parameters.put(name, value);
       }
       else
	   {
        // This is a file
		if(Ext.equals(" "))
		{
		 readAndSaveFile(in, boundary, filename);
         if (filename.equals("unknown")) 
		 { 
          files.put(name, new UploadedFile(null, null, null));
         }
         else
		 {
          files.put(name,new UploadedFile(dir.toString(), filename, contentType));
         }
		}
		else
		{
	     if(Ext.toLowerCase().equals(getExtension(filename.toLowerCase())))
	  	 {		
      	  throw new FileCannotBeUploadException(" File Can not be Upload with ' "+Ext+" 'extension");
		 }
		 else
		 {
		  readAndSaveFile(in, boundary, filename);
          if (filename.equals("unknown")) 
		  { 
           files.put(name, new UploadedFile(null, null, null));
          }
          else
		  {
           files.put(name,new UploadedFile(dir.toString(), filename, contentType));
          }
		 }
		}
       }     
       return false;  // there's more to read
      }
      protected String getExtension(String fileName)
      {
	   if(Ext!=null)
	   {
	    char [] stringArray=fileName.toCharArray();
        int size=stringArray.length;
  
        char c1=stringArray[size-1];
        char c2=stringArray[size-2];
        char c3=stringArray[size-3];
        char c4=stringArray[size-4];
        char c5=stringArray[size-5];
        char c6=stringArray[size-6];
  
        StringBuilder sb=new StringBuilder();
        sb.append(c6);
        sb.append(c5);
        sb.append(c4);
        sb.append(c3);
        sb.append(c2);
        sb.append(c1);
  
        if(c4=='.')
        {
         sb.deleteCharAt(0);
         sb.deleteCharAt(0);
        }
        else if(c5=='.')
        {
    	 sb.deleteCharAt(0);
        }
        String string=sb.toString();
        return string;
	   }
	   else
       { 
	    return null;
       }	   
      }	
      protected String readParameter(MultipartInputStream in,String boundary) throws IOException 
	  {
       StringBuffer sbuf = new StringBuffer();
       String line;
	   
       while ((line = in.readLine()) != null) 
	   {
        if (line.startsWith(boundary)) break;
        sbuf.append(line + "\r\n");  // add the \r\n in case there are many lines
       }
     
	   if (sbuf.length() == 0) 
	   {
        return null;  // nothing read
       }

       sbuf.setLength(sbuf.length() - 2);  // cut off the last line's \r\n
       return sbuf.toString();  // no URL decoding needed
      }

      protected void readAndSaveFile(MultipartInputStream in,String boundary,String filename) throws IOException 
	  {
       File f = new File(dir + File.separator + filename);
       FileOutputStream fos = new FileOutputStream(f);
       BufferedOutputStream out = new BufferedOutputStream(fos, 500 * 1024); // 8K

       byte[] bbuf = new byte[500 * 1024];  // 8K
       int result;
       String line;
     
       // ServletInputStream.readLine() has the annoying habit of 
       // adding a \r\n to the end of the last line. 
       // Since we want a byte-for-byte transfer, we have to cut those chars.
       boolean rnflag = false;
       while ((result = in.readLine(bbuf, 0, bbuf.length)) != -1) 
	   {
        // Check for boundary
        if (result > 2 && bbuf[0] == '-' && bbuf[1] == '-') 
		{ 
		 // quick pre-check
         line = new String(bbuf, 0, result, "ISO-8859-1");
         if (line.startsWith(boundary)) 
		  break;
        }
        // Are we supposed to write \r\n for the last iteration?
        if (rnflag)
		{
         out.write('\r'); out.write('\n');
         rnflag = false;
        }
        // Write the buffer, postpone any ending \r\n
        if (result >= 2 && bbuf[result - 2] == '\r' && bbuf[result - 1] == '\n') 
		{
         out.write(bbuf, 0, result - 2);  // skip the last 2 chars
         rnflag = true;  // make a note to write them on the next iteration
        }
        else
		{
         out.write(bbuf, 0, result);
        }
       }
       out.flush();
       out.close();
       fos.close();
      }

      private String extractBoundary(String line) 
	  {
       int index = line.indexOf("boundary=");
       if (index == -1) 
	   {
        return null;
       }
       String boundary = line.substring(index + 9);  // 9 for "boundary="

       // The real boundary is always preceded by an extra "--"
       boundary = "--" + boundary;
       return boundary;
      }

      private String[] extractDispositionInfo(String line) throws IOException 
	  {
       // Return the line's data as an array: disposition, name, filename
       String[] retval = new String[3];

       // Convert the line to a lowercase string without the ending \r\n
       // Keep the original line for error messages and for variable names.
       String origline = line;
       line = origline.toLowerCase();

       // Get the content disposition, should be "form-data"
       int start = line.indexOf("content-disposition: ");
       int end = line.indexOf(";");
       if (start == -1 || end == -1) 
	   {
        throw new IOException("Content disposition corrupt: " + origline);
       }
       String disposition = line.substring(start + 21, end);
       if (!disposition.equals("form-data")) 
	   {
        throw new IOException("Invalid content disposition: " + disposition);
       }
       // Get the field name
       start = line.indexOf("name=\"", end);  // start at last semicolon
       end = line.indexOf("\"", start + 7);   // skip name=\"
       if (start == -1 || end == -1) 
	   {
        throw new IOException("Content disposition corrupt: " + origline);
       }
       String name = origline.substring(start + 6, end);

       // Get the filename, if given
       String filename = null;
       start = line.indexOf("filename=\"", end + 2);  // start after name
       end = line.indexOf("\"", start + 10);          // skip filename=\"
       if (start != -1 && end != -1)
	   {       
	    // note the !=
        filename = origline.substring(start + 10, end);
        // The filename may contain a full path. Cut to just the filename.
        int slash =Math.max(filename.lastIndexOf('/'), filename.lastIndexOf('\\'));
        if (slash > -1) 
		{
         filename = filename.substring(slash + 1);  // past last slash
        }
        if (filename.equals("")) 
		 filename = "unknown"; // sanity check
       }
       // Return a String array: disposition, name, filename
       retval[0] = disposition;
       retval[1] = name;
       retval[2] = filename;
       return retval;
      }

      private String extractContentType(String line) throws IOException 
	  {
       String contentType = null;
       // Convert the line to a lowercase string
       String origline = line;
       line = origline.toLowerCase();

       // Get the content type, if any
       if (line.startsWith("content-type")) 
	   {
        int start = line.indexOf(" ");
        if (start == -1) 
		{
         throw new IOException("Content type corrupt: " + origline);
        }
        contentType = line.substring(start + 1);
       }
       else if (line.length() != 0) 
	   { 
    	// no content type, so should be empty
        throw new IOException("Malformed line after disposition: " + origline);
       }
       return contentType;
      }
    }
