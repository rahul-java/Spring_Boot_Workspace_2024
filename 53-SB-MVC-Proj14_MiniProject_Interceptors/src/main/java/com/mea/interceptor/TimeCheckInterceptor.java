package com.mea.interceptor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (!request.getServletPath().equals("/")) {
			// get system date and time
			LocalDateTime ldt = LocalDateTime.now();
			int hour = ldt.getHour();
			if (hour < 9 || hour >= 17) {
				RequestDispatcher rd = request.getRequestDispatcher("/timeout.jsp");
				rd.forward(request, response);
				return false;
			} else
				return true;

		}
		else {
			return true;
		}
	}
}
