package kr;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ClassBD {
    List<Student> students = new ArrayList<Student>();
    Map<Integer, String> teachers = new TreeMap<Integer, String>();

    
 // 2) Метод чтения данных из текстового файла в List (хотя бы String)
    public void readStudent(String file_name) throws IOException {
        FileReader fileReader = new FileReader(file_name);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            Student stud = new Student();
            Pattern pattern = Pattern.compile("(\\d+).([A-Za-z]+).([A-Za-z]+).(\\d+[.]\\d+[.]\\d+)[. ;]+(\\d+[.]?\\d?)[. ;?]+");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                stud.setId(Long.parseLong(matcher.group(1)));
                stud.setSurname(matcher.group(2));
                stud.setName(matcher.group(3));
                stud.setBirthday(matcher.group(4));
                stud.setMark(Double.parseDouble(matcher.group(5)));
            }

            str = removePrefix(str, matcher.group());
            pattern = Pattern.compile("(\\d)");
            matcher = pattern.matcher(str);
            while (matcher.find()){
                stud.getSubjects().add(Integer.parseInt(matcher.group(1)));
            }
            students.add(stud);
        }
        fileReader.close();
    }

    public static String removePrefix(String s, String prefix)
    {
        if (s != null && prefix != null && s.startsWith(prefix)) {
            return s.substring(prefix.length());
        }
        return s;
    }

    
 // 4) Cортировка объекта List;
 // - результат в текстовый файл rezultsort.txt
    public void Sort(String file_name) throws IOException {
        Collections.sort(students);
        FileWriter fileWriter = new FileWriter(file_name);
        for (int i = 0; i < students.size(); i++) {
            fileWriter.write(students.get(i).toString() + "\n");
        }

        fileWriter.close();
    }

    
 // 3) Метод записывающий преподавателей в Map, для MAP:...
 // - результат в текстовый файл rezultmap.txt
    
    public void readTeacher(String file_name) throws IOException {
        FileReader fileReader = new FileReader(file_name);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            String name = scanner.next();
            int number = Integer.parseInt(scanner.next());
            int counter = 0;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).subjects.contains(number)){
                    counter ++;
                }
            }
            name += "::"+counter;
            teachers.put(number, name);
        }
        fileReader.close();
    } 
  
 // 4) Сортировка объeкта List (сортирует данные класса LIST по полю фамилия и среднему баллу
 // и записывающий в результирующий текстовый файл  rezultsort2.txt)
    public void ListSort(String file_name) throws IOException {
        
        Collections.sort(students, Comparator.comparing(Student::getSurname));

        Collections.sort(students, Comparator.comparingDouble(Student::getMark).reversed());

        
        FileWriter fileWriter = new FileWriter(file_name);
        for (Student student : students) {
            fileWriter.write(student.toString() + "\n");
        }
        fileWriter.close();
    }
 
    
 // 5) Метод выводящий фамилии преподавателей, у которых меньше студентов-задолжников
 // - результат в текстовый файл rezultdebt.txt
    
    public void printTeachersWithFewerDebt(String file_name) throws IOException {
        FileWriter fileWriter = new FileWriter(file_name);
        
        for (Map.Entry<Integer, String> entry : teachers.entrySet()) {
            String[] parts = entry.getValue().split("::");
            String teacherName = parts[0];
            int debtCount = Integer.parseInt(parts[1]);

            if (debtCount < students.size()) {
                fileWriter.write(teacherName + "\n");
            }
        }
        
        fileWriter.close();
    } 
 
   
 // 6) Запись информации из Map в XML формат
 
    public void writeTeacher(String file_name) throws IOException {
        FileWriter fileWriter = new FileWriter(file_name);
        fileWriter.write(teachers.toString());
        fileWriter.close();
    }
}
