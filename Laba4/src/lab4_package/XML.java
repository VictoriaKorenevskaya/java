package lab4_package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.*;


public class XML{

	private String data;
	
	public XML()
	{
		data=null;
	}

	 
	
	public void Read(BufferedReader reader, String fileeName) {
		 try {
	            
	            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	            
	            Document document = documentBuilder.parse("input.xml");
	 
	            Node root = document.getDocumentElement();
	            
	            System.out.println("List of books:");
	            System.out.println();
	            
	            NodeList nodeeelist = root.getChildNodes();
	            
	            for (int i = 0; i < nodeeelist.getLength(); i++) {
	                Node book = nodeeelist.item(i);
	                
	                if (book.getNodeType() != Node.TEXT_NODE) {
	                    NodeList bookProps = book.getChildNodes();
	                    for(int j = 0; j < bookProps.getLength(); j++) {
	                        Node bookProp = bookProps.item(j);
	                       
	                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
	                            System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
	                        }
	                    }
	                    System.out.println("--------------");
	                }
	            }
	 
	        } catch (ParserConfigurationException ex) {
	            ex.printStackTrace(System.out);
	        } catch (SAXException ex) {
	            ex.printStackTrace(System.out);
	        } catch (IOException ex) {
	            ex.printStackTrace(System.out);
	        }
	}
	
	

	public void Write(PrintStream fileOut, Items cofeeee, String fileeName) {
		  try {

	            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	          
	            Document doc = docBuilder.newDocument();
	            Element rootElement = doc.createElement("multicookers");
	            doc.appendChild(rootElement);
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(fileeName);
	            
	            for(int i = 0; i < cofeeee.Size(); i++)
	            {
	            	Coffemakers cooker = cofeeee.get(i);
	          
	            Element multicooker = doc.createElement("multicooker");
	            rootElement.appendChild(multicooker);

	           
	            Element name = doc.createElement("name");
	            name.appendChild(doc.createTextNode(cooker.name));
	            multicooker.appendChild(name);

	         
	          
	            Element color = doc.createElement("color");
	            color.appendChild(doc.createTextNode(cooker.color));
	            multicooker.appendChild(color);

	        
	            Element cost = doc.createElement("cost");
	            cost.appendChild(doc.createTextNode(Integer.toString(cooker.cost)));
	            multicooker.appendChild(cost);

	            Element volume = doc.createElement("volume");
	            volume.appendChild(doc.createTextNode(Integer.toString(cooker.volume)));
	            multicooker.appendChild(volume);

	           
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = null;
	            try {
	                transformer = transformerFactory.newTransformer();
	            } catch (TransformerConfigurationException e) {
	                e.printStackTrace();
	            }

	            transformer.transform(source, result);
	            }


	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }

}
	

}
