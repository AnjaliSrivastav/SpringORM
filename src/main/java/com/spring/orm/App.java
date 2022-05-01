package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
      StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        //Student student = new Student(114,"Nishant","Gurgaon");

       /* insert record
       int r = studentDao.insert(student);
        System.out.println("Id of the record Inserted : "+r);
*/
        /*to get one record
        Student student2 = studentDao.getStudent(111);
        System.out.println(student2);*/

        /*to delete Student
        studentDao.deleteStudent(111);*/

        //to update Student
       /* Student student3 = new Student(114,"Nishant Gupta","Gurgaon");
        studentDao.updateStudent(student3);*/

       //get List of students
        /*List<Student> studentList = studentDao.getAllStudents();
        Consumer<Student> studentConsumer = s -> System.out.println(s);
       // studentList.stream().forEach(studentConsumer); we can replace studentConsumer in forEach from the RHS of the code of studentConsumer

        studentList.stream().forEach(s -> System.out.println(s));*/

        //to take input from user, we create BufferedReader object
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while(go){
            System.out.println("Press 1 to add new Student");
            System.out.println("Press 2 to display all Students");
            System.out.println("Press 3 to get detail of  a single Student");
            System.out.println("Press 4 to delete a  single Student");
            System.out.println("Press 5 to update a single Student");
            System.out.println("Press 6 for exit");

            try{
                int input = Integer.parseInt(br.readLine());
                //we can use switch statement or if-else
                switch (input){
                    case 1:
                        //add a new student
                        System.out.println("Enter StudentId");
                        int sId = Integer.parseInt(br.readLine());

                        System.out.println("Enter Student Name");
                        String sName= br.readLine();

                        System.out.println("Enter Student City");
                        String sCity= br.readLine();

                        Student student = new Student(sId,sName,sCity);
                        int r = studentDao.insert(student);
                        System.out.println("student with id : "+r+" added");
                        System.out.println("*****************************");
                        System.out.println();
                        break;
                    case 2 :
                        //to display all student
                        System.out.println("*****************************");
                        List<Student> studentList = studentDao.getAllStudents();
                        studentList.stream().forEach(s -> {
                            System.out.println(s);
                            System.out.println("---------------------------------");});

                        System.out.println();
                        break;
                    case 3:
                        //to get detail of a single Student
                        System.out.println("Enter StudentId");
                        int studentId = Integer.parseInt(br.readLine());
                        Student student2 = studentDao.getStudent(studentId);
                        System.out.println(student2);
                        System.out.println("----------------------------------");
                        System.out.println();
                        break;
                    case 4:
                        //to delete a single Student
                        System.out.println("Enter StudentId");
                        int student_Id = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(student_Id);
                        System.out.println("Student with id : "+student_Id+" deleted");
                        System.out.println("-----------------------------------------");
                        System.out.println();
                        break;
                    case 5:
                        //to update a single Student
                        System.out.println("Enter StudentId");
                        int s_Id = Integer.parseInt(br.readLine());

                        System.out.println("Enter Student Name");
                        String s_Name= br.readLine();

                        System.out.println("Enter Student City");
                        String s_City= br.readLine();

                        Student student3 = new Student(s_Id,s_Name,s_City);
                        //Student student3 = new Student(114,"Nishant","Gurgaon");
                        studentDao.updateStudent(student3);
                        System.out.println("student with id : "+s_Id+" updated");
                        System.out.println();
                        break;
                    case 6:
                      go=false;
                      break;
                }

            }catch(Exception e){
                System.out.println("Invalid Input, try with Another One!!");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank You for using my application");
        System.out.println("see you soon!!");
    }
}
