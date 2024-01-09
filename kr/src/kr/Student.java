package kr;

import java.math.BigInteger;
import java.util.ArrayList;

class Student implements Comparable <Student> {
    long id;
    String name;
    String surname;
    String birthday;
    double mark;
    ArrayList<Integer> subjects;
    
 // Конструктор с параметрами
    Student (long id, String name, String surname, String birthday, double mark){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.mark = mark;
    }
    
    Student(){
        id = 0;
        name = "";
        surname = "";
        birthday = "";
        mark = 0.0;
        subjects = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setSubjects(ArrayList<Integer> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Integer> getSubjects() {
        return subjects;
    }
    
    

 // 1) Переопределенный метод toString и методы сравнения в классе Student
    
    @Override public String toString(){
        return this.id + ", " + this.name + ", " + this.surname + ", " + this.birthday + ", " + this.subjects + ".";
    }
    
    
    @Override public boolean equals(Object b2){
        if (!(b2 instanceof Student)) return false;
        if (this.name == ((Student)b2).getName() && this.surname == ((Student)b2).getSurname())
            return true;
        return false;
    }
    
    @Override
    public int compareTo(Student b2){
    	 // В данном случае, если id равны, сравниваем по имени.
        if (this.id == b2.id){

        }
        return this.name.compareTo(b2.name);
    }
  
    
}
