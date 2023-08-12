package com.driver;

import com.driver.Student;
import com.driver.Teacher;
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
    HashMap<String, List<String>> StudentTeachers = new HashMap<>();



    public void addStudent(Student student){
        Students.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        Teachers.put(teacher.getName(),teacher);
    }
    public void mapping(String student, String teacher){
        List<String> students = TeacherStudents.getOrDefault(teacher,new ArrayList<>());
        students.add(student);
        TeacherStudents.put(teacher,students);
        List<String> teachers = StudentTeachers.getOrDefault(student,new ArrayList<>());
        teachers.add(teacher);
        StudentTeachers.put(student,teachers);
    }
    public Student getStudentById(String name)  {
        return Students.get(name);
    }
    public Teacher getTeacherById(String name){
        return Teachers.get(name);
    }
    public List<String> getStudentsByTeacher(String teacher){
         List<String> students = TeacherStudents.get(teacher);
         List<String> list = new ArrayList<>();
        list.addAll(students);
        return list;
    }
    public List<String> allStudents(){
        ArrayList<String> students = new ArrayList<>(Students.keySet());
        return students;

    }
    public void  deleteTeacher(String name){
        Teachers.remove(name);
        TeacherStudents.remove(name);
        for (String n : StudentTeachers.keySet()) {
            List<String> cur = StudentTeachers.get(n);
            cur.removeIf(t -> t.equals(name)); // remove if condition satisfied
            StudentTeachers.put(n,cur); // update in db
        }
    }
    public void deleteTeachers(){
        Teachers.clear();
        TeacherStudents.clear();
        StudentTeachers.clear();
    }
}
