package com.scglab.iris.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.scglab.iris.base.annotations.Authority;

@Component
public class BaseInterceptor implements HandlerInterceptor {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		Authority authority;
		try {
			// 권한 어노테이션 존재여부 확인.
			authority = ((HandlerMethod)handler).getMethodAnnotation(Authority.class);
		} catch (Exception e) {
			authority = null;
		}
		
		// 접근권한 확인
		if(authority != null) {
			
			// 나의 Role 조회
			Authority.Role myRole = Authority.Role.ADMIN;
			
			// 관리자만 접근 가능.
			if(authority.role() == Authority.Role.ADMIN) {
				
				// 관리자가 아닐 경우.
				if(myRole != Authority.Role.ADMIN) {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "접근권한이 없습니다.");
					return false;
				}
				
			
			// 멤버 이상 접근 가능.
			}else if(authority.role() == Authority.Role.MEMBER) {

				// 멤버 또는 관리자가 아닐경우.
				if(myRole != Authority.Role.ADMIN && myRole != Authority.Role.MEMBER) {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "접근권한이 없습니다.");
					return false;
				}
				
			}
		}
		
		return true;
	}
	
	
}
