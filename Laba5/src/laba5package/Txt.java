package laba5package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;


public class Txt implements DataSource{
	private String filename;
	
	 public Txt(String filename)
	 {
	    this.filename=filename;
	 }
	 
	@Override
	public void writeData(String data) {
		try {
			PrintStream fileOut = new PrintStream(filename);			
				fileOut.println(data);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String  readData() {
		BufferedReader reader;
		String str="";
		try {
			reader = new BufferedReader(new FileReader(filename));
		    str = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}

}
