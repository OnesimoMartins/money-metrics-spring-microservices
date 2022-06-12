//package ao.accountservice.api.exceptionhandler;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.NoHandlerFoundException;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import ao.accountservice.domain.exception.AccountNotFound;
//import ao.accountservice.domain.service.AccountService;
//
//@ControllerAdvice
//public class ExceptionController extends ResponseEntityExceptionHandler {
//	final String uri = "http://www.moneymetrics.co.ao";
//	@Autowired private AccountService accountService;
//
//	@ExceptionHandler(AccountNotFound.class)
//	 public ResponseEntity<?> handleAccountNotFound(AccountNotFound ex,WebRequest req){
//		var status=	HttpStatus.NOT_FOUND;
//		var problemModel=ProblemModel.builder().details(ex.getMessage())
//				.type(uri+"/resource-not-found").status(status.value())
//				.tittle("resource-not-found").build();
//		return handleExceptionInternal(ex, problemModel, new HttpHeaders(), status, req); 
//	}
//	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		List<ValidationErrorObject> errors=new ArrayList<>();
//				
////				ex.getFieldErrors().stream().map(
////				  e->{if(e.getField()=="username") {
////					
////				  }
////					
////				})
//		var l=accountService.getUsernameSuggestions("Katila");
//		l.forEach(System.out::println);;
//		
//		var problem=ProblemModel.builder().errorFields(null).build();
//		
//		return handleExceptionInternal(ex, problem, headers, status, request);
//		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
//	}
//	
//	public ResponseEntity<?> handleValidationError(Exception ex,WebRequest req,BindingResult errors){
//		return null;//handleExceptionInternal(ex, body, headers, status, request)
//	}
////	@Override
////	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
////			HttpStatus status, WebRequest request) {
////	
//////		if(body==null) {
//////			var problemModel=ProblemModel.builder()
//////					.details(ex.getMessage()).tittle(status.getReasonPhrase())
//////					.build();
//////			return super.handleExceptionInternal(ex, problemModel, headers, status, request);
//////		}else if(body instanceof String) {
//////			var problemModel=ProblemModel.builder()
//////					.details((String)body).tittle(status.getReasonPhrase())
//////					.build();
//////			return super.handleExceptionInternal(ex, problemModel, headers, status, request);
//////			
//////		}
////		return super.handleExceptionInternal(ex, body, headers, status, request);
////	}
//	
//	
//	@Override
//	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//
//		var problemModel=ProblemModel.builder()
//				.details("invalid Uri").tittle("xxx")
//				.build();
//		return super.handleExceptionInternal(ex, problemModel, headers, status, request);
//	}
//}
