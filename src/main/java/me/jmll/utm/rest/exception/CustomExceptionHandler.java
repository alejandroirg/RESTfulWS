package me.jmll.utm.rest.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import me.jmll.utm.model.ErrorInfo;
import me.jmll.utm.model.Errors;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Errors handleNotFound(HttpServletRequest req, HttpServletResponse res, ResourceNotFoundException e) {
		Errors errors = new Errors();
		errors.addError(new ErrorInfo(req.getRequestURL().toString(), HttpStatus.NOT_FOUND.toString(), e));
		return errors;
	}

	/**
	 * 3 metodo handleNotAllowed para manejar la excepción
	 * MethodNotAllowedException
	 */
	@ExceptionHandler(MethodNotAllowedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public Errors handleNotAllowed(HttpServletRequest req, HttpServletResponse res, MethodNotAllowedException e) {
		Errors errors = new Errors();
		errors.addError(new ErrorInfo(req.getRequestURL().toString(), HttpStatus.METHOD_NOT_ALLOWED.toString(), e));
		return errors;
	}
}
