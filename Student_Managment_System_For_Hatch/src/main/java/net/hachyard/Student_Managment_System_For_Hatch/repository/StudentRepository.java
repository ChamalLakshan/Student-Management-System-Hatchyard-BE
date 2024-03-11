package net.hachyard.Student_Managment_System_For_Hatch.repository;

import net.hachyard.Student_Managment_System_For_Hatch.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	public List<Student> findAllByOrderByIdAsc();

	@Query(value = "SELECT * FROM Student s WHERE " +
			"(:firstName IS NULL OR s.first_name = :firstName) AND " +
			"(:lastName IS NULL OR s.last_name = :lastName) AND " +
			"(:email IS NULL OR s.email = :email)",nativeQuery = true)
	public List<Student> searchStudents(String firstName, String lastName, String email);

	@Query(value = "SELECT * FROM students s WHERE s.first_name = :firstName",nativeQuery = true)
	List<Student> searchStudentByFirstName(@Param("firstName") String firstName);

	@Query(value = "SELECT * FROM students s WHERE s.last_name = :lastName",nativeQuery = true)
	List<Student> searchStudentByLastName(@Param("lastName") String lastName);


	@Query(value = "SELECT * FROM students s WHERE s.email = :email",nativeQuery = true)
	List<Student> searchStudentByEmail(@Param("email") String email);

	Page<Student>findAllByEmail(String email, Pageable pageable);
	
	
}
