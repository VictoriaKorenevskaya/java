package lab4_package;

import java.io.*;
import java.util.zip.*;

public class Archiving {

	public void archive(String filename, String inputfilename)
	{
		 try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(filename+".zip"));
	                FileInputStream fis= new FileInputStream(inputfilename);)
	        {
	            ZipEntry entry1=new ZipEntry(inputfilename);
	            zout.putNextEntry(entry1);
	            
	            byte[] buffer = new byte[fis.available()];
	            fis.read(buffer);           
	            zout.write(buffer);	            
	            zout.closeEntry();
	        }
	        catch(Exception ex){
	              
	            System.out.println(ex.getMessage());
	        } 

	}
	
	public void read(String outputfilename)
	 {try(ZipInputStream zin = new ZipInputStream(new FileInputStream(outputfilename+".zip")))
     {
         ZipEntry entry;
         String name;
         while((entry=zin.getNextEntry())!=null){
               
             name = entry.getName(); 
             System.out.printf("File name: %s \n", name);
                          
             FileOutputStream fout = new FileOutputStream("decinput" + name);
             for (int c = zin.read(); c != -1; c = zin.read()) {
                 fout.write(c);
             }
             
             fout.flush();
             zin.closeEntry();
             fout.close();
         }
     }
     catch(Exception ex){
           
         System.out.println(ex.getMessage());
     } 
}

	
}
