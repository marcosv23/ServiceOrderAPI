package handlers.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import exceptions.BusinessException;

@ControllerAdvice
@JsonInclude(Include.NON_NULL)
//@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(BusinessException exception, WebRequest request) {
		var statusCode = HttpStatus.BAD_REQUEST;
		var  errorFormat = new ErrorFormat();
		
		errorFormat.setMessage(exception.getMessage());
		errorFormat.setStatus(statusCode.value());
		errorFormat.setDateHour(LocalDateTime.now());
		errorFormat.setErrorFields(null);
		
		return handleExceptionInternal(exception, errorFormat, new HttpHeaders(), statusCode, request);
		
	}
	
	@Autowired
	private MessageSource messageSource; 
	// interface to resolve messages from src/main/resource/messages.properties
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
         
		ErrorFormat errorFormat = new ErrorFormat();
		
		var errorFields =new ArrayList<ErrorFormat.ErrorField>();
		
		for (ObjectError error: ex.getBindingResult().getAllErrors()) {
			
		   //String message = error.getDefaultMessage(); not translated
			
			
			 String message= messageSource.getMessage(error, LocaleContextHolder.getLocale());
		   String fieldName = ((FieldError)error).getField();
		   errorFields.add(new ErrorFormat.ErrorField(fieldName,message));
		   
		}
		
		
		
		errorFormat.setMessage("Há Campos faltantes e/ou não preenchidos corretamente");
		errorFormat.setDateHour(LocalDateTime.now());
		errorFormat.setStatus(status.value());
		errorFormat.setErrorFields(errorFields);
												   /*errorFormat is the 'body' into 
												     handleExceptionInternal implementation
												    */
		  return super.handleExceptionInternal(ex, errorFormat, headers, status, request);
	}

}

	// Generic  messages for all exceptions, not recommended!
   /* @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
    	
    		var statusCode = HttpStatus.BAD_REQUEST;
    		var errorFormat = new ErrorFormat();
    		
    		errorFormat.setCustomMessage("Há campos inválidos!");
    		errorFormat.setStatus(status.value());
    		errorFormat.setHour(OffsetDateTime.now());
    		errorFormat.setFields(null);
    	 
    	return super.handleExceptionInternal(ex, errorFormat, headers, status, request);
    }*/
	
