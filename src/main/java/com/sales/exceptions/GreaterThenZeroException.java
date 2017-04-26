package com.sales.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.LENGTH_REQUIRED, reason="")
public class GreaterThenZeroException extends Exception {

}
