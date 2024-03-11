package net.hachyard.Student_Managment_System_For_Hatch.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String> exceptionHandler(StudentNotFoundException exception){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage",exception.getMessage());
		return errorMap;
	}

}