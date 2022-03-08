package com.example;

import com.example.DAO.ResourceDAO;
import com.example.model.Grant;
import com.example.model.Resource;
import com.example.model.Student;
import com.example.model.Subject;
import com.example.repositories.StudentRepository;
import com.example.service.GrantService;
import com.example.service.ResourceService;
import com.example.service.StudentService;
import com.example.service.SubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppTest {

    @Autowired
    StudentService studentService;

    @Autowired
    GrantService grantService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    ResourceService resourceService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ResourceDAO resourceDAO;

    @BeforeEach
    void setUp() {
        Grant grant1= new Grant(null,"Estatal",20000D);
        Grant grant2= new Grant(null,"Autonómica",30000D);
        Grant grant3= new Grant(null,"Estatal",5000D);
        Grant grant4= new Grant(null,"Autonómica",900D);
        Grant grant5= new Grant(null,"Estatal",25000D);
        grantService.saveAll(List.of(
                grant1,
                grant2,
                grant3,
                grant4,
                grant5
        ));

        Student studen1=new Student(null,"estudiante 1",5, LocalDate.of(2010,3,20));
        Student studen2=new Student(null,"estudiante 2",5,LocalDate.of(2013,7,20));
        Student studen3=new Student(null,"estudiante 3",5,LocalDate.of(2008,8,20));
        Student studen4=new Student(null,"estudiante 4",5,LocalDate.of(2011,2,20));
        Student studen5=new Student(null,"estudiante 5",5,LocalDate.of(2004,4,20));
        Student studen6=new Student(null,"estudiante 6",5,LocalDate.of(2006,6,20));
        Student studen7=new Student(null,"estudiante 7",5,LocalDate.of(2009,3,20));
        studen1.setGrant(grant1);
        studen3.setGrant(grant2);
        studen5.setGrant(grant3);
        studen7.setGrant(grant4);
        studentService.saveAll(List.of(
                studen1,
                studen2,
                studen3,
                studen4,
                studen5,
                studen6,
                studen7
        ));

        Resource resource1 = new Resource(null,"laptop Lenovo",false);
        Resource resource2 = new Resource(null,"boli bic",true);
        Resource resource3 = new Resource(null,"tablet Nisu",false);
        Resource resource4 = new Resource(null,"compás",true);
        resource1.setStudent(studen1);
        resource2.setStudent(studen7);
        resource3.setStudent(studen3);
        resource4.setStudent(studen4);
        resourceService.saveAll(List.of(
                resource1,
                resource2,
                resource3,
                resource4
        ));

        Subject subject1= new Subject(null,"materia 1");
        subject1.setStudents(List.of(
                studen1,
                studen2,
                studen3,
                studen4
        ));
        Subject subject2= new Subject(null,"materia 2");
        subject2.setStudents(List.of(
                studen1,
                studen2,
                studen5,
                studen6
        ));
        subjectService.saveAll(List.of(
                subject1,
                subject2
        ));
    }

    @Test
    void entityGraphTest() { //TODO: NO funciona preguntar duda.
        Subject subject = subjectService.findByIdWithStudent(1L);
        System.out.println("RESULTADO");
        System.out.println(subject.getStudents());
    }

    @Test
    void paginationTest() {//OK pero con el repository no con el servicio
        Pageable page1 = PageRequest.of(0, 2);
        Page<Student> studentpage1 = studentService.findAllPageable(page1);//No funciona con el servicio
        List<Student> students = studentpage1.getContent();
        assertEquals(2, students.size());
        students.forEach(System.out::println);

        Pageable page2 = PageRequest.of(1, 2);
        Page<Student> studentpage2 = studentRepository.findAll(page2);//No funciona con el servicio
        List<Student> students2 = studentpage2.getContent();
        assertEquals(2, students2.size());
        students2.forEach(System.out::println);

        Pageable page3 = PageRequest.of(2, 2);
        Page<Student> studentpage3 = studentRepository.findAll(page3);//No funciona con el servicio
        List<Student> students3 = studentpage3.getContent();
        assertEquals(2, students3.size());
        students3.forEach(System.out::println);

        Pageable page4 = PageRequest.of(3, 2);
        Page<Student> studentpage4 = studentRepository.findAll(page4);//No funciona con el servicio
        List<Student> students4 = studentpage4.getContent();
        assertEquals(1, students4.size());
        System.out.println("RESULTADO");
        students4.forEach(System.out::println);

    }

    @Test
    void specsTest() {
        List<Student> students = studentService.findAllWithGrantAndBirthDateConditionSpecs();
        assertEquals(3,students.size());
        System.out.println("RESULTADO");
        students.forEach(s-> System.out.println(s));
    }

    @Test
    void entityManagerTest() {
        System.out.println("RESULTADO");
        List<Resource> resources = resourceDAO.findAllEntityManager();
        resources.stream().forEach(r-> System.out.println(r));
        assertEquals(4,resources.size());
    }
}