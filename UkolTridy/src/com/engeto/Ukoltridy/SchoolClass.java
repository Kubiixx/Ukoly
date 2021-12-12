package com.engeto.Ukoltridy;

import java.io.*;

public class SchoolClass {

    private final String className;
    private final int classYear;
    private final Teacher classTeacher;
    private final StudentList classStudentsList;

    public SchoolClass(String className, int classYear, Teacher classTeacher, StudentList classStudentsList) {
        this.className = className;
        this.classYear = classYear;
        this.classTeacher = classTeacher;
        this.classStudentsList = classStudentsList;
    }

    public void printSchoolClassV1(){
        System.out.println("####################################");
        System.out.println("Třída: " +className+ " (Ročník: " + classYear+")");
        System.out.println("Třídní učitel: "+classTeacher.getFullName());
        System.out.println("Počet Studentů: " +classStudentsList.getStudentsListSize());
        System.out.println(" \n ####################################");
        classStudentsList.printStudentsList1();
    }

    public void printSchoolclassV2(){
        System.out.println(className+", "+classTeacher.getFullName());
        classStudentsList.printStudentsList2();
    }

    public void exportClassToFile() {
        File file = new File(className);
        try(PrintWriter writer = new PrintWriter(file)) {
            writer.println("************************** \n");
            writer.println("Název třídy: " + className);
            writer.println("Třídní učitel: " + classTeacher.getFullName());
            writer.println("\n **************************\n");
            for (Student student : classStudentsList.studentsList) {
                writer.println("# " +(classStudentsList.studentsList.indexOf(student)+1) + " # " + student.getiD() + " - "
                        + student.getFullName() + " (" + student.getBirthDate() + ")");
            }
            writer.println("\n **************************");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
