package net.hachyard.Student_Managment_System_For_Hatch.service.impl;

import net.hachyard.Student_Managment_System_For_Hatch.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentService {

	List<Student>getAllStudent();
        
    Student getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student newStudent);
    
    Student deleteStudent(Long id);
      
    Page<Student>getStudentByPage(Pageable pageable);

	List<Student> getAllStudents();
}

