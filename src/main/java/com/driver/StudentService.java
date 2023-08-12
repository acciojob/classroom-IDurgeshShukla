package com.driver;

import com.driver.Student;
import com.driver.Teacher;
import com.driver.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
  @Autowired
  StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }
    public void mapping(String student, String teacher){
        studentRepository.mapping(student,teacher);
    }
    public Student getStudentById(String name)  {
        return studentRepository.getStudentById(name);
    }
    public Teacher getTeacherById(String name){
        return studentRepository.getTeacherById(name);
    }
    public List<String> allStudents(){

        return studentRepository.allStudents();

    }
    public List<String> getStudentsByTeacher(String teacher){
        return studentRepository.getStudentsByTeacher(teacher);
    }
    public void  deleteTeacher(String name){
        studentRepository.deleteTeacher(name);
    }
    public void deleteTeachers(){
        studentRepository.deleteTeachers();
    }
}
