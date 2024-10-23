package com.app.exc_handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ErrorResponse;
 @ControllerAdvice//mandatory class level annotation
 //to tell spring container that following class is a  GlobalExceptionHandler which will offer common  ADVICE to your controller layer regarding exception handling
 //after adding this class: Controller classes will contain:req handling logic
 //class below contain: exc handling logic --resulting into separation of concerns(task)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	 //Replacing spring containers default exception handling by ours  
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
// Goal: send detailed err messages regarding validation failures
		StringBuilder sb =new StringBuilder("Validation err messages");
		ex.getBindingResult().getFieldErrors().forEach(fieldErr-> sb.append(fieldErr.getDefaultMessage()));
		System.out.println(sb);//err messages
		ErrorResponse resp=new ErrorResponse(sb.toString(), LocalDateTime.now()) ;
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		
	}
	//add new exc handler method  to catch specifiaclly :custom Exce:ResourceNotFound
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		System.out.println("in handle res not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage(), LocalDateTime.now()));
	}

	 //for all other exceptions: add common exception handling method.equivalent to catch all
	@ExceptionHandler(RuntimeException.class)//argument of a class whose instance we have to catch 
	//to tell container it is exception handling method
	public ResponseEntity<?> handleRuntimeException(RuntimeException e)
	{
		System.out.println("in handle runtime exception "+e);
		//send error response(DTO) wrapped in response entity
		ErrorResponse resp=new ErrorResponse("something went wrong: "+e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
	}
}
