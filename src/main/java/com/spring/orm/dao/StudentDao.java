package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao {
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private HibernateTemplate hibernateTemplate;

    //save/insert Student
    @Transactional
    public int insert(Student student){
        Integer rowInserted = (Integer)this.hibernateTemplate.save(student);
        return rowInserted;
    }

    //get Single record(object)
    public Student getStudent(int studentId){
       Student student = this.hibernateTemplate.get(Student.class,studentId);
       return  student;
    }

    //get all Students
    public List<Student> getAllStudents(){
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    //delete one oject(Student)
    @Transactional
    public void deleteStudent(int studentId){
        Student student = this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);
    }

    //update Student
    @Transactional
    public void updateStudent(Student student){
        this.hibernateTemplate.update(student);
    }

}
