package com.ziv.springboot.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ziv.springboot.tools.Const;

public class WebInterceptor implements HandlerInterceptor{
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		//在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		//请求处理之后进行调用，但是在视图被渲染之前
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String path = request.getServletPath();
		if(path.matches(Const.NO_INTERCEPTOR_PATH)){
			return true;
		}
		if(Objects.nonNull((request.getSession().getAttribute(Const.SESSION_USER)))){
			return true;
		}
		response.sendRedirect(request.getContextPath()+Const.LOGIN_URI);
		return false;
	}

}
