package com.example;

import com.example.model.Grant;
import com.example.model.Resource;
import com.example.model.Student;
import com.example.model.Subject;
import com.example.repositories.GrantRepository;
import com.example.repositories.ResourceRepository;
import com.example.repositories.StudentRepository;
import com.example.repositories.SubjectRepository;
import com.example.service.GrantService;
import com.example.service.ResourceService;
import com.example.service.StudentService;
import com.example.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

	static Logger log= LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

		StudentService studentService= context.getBean(StudentService.class);
		GrantService grantService= context.getBean(GrantService.class);
		SubjectService subjectService= context.getBean(SubjectService.class);
		ResourceService resourceService= context.getBean(ResourceService.class);

		cargaDeDatos(context);

		studentService.findAllStudentsWithoutGrant().stream().forEach(s-> System.out.println(s));


		studentService.findAllStudentsWithoutResources().stream().forEach(s-> System.out.println(s));

		studentService.findAllStudentsWithoutSubjects().stream().forEach(s-> System.out.println(s));


		//---------------------------------------------------

		grantService.insertGrant(500000D,"Excelencia");
		grantService.updateQuantity(4L,450000D);
		grantService.findAll().stream().forEach(g-> System.out.println(g));

		//--------------------------------------------------------

		resourceService.fixResource(1L);
		resourceService.findAll().stream().forEach(r-> System.out.println(r));


		//----------------------------------
		System.out.println(subjectService.findByIdWithStudent(1L));

	}


	private static void cargaDeDatos(ConfigurableApplicationContext context){

		StudentRepository studentRepository= context.getBean(StudentRepository.class);
		GrantRepository grantRepository=context.getBean(GrantRepository.class);
		ResourceRepository resourceRepository=context.getBean(ResourceRepository.class);
		SubjectRepository subjectRepository=context.getBean(SubjectRepository.class);


		Grant grant1= new Grant(null,"Estatal",20000D);
		Grant grant2= new Grant(null,"Autonómica",30000D);
		Grant grant3= new Grant(null,"Estatal",5000D);
		Grant grant4= new Grant(null,"Autonómica",900D);
		Grant grant5= new Grant(null,"Estatal",25000D);
		grantRepository.saveAll(List.of(
				grant1,
				grant2,
				grant3,
				grant4,
				grant5
		));

		Student studen1=new Student(null,"estudiante 1",5,LocalDate.of(2010,3,20));
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
		studentRepository.saveAll(List.of(
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
		resourceRepository.saveAll(List.of(
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
		subjectRepository.saveAll(List.of(
				subject1,
				subject2
		));


	}
}
