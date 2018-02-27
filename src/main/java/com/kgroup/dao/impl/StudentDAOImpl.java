package com.kgroup.dao.impl;

import com.kgroup.dao.StudentDAO;
import com.kgroup.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

    private Map<Integer,Student> studentMap = new HashMap<Integer,Student>(){{
        put(1, new Student(1, "张三", 22));
        put(2, new Student(2, "李四", 23));
    }};

    @Override
    public Collection<Student> getAll() {
        return studentMap.values();
    }

    @Override
    public Student getById(int id) {
        return studentMap.get(id);
    }

    @Override
    public Collection<Student> deleteById(int id) {
        studentMap.remove(id);
        return studentMap.values();
    }

    @Override
    public Collection<Student> add(Student student) {
        studentMap.put(student.getId(),student);
        return studentMap.values();
    }

    @Override
    public Collection<Student> update(Student student) {
        studentMap.put(student.getId(),student);
        return studentMap.values();
    }

}