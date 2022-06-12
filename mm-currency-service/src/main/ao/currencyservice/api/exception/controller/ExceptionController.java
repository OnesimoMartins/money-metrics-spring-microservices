package ao.currencyservice.api.exception.controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ao.currencyservice.api.exception.model.ExceptionModel;
import ao.currencyservice.domain.exception.CourrencyNotFoundException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		System.out.println("ETTRO \n\n\n\n");
		if (body == null) {
			body = ExceptionModel.builder().message(ex.getLocalizedMessage()).timestamp(OffsetDateTime.now())
					.status(status.value()).tittle(status.getReasonPhrase()).build();
		} else if (body instanceof String)
			body = ExceptionModel.builder().timestamp(OffsetDateTime.now()).tittle((String) body).status(status.value())
					.build();
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@ExceptionHandler(CourrencyNotFoundException.class)
	public ResponseEntity<?> handleCurrencyNotFoundException(CourrencyNotFoundException ex, WebRequest req) {
		var body = ExceptionModel.builder().tittle("Currency was not found").message(ex.getMessage())
				.status(404)
				.timestamp(OffsetDateTime.now()).build();
		return this.handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, req);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		var body = ExceptionModel.builder().tittle("handler not found")
				.message("there is not handler " + ex.getHttpMethod() + " for " + " ' " + ex.getRequestURL() + "' Url")
				.status(404).build();
		
		return this.handleExceptionInternal(ex, body, headers, HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleExceptionCustomized(Exception ex, WebRequest req) {
		var body = ExceptionModel.builder().tittle("Internal Error").timestamp(OffsetDateTime.now())
				.message("this service is temporary down, try again later")
				.status(500).build();
		return this.handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, req);
	}
}
