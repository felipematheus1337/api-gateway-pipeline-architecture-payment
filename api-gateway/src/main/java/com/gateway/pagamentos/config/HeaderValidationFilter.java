package com.gateway.pagamentos.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HeaderValidationFilter extends OncePerRequestFilter {

    private static final String HEADER_NAME = "X-API-KEY";
    private static final String EXPECTED_VALUE = "gateway-pipeline";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException,
            IOException {

        String apiKey = request.getHeader(HEADER_NAME);

        if(apiKey == null || !EXPECTED_VALUE.equals(apiKey)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("""
                    {
                    "status": 401,
                    "error: "Unauthorized,
                    "message": "Missing or invalid X-API-KEY
                    }
                    """);
        }

        filterChain.doFilter(request, response);

    }
}
