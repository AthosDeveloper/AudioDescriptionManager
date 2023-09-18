package com.project.AudioDescriptionManager.service.exceptions.handdlerException;

import com.project.AudioDescriptionManager.service.exceptions.ExceptionResponse;
import com.project.AudioDescriptionManager.service.exceptions.ResourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice

public class CustomizedHanddlerException extends  ResponseEntityExceptionHandler{
@ExceptionHandler(Exception.class)
    public  final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
    ExceptionResponse responce = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(responce, HttpStatus.INTERNAL_SERVER_ERROR);
}
@ExceptionHandler(ResourseNotFoundException.class)
public final ResponseEntity<ExceptionResponse> objectNotFound (Exception ex, WebRequest request){
    ExceptionResponse rresponse =  new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return  new ResponseEntity<>(rresponse, HttpStatus.NOT_FOUND);
}
}


