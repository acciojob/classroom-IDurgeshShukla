package com.driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    StudentRepository(){

    }
    HashMap<String, Student> Students = new HashMap<>();
    HashMap<String, Teacher> Teachers = new HashMap<>();
    HashMap<String, List<String>> TeacherStudents = new HashMap<>();



    public void addStudent(Student student){
        Students.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        Teachers.put(teacher.getName(),teacher);
    }
    public void mapping(String student, String teacher){
        List<String> students = TeacherStudents.getOrDefault(teacher,new ArrayList<>());
        students.add(student);
        // also set number of students for teacher
        Teachers.get(teacher).setNumberOfStudents(students.size());
        TeacherStudents.put(teacher,students);
    }
    public Student getStudentById(String name)  {
        return Students.get(name);
    }
    public Teacher getTeacherById(String name){
        return Teachers.get(name);
    }
    public List<String> getStudentsByTeacher(String teacher){
         List<String> students = TeacherStudents.get(teacher);
         return  students;
    }
    public List<String> allStudents(){
        return new ArrayList<>(Students.keySet());

    }
    public void  deleteTeacher(String name){
        Teachers.remove(name);
       List<String > students = TeacherStudents.get(name);
       for (String student : students){
           Students.remove(student);
       }
       TeacherStudents.remove(name);
    }
    public void deleteTeachers(){
        Teachers.clear();
        for (String name : TeacherStudents.keySet()){
            List<String> students = TeacherStudents.get(name);
            for (String student :
                    students) {
                Students.remove(student);
            }
        }
        TeacherStudents.clear();
    }
}
