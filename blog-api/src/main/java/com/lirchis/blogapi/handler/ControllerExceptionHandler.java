package com.lirchis.blogapi.handler;

import com.lirchis.blogapi.exception.NotFoundException;
import com.lirchis.blogapi.exception.PersistenceException;
import com.lirchis.blogapi.model.vo.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(NotFoundException.class)
    public R notFoundExceptionHandler(HttpServletRequest request, NotFoundException e) {
        logger.error("Request URL : {}, Exception :", request.getRequestURL(), e);
        return R.create(404, e.getMessage());
    }

    @ExceptionHandler(PersistenceException.class)
    public R persistenceExceptionHandler(HttpServletRequest request, PersistenceException e) {
        logger.error("Request URL : {}, Exception :", request.getRequestURL(), e);
        return R.create(500, e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public R exceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("Request URL : {}, Exception :", request.getRequestURL(), e);
        return R.create(500, "异常错误");
    }
}
