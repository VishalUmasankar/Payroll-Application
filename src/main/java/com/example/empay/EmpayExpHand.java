package com.example.empay;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmpayExpHand {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EmpayExpHand.class);

    private static final String message = "Exception while processing REST Request";

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
    	log.error("Invalid Date Format!", exception);
        ResponseDTO responseDTO = new ResponseDTO(message, "Should have date in the format dd MMM McDermott");
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errorMessage = errorList.stream()
                                            .map(objErr -> objErr.getDefaultMessage())
                                            .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message, errorMessage);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(
            EmployeePayrollException exception) {
        log.error("Employee Payroll Exception: {}", exception.getMessage()); // Log the specific exception message
        ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage()); // Return the custom message
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST); // Or HttpStatus.INTERNAL_SERVER_ERROR depending on your error handling policy
    }
}