package com.zwen.passbook.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zwen.passbook.vo.ErrorInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Global Exception Handler</h1>
 * 6-12
 */

@ControllerAdvice // Spring will scan it and inject methods into container
public class GlobalExceptionHandler {

    @ResponseBody // Restful type response. Convert response to json and send it to client
    @ExceptionHandler(value = Exception.class) // As long as there is a general exception, this method will be called
    public ErrorInfo<String> errorHandler(HttpServletRequest request, Exception ex) throws Exception {

        ErrorInfo<String> info = new ErrorInfo<String>();

        info.setCode(ErrorInfo.ERROR);
        info.setMessage(ex.getMessage());
        info.setData("Do not have return data");
        info.setUrl(request.getRequestURL().toString());

        return info;
    }
}
