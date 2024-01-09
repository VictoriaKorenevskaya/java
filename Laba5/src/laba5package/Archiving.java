package laba5package;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Archiving {

	public void archive(String filename, String inFileName)
	{
		 try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(filename+".zip"));
	                FileInputStream fis= new FileInputStream(inFileName);)
	        {
	            ZipEntry entry1=new ZipEntry(inFileName);
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
	
	public void read(String outFileName)
	 {
		try(ZipInputStream zin = new ZipInputStream(new FileInputStream(outFileName+".zip")))
     {
         ZipEntry entry;
         String name;
         while((entry=zin.getNextEntry())!=null){
               
             name = entry.getName(); 
             System.out.printf("File name -> %s \n", name);
              
             
             FileOutputStream fout = new FileOutputStream("new" + name);
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

