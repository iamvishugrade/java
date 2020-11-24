import java.util.*;
import java.io.*;
class StreamGobbler extends Thread
{
    InputStream is;
    String type;
    
    StreamGobbler(InputStream is, String type)
    {
        this.is = is;
        this.type = type;
    }
    
    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            while ( (line = br.readLine()) != null)
                System.out.println(type + ">" + line);    
            } catch (IOException ioe)
              {
                ioe.printStackTrace();  System.out.println("Error 1");
              }
    }
}
public class GoodWindowsExec
{
    public static void exe(String comm)
    {
        if (comm.length()< 1)
        {
            System.out.println("USAGE: java GoodWindowsExec <cmd>");
            System.exit(1);
        }
        
        try
        {            
            String osName = System.getProperty("os.name" );
            String[] cmd = new String[3];
            try
            {
            	if( osName.equals( "Windows NT (unknown)" ) )
                {
                 cmd[0] = "cmd.exe" ;
                 cmd[1] = "/C" ;
                 cmd[2] = comm;//args[0];
                }
                else if( osName.equals( "Windows 95" ) )
                {
                 cmd[0] = "command.com" ;
                 cmd[1] = "/C" ;
                 cmd[2] = comm;//args[0];
                }
                else
                {
                 cmd[0] = "cmd.exe" ;
                 cmd[1] = "/C" ;
                 cmd[2] = comm;//args[0];
                }
            }
            catch(Exception e){System.out.println("Operating System not supportable.");}
            
            Runtime rt = Runtime.getRuntime();
            //System.out.println("Execing " + cmd[0] + " " + cmd[1] 
              //                 + " " + cmd[2]);
            Process proc = rt.exec(cmd);
            // any error message?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");            
            
            // any output?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "OUTPUT");
                
            // kick them off
            errorGobbler.start();
            outputGobbler.start();
                                    
            // any error???
            int exitVal = proc.waitFor();
            //System.out.println("ExitValue: " + exitVal);        
        } catch (Throwable t)
          {
            t.printStackTrace();
          }
    }
    
    public static void main(String args[])
    {
    	exe("md ashu");
    }
}

