package net.hachyard.Student_Managment_System_For_Hatch.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException (Long id) {
    	super("Could not found the student with id" +""+ id);
    }
}
