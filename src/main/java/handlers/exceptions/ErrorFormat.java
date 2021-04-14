package handlers.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorFormat {
	
	private Integer status;
	private LocalDateTime dateHour;
	private String message;
	private List<ErrorField> errorFields;
	
	
	
	
	public ErrorFormat() {
		super();
	}
	
	public ErrorFormat(Integer status, LocalDateTime dateHour, String message, List<ErrorField> errorFields) {
		super();
		this.status = status;
		this.dateHour = dateHour;
		this.message = message;
		this.errorFields = errorFields;
	}

	public static class ErrorField{
		private String name;
		private String message;
		
		
		
		public ErrorField(String name, String message) {
			super();
			this.name = name;
			this.message = message;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
	}
	

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDateHour() {
		return dateHour;
	}
	public void setDateHour(LocalDateTime dateHour) {
		this.dateHour = dateHour;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ErrorField> getErrorFields() {
		return errorFields;
	}
	public void setErrorFields(List<ErrorField> errorFields) {
		this.errorFields = errorFields;
	}
	
	

}
