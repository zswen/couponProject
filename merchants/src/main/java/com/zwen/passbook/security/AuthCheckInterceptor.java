package com.zwen.passbook.security;

import com.zwen.passbook.constant.Constants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>Http request authentication</h2>
 * 5-4
 */

@Component // Spring bean
public class AuthCheckInterceptor implements HandlerInterceptor { // preprocess, posprocess of a http request
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader(Constants.TOKEN_STRING);

        if (StringUtils.isEmpty(token)) {
            throw new Exception("Header 中缺少 " + Constants.TOKEN_STRING + " !");
        }

        if (!token.equals(Constants.TOKEN)) {
            throw new Exception("Header 中" + Constants.TOKEN_STRING + "错误！");
        }

        AccessContext.setToken(token);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        AccessContext.clearAccessKey();
    }
}
