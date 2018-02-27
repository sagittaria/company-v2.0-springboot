package com.kgroup.service.impl;

import com.kgroup.dao.StudentDAO;
import com.kgroup.entity.Student;
import com.kgroup.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public Collection<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public Student getById(int id) {
        return studentDAO.getById(id);
    }

    @Override
    public Collection<Student> deleteById(int id) {
        return studentDAO.deleteById(id);
    }

    @Override
    public Collection<Student> add(Student student) {
        return studentDAO.add(student);
    }

    @Override
    public Collection<Student> update(Student student) {
        return studentDAO.update(student);
    }
}
