package com.engeto.Ukoltridy;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Petr", "Svoboda", LocalDate.of(2011, 8, 25), "ID001");
        Student student2 = new Student("Milan", "Říha", LocalDate.of(2010, 4, 5), "ID123");
        Student student3 = new Student("Jindřich", "Nový", LocalDate.of(2012, 12, 24), "ID345");
        StudentList class1List = new StudentList();
        class1List.addStudent(student1);
        class1List.addStudent(student2);
        class1List.addStudent(student3);
        Teacher teacher1 = new Teacher("Jan", "Novák");
        SchoolClass class1 = new SchoolClass("4.C", 4, teacher1, class1List);
        class1.printSchoolClassV1();
        class1.printSchoolclassV2();
        class1.exportClassToFile();
    }
}
