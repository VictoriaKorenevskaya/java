package kr;

import java.util.Comparator;

class StudentComparator implements Comparator<Student> {
    @Override public int compare(Student b1, Student b2) {
        return b1.getName().compareTo(b2.getName());
    }
}