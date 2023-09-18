package com.project.AudioDescriptionManager.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Date timestamp;
    private  String message;
    private  String details;

}
