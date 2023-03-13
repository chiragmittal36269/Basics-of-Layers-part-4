package com.developer.StudentTeacherManagement;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentHashMap = new HashMap<>();
    HashMap<String, Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, List<String>> teacherStudentHashMap = new HashMap<>();

    public void addStudent(Student student)
    {
        studentHashMap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher)
    {
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String teacher, String student) {
        // way 1:-
        if (teacherStudentHashMap.containsKey(teacher)) {
            teacherStudentHashMap.get(teacher).add(student);
        } else {
            List<String> studentList = new ArrayList<>();
            studentList.add(student);
            teacherStudentHashMap.put(teacher, studentList);
        }

        // way 2:-
        /*List<String> studentList = new ArrayList<>();
        if (teacherStudentHashMap.containsKey(teacher)) {
            studentList = teacherStudentHashMap.get(teacher);
            studentList.add(student);
            teacherStudentHashMap.put(teacher, studentList);
        } else {
            studentList.add(student);
            teacherStudentHashMap.put(teacher, studentList);
        }*/
    }


    public Student getStudentByName(String student)
    {
        return studentHashMap.get(student);
    }

    public Teacher getTeacherByName(String teacher) {
        for (String tName : teacherHashMap.keySet()) {
            if (tName.equals(teacher)) {
                return teacherHashMap.get(tName);
            }
        }

        return null;
    }


    public List<String> getStudentByTeacherName(String teacherName) {
//        return teacherStudentHashMap.get(teacherName);

//        List<String> studentList = new ArrayList<>();
//        if (teacherStudentHashMap.containsKey(teacherName)) {
//            return teacherStudentHashMap.get(teacherName);
//        }
//        return studentList;

        return teacherStudentHashMap.get(teacherName);
    }


    public List<String> getAllStudent() {
        List<String> studentList = new ArrayList<>();
        for (String s : studentHashMap.keySet()) {
            studentList.add(s);
        }
        return studentList;
    }


    public void deleteTeacherByName(String teacherName) {
        List<String> studentList = new ArrayList<>();
        if (teacherStudentHashMap.containsKey(teacherName)) {
            studentList = teacherStudentHashMap.get(teacherName);
        }
            for (String student : studentList) {
                studentHashMap.remove(student);
            }
            teacherHashMap.remove(teacherName);
            teacherStudentHashMap.remove(teacherName);
    }


    public void deleteAllTeacher() {
        teacherHashMap = new HashMap<>();
        HashSet<String> studentSet = new HashSet<>();
        for (String tName : teacherStudentHashMap.keySet()) {
            for (String sName : teacherStudentHashMap.get(tName)) { // get the list of students related to that teacher
                studentSet.add(sName);
            }
        }

        for (String sName : studentSet) {
            studentHashMap.remove(sName);
        }

        teacherStudentHashMap = new HashMap<>();
    }
}
