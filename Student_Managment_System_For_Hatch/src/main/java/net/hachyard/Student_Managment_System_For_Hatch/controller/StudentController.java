package net.hachyard.Student_Managment_System_For_Hatch.controller;

import net.hachyard.Student_Managment_System_For_Hatch.exception.StudentNotFoundException;
import net.hachyard.Student_Managment_System_For_Hatch.model.PageRequestDto;
import net.hachyard.Student_Managment_System_For_Hatch.model.Student;
import net.hachyard.Student_Managment_System_For_Hatch.repository.StudentRepository;
import net.hachyard.Student_Managment_System_For_Hatch.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/sms")
@CrossOrigin(origins = "*")
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/search")
	public Page<Student>getAllStudentByPagination(@RequestBody PageRequestDto dto){
		
		Pageable pageable=new PageRequestDto().getPageble(dto);
		Page<Student>studentPage=studentRepository.findAll(pageable);
		return studentPage;
	}

	@PostMapping("/queryMethod/{email}")
	public Page<Student>getAllStudentByPaginationQueryMethod(@RequestBody PageRequestDto dto,
			@PathVariable(value = "email")String email){
		Pageable pageable=new PageRequestDto().getPageble(dto);
		Page<Student>studentPage=studentRepository.findAllByEmail(email, pageable);
		return studentPage;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@PostMapping("/student")
	Student newStudent(@RequestBody Student newStudent) {
		return studentRepository.save(newStudent);
	}

	@GetMapping("/student/{id}")
	Student getStudentById(@PathVariable Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(id));
	}

	@PutMapping("/student/{id}")
	Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {
	return studentService.updateStudent(id, newStudent);
	}

	@DeleteMapping("/student/{id}")
	String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "Student with id " + id + " has been deleted success.";
	}
}