package com.richasha.musicpostbackend.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.text.MessageFormat;

@Slf4j
@Order(Integer.MIN_VALUE)
@Component
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        long timeTaken = System.currentTimeMillis() - startTime;

        log.info(MessageFormat.format(
                "#Request: Method={0}, URI={1}; #Response: ResponseStatus={2}; #TimeTaken: {3}",
                request.getMethod(), request.getRequestURI(), response.getStatus(), timeTaken));

    }
}
