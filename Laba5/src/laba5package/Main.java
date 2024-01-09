package laba5package;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException 
	{
		coffemakers c = new coffemakers.Builder("Coffeek", 940 , 500).Color("black").build();
		System.out.println(c.toString());
		String str = c.toString();
		DataDecorator dec = new EncryptionDecorator(new Txt("Outpuuut.txt"));
		dec.writeData(str);
		DataSource plain = new Txt("Outpuuut.txt");
		
		XML xml_interactions = new XML("input.xml", "output.xml");
		itemsSingletone coffemak = xml_interactions.readFromXmlFile();
		coffemak.insert(new coffemakers.Builder("Cava", 4800, 300).Color("grey").build());
		xml_interactions.writeToXMLFile(coffemak);
		
		 Archiving archieve = new Archiving();
         archieve.archive("archiving", "input.txt");
         archieve.read("archiving");
	}
}
