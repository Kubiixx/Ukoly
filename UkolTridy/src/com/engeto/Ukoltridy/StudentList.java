package com.engeto.Ukoltridy;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    List<Student> studentsList = new ArrayList<>();

    public void addStudent (Student student){
        studentsList.add(student);
    }

    public int getStudentsListSize(){
        return studentsList.size();
    }

    public void printStudentsList1(){
        for(Student student: studentsList){
            System.out.println("# "+(studentsList.indexOf(student)+1)+ " # " +student.getiD()+ " - "
                    +student.getFullName()+ " ("+student.getBirthDate()+ ")");
        }
    }

    public void printStudentsList2(){
        studentsList.forEach(student -> System.out.println(student.getiD()+ ", " +student.getFullName()));
    }
}
