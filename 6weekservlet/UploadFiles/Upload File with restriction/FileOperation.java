package com.servlet.upload;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.oreilly.servlet.multipart.*;

public class FileOperation  
{
 public String getFileName(HttpServletRequest request,int sizeLimit)throws IOException
 {
  String fileName="";
  MultipartParser parser=new MultipartParser(request,sizeLimit);
  com.oreilly.servlet.multipart.Part part=null;
  while((part=parser.readNextPart())!=null)
  {  
   FilePart file=(FilePart)part;
   fileName=file.getFileName();    
  }
  return fileName;
 } 
 public String getExtension(String fileName)
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
}
  
   