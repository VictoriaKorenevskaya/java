package lab4_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

public class Txt extends readWrite{
	
	protected String data;
	public Txt()
	{
		data = null;
	}
	
	public int Check()
	{
		if(Objects.equals(data,"txt"))
		{
			return 1;
		}
		else
			return 0;
	}
	
	public String Read (BufferedReader reader, String fileeName)
	{
		 try {
			
		data = reader.readLine();
		System.out.println(data);
				
		 } catch (IOException e)
		    {
		        e.printStackTrace();
		    }
		 return data;
	}
	
	public void Write(PrintStream fileOut, Items cofeeee, String name)
	{
		String 	outputString = cofeeee.toString();	
		fileOut.println(outputString);

	}
	
}
