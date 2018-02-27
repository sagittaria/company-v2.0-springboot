package com.kgroup.controller;

import com.kgroup.entity.Student;
import com.kgroup.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Collection<Student> getAll(){
        return studentService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Student getById(@PathVariable("id") int id){
        return studentService.getById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Collection<Student> deleteById(@PathVariable("id") int id){
        return studentService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> add(@RequestBody Student student){
        return studentService.add(student);
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> update(@RequestBody Student student){
        return studentService.update(student);
    }
}