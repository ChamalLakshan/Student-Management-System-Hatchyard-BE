package net.hachyard.Student_Managment_System_For_Hatch.service.impl;

import net.hachyard.Student_Managment_System_For_Hatch.exception.StudentNotFoundException;
import net.hachyard.Student_Managment_System_For_Hatch.model.Student;
import net.hachyard.Student_Managment_System_For_Hatch.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{
@Autowired
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
	public List<Student> getAllStudent() {
		 return studentRepository.findAll();
	}
    @Override
    public Page<Student>getStudentByPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
    @Override
    public Student updateStudent(Long id, Student newStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setEmail(newStudent.getEmail());
                    return studentRepository.save(student);
                }).orElseThrow(() -> new StudentNotFoundException(id));
    }

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
		
	}

	@Override
	public Student createStudent(Student student) {		
		return studentRepository.save(student) ;
	}

	 @Override
	    public Student deleteStudent(Long id) {
	        if (!studentRepository.existsById(id)) {
	            throw new StudentNotFoundException(id);
	        }
	        studentRepository.deleteById(id);
			return null;
	    }

	

}
