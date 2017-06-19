package com.imobiliare.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.JwtException;

import java.io.IOException;

@WebFilter(urlPatterns = { "/v1/announcements/post", "/v1/announcements/myAnnouncements", "/v1/users/*", "/v1/auth/verify", "/v1/favourites", "/v1/favourites/*", "/v1/meetings/*"  })
public class JwtFilter implements Filter {
	@Autowired
	private JwtService jwtTokenService;

	@Value("${jwt.auth.header}")
	String authHeader;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletResponse httpResponse = (HttpServletResponse) response;
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final String authHeaderVal = httpRequest.getHeader(authHeader);

		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		httpResponse.setHeader("Access-Control-Max-Age", "3600");
		httpResponse.setHeader("Access-Control-Allow-Headers", "authorization, content-type, token");
		httpResponse.addHeader("Access-Control-Expose-Headers", "token");

		if (null == authHeaderVal) {
			if ("OPTIONS".equals(httpRequest.getMethod())) {
				httpResponse.setStatus(HttpServletResponse.SC_OK);
				return;
			}
			httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return;
		}

		try {
			JwtUser jwtUser = jwtTokenService.getUser(authHeaderVal);
			httpRequest.setAttribute("jwtUser", jwtUser);
		} catch (JwtException e) {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		chain.doFilter(httpRequest, httpResponse);
	}
}