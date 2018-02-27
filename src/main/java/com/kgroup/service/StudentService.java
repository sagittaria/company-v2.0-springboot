package com.kgroup.service;

import com.kgroup.entity.Student;

import java.util.Collection;

public interface StudentService {

    /**
     * 获取所有学生对象
     * @return Collection<Student>
     */
    public Collection<Student> getAll();

    /**
     * @param id
     * 传入要获取的学生id
     *
     * @return Student
     * 返回对应的学生对象
     **/
    public Student getById(int id);

    /**
     * @param id
     * 传入要删除的学生id
     *
     * @return Collection<Student>
     * 删除成功后返回所有学生对象
     * */
    public Collection<Student> deleteById(int id);

    /**
     *
     * @param student
     * 传入要添加的学生对象
     *
     * @return
     * 添加成功后返回所有学生对象
     */
    public Collection<Student> add(Student student);

    /**
     *
     * @param student
     * 传入要修改的学生对象
     *
     * @return
     * 修改成功后返回所有学生对象
     */
    public Collection<Student> update(Student student);
}