package com.company.controller.handler;

import com.company.exception.ImageStoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

   private static  Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);


    @ExceptionHandler(ImageStoreException.class)
    public ModelAndView handleImageStoreException(HttpServletRequest req, ImageStoreException ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
//TODO implement exception message handler

}
