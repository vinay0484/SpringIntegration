package com.knack.Filters;


	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.web.servlet.HandlerInterceptor;
	import org.springframework.web.servlet.ModelAndView;
	 
	public class AuthFilter implements HandlerInterceptor
	{
	    public boolean preHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler) throws Exception {
	 String auth=request.BASIC_AUTH;
	 System.out.println(auth);
	        System.out.println("Inside pre handle");
	        return true;
	    }
	 
	    public void postHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	 
	        System.out.println("Inside post handle");
	    }
	 
	    public void afterCompletion(HttpServletRequest request,
	            HttpServletResponse response, Object handler, Exception exception)
	            throws Exception {
	 
	        System.out.println("Inside after completion");
	    }
	}