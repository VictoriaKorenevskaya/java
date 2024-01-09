package kr;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        ClassBD classbd = new ClassBD();
        XML xml = new XML();

        classbd.readStudent("Student1.txt");
        classbd.Sort("rezultsort.txt");
        classbd.readTeacher("Teacher.txt");
        classbd.writeTeacher("rezultmap.txt");
        classbd.ListSort("rezultsort2.txt");
        classbd.printTeachersWithFewerDebt("rezultdebt.txt");
        xml.Write("rezultxml.txt", classbd);
    }
}