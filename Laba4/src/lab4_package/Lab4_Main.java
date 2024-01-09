package lab4_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Lab4_Main {
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
				
		System.out.println("Enter ' input ' : ");
		String InputFileName=in.next();
		System.out.println("--------------");
		
		System.out.println("Enter output filename:  ");
		String OutputFileName=in.next();
		System.out.println("--------------");
		
		System.out.println("What is format of your input file? ");
		String format = in.next();
		System.out.println("--------------");
		
		System.out.println("Choose 1, 2 or 3 (items): ");
		
		int count;
		do {
	    count = in.nextInt();
		}while(count<=0);
		
		
		
		Encrypt cr = new Encrypt();
		BufferedReader reader2 = new BufferedReader(new FileReader(InputFileName+".txt"));
		PrintStream fileOut5 = new PrintStream("encryption.txt");
		
		for(int i = 0; i < count; i++)
		{
			String str5 = reader2.readLine();
			String e = cr.encrypt(str5);
			fileOut5.println(e);
		}
		
		
		BufferedReader reader3 = new BufferedReader(new FileReader("encryption.txt"));
		PrintStream fileOut6 = new PrintStream("decryption.txt");
		
		for(int i = 0; i < count; i++)
		{
			String str5 = reader3.readLine();
			String e = cr.decrypt(str5);
			fileOut6.println(e);
		}
		
		
		Txt file = new Txt();
		XML file2 = new XML();
		Archiving a = new Archiving();
		a.archive(OutputFileName, InputFileName+".txt");
		a.read(OutputFileName);
		
		Items objects = new Items();
		

		if(Objects.equals(format,"txt"))
		{
		
		    InputFileName = InputFileName+".txt";
			BufferedReader reader = new BufferedReader(new FileReader(InputFileName));
			PrintWriter out = new PrintWriter(new FileWriter("file.json"));
			for(int i = 0; i < count; i++)
			{
				file.Read(reader, InputFileName);			
			    String str = file.data;
			    String[]parts = str.split(" ");
			    Coffemakers cofa = new Coffemakers(parts[2], Integer.parseInt( parts[3]), parts[0], Integer.parseInt( parts[1]));
		        objects.insert_object(cofa);
		        
		        
		        JSONObject json = new JSONObject();
		        try {
		            json.put("name", cofa.GetName());
		            json.put("color", cofa.GetColor());
		            json.put("cost", cofa.GetCost());
		            json.put("volume", cofa.GetVolume());
		        } catch (JSONException e) {
		            e.printStackTrace();
		        }
		 
		        try(out) {
		            out.write(json.toString());
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        
		    }
		}
		
		if(Objects.equals(format,"xml"))
		{
		
		    InputFileName = InputFileName+".xml";
		    try {
	            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	            Document document = documentBuilder.parse(InputFileName);
	            Node root = document.getDocumentElement();
	            System.out.println("nodelist ");
	            System.out.println();
	            NodeList nodeee = root.getChildNodes();
	            
	            for (int i = 0; i < nodeee.getLength(); i++) {
	            	Coffemakers cooker = new Coffemakers();
	                Node nodee = nodeee.item(i);
	                if (nodee.getNodeType() != Node.TEXT_NODE) {
	                    NodeList nodeeProps = nodee.getChildNodes();
	                    for(int j = 0; j < nodeeProps.getLength(); j++) {
	                        Node nodProp = nodeeProps.item(j);
	                        if (nodProp.getNodeType() != Node.TEXT_NODE) {
	                        	if(Objects.equals("name", nodProp.getNodeName()))
	                        	{
	                        		cooker.SetName(nodProp.getChildNodes().item(0).getTextContent());
	                        	}
	                        	if(Objects.equals("color", nodProp.getNodeName()))
	                        	{
	                        		cooker.SetColor(nodProp.getChildNodes().item(0).getTextContent());
	                        	}
	                        	if(Objects.equals("cost", nodProp.getNodeName()))
	                        	{
	                        		cooker.SetCost(Integer.valueOf(nodProp.getChildNodes().item(0).getTextContent()));
	                        	}
	                        	if(Objects.equals("volume", nodProp.getNodeName()))
	                        	{
	                        		cooker.SetVolume(Integer.valueOf(nodProp.getChildNodes().item(0).getTextContent()));
	                        	}
	                        }
	                    }
	                }
	                objects.insert_object(cooker);
	            }
	 
	        } catch (ParserConfigurationException ex) {
	            ex.printStackTrace(System.out);
	        } catch (SAXException ex) {
	            ex.printStackTrace(System.out);
	        } catch (IOException ex) {
	            ex.printStackTrace(System.out);
	        }
		}
		
		
		
			System.out.println("Sort by cost or volume? ");
			
			String sort=in.next();
			
			System.out.println("What is format of your output file? ");
		    format = in.next();
		    
			if(Objects.equals(sort,"cost"))
			{
				objects.sortByCost();
			}
			
			if(Objects.equals(sort,"volume"))
			{
			objects.sortByVolume();
			
			}
					
			if(Objects.equals(format, "xml"))
			{
			OutputFileName=OutputFileName+".xml";
			objects.Print(OutputFileName, file2);
			}
			
			if(Objects.equals(format,"txt"))
			{
				OutputFileName=OutputFileName+".txt";
				objects.Print(OutputFileName, file);
			}
			
			
		}	
	}

