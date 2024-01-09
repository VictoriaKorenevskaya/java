package kr;

import java.io.*;
import java.util.Map;

import javax.xml.stream.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
/*import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;*/

public class XML {


    public void Write(String file_name, ClassBD dictionary) throws IOException, XMLStreamException {
        try {
            StringWriter stringWriter = new StringWriter();

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);

            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeStartElement("teachers");
            for(Map.Entry<Integer, String> entry : dictionary.teachers.entrySet()) {
                int key = entry.getKey();
                String value = entry.getValue();
                xMLStreamWriter.writeStartElement("key");
                xMLStreamWriter.writeCharacters(value + "\n");
                xMLStreamWriter.writeStartElement("value");
                xMLStreamWriter.writeCharacters(String.valueOf(key) + "\n");
                xMLStreamWriter.writeEndElement();
                xMLStreamWriter.writeEndElement();
            }

            xMLStreamWriter.writeEndDocument();

            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();

            stringWriter.close();

            FileWriter fileWriter = new FileWriter(file_name);
            fileWriter.write(xmlString);
            fileWriter.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
   /* private void writeJson(String file_name, ClassBD dictionary) throws IOException {
        JSONArray teachersArray = new JSONArray();

     
        for (Map.Entry<Integer, String> entry : dictionary.teachers.entrySet()) {
            JSONObject teacherObject = new JSONObject();
            teacherObject.put("key", entry.getKey());
            teacherObject.put("value", entry.getValue());
            teachersArray.add(teacherObject);
        }

       
        try (FileWriter fileWriter = new FileWriter(file_name)) {
            fileWriter.write(teachersArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
