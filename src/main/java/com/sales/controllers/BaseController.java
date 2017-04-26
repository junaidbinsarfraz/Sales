package com.sales.controllers;

import java.util.Map;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sales.exceptions.DefaultExceptionAttributes;
import com.sales.exceptions.ExceptionAttributes;

public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleException(Exception exception, HttpServletRequest request) {

		logger.error("> handleException");
		logger.error(" - Exception ", exception);

		ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

		Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(exception, request,
				HttpStatus.INTERNAL_SERVER_ERROR);

		logger.error("< handleException");

		return new ResponseEntity<Map<String, Object>>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<Map<String, Object>> handleNoResultException(NoResultException noResultException,
			HttpServletRequest request) {

		logger.error("> handleNoResultException");
		logger.error(" - Exception ", noResultException);

		ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();

		Map<String, Object> responseBody = exceptionAttributes.getExceptionAttributes(noResultException, request,
				HttpStatus.NOT_FOUND);

		logger.error("< handleNoResultException");

		return new ResponseEntity<Map<String, Object>>(responseBody, HttpStatus.NOT_FOUND);
	}

}
