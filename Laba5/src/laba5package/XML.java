package laba5package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XML
{

	private String inFileName;
	private String outFileName;
	
	public XML(String inFileName, String outFileName)
	{
		this.inFileName = inFileName;
		this.outFileName = outFileName;
	}
	

	public itemsSingletone readFromXmlFile() {
		itemsSingletone coffee = itemsSingletone.GetInstance();

	        try {
	            File file = new File(inFileName);
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(file);
	            doc.getDocumentElement().normalize();

	            NodeList fabricList = doc.getElementsByTagName("coffemakers");

	            for (int temp = 0; temp < fabricList.getLength(); temp++) {
	                Node fabricNode = fabricList.item(temp);
	                if (fabricNode.getNodeType() == Node.ELEMENT_NODE) {
	                    Element fabricElement = (Element) fabricNode;
	                    String name = fabricElement.getElementsByTagName("Name").item(0).getTextContent();
	                    String color = fabricElement.getElementsByTagName("color").item(0).getTextContent();
	                    String cost = fabricElement.getElementsByTagName("cost").item(0).getTextContent();
	                    String volume = fabricElement.getElementsByTagName("volume").item(0).getTextContent();
	                    coffee.insert(new coffemakers.Builder(name, Integer.parseInt(volume), Integer.parseInt(cost)).Color(color).build());
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return coffee;
	}


	public void writeToXMLFile(itemsSingletone coffemakers) {

		 try {
	            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	            
	            Document doc = docBuilder.newDocument();
	            Element rootElement = doc.createElement("coffemakers");
	            doc.appendChild(rootElement);

	            for (coffemakers cofffee : coffemakers.GetList()) {
	               
	                Element cookerElement = doc.createElement("coffemaker");
	                rootElement.appendChild(cookerElement);
  
	                Element name = doc.createElement("Name");
	                name.appendChild(doc.createTextNode(cofffee.GetName()));
	                cookerElement.appendChild(name);
	                
	                Element color = doc.createElement("color");
	                color.appendChild(doc.createTextNode(cofffee.GetColor()));
	                cookerElement.appendChild(color);              
	                
	                Element cost = doc.createElement("cost");
	                cost.appendChild(doc.createTextNode(String.valueOf(cofffee.GetCost())));
	                cookerElement.appendChild(cost);

	                Element volume = doc.createElement("volume");
	                volume.appendChild(doc.createTextNode(String.valueOf(cofffee.GetVolume())));
	                cookerElement.appendChild(volume);
	            }

	            // Write into XML
	            FileOutputStream outputStream = new FileOutputStream(outFileName);
	            javax.xml.transform.TransformerFactory.newInstance().newTransformer().transform(new javax.xml.transform.dom.DOMSource(doc), new javax.xml.transform.stream.StreamResult(outputStream));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		
		
	}

}
