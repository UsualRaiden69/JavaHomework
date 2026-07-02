package org.example.javawebapp_vadzim.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.javawebapp_vadzim.exception.DuplicateRequestException;
import org.example.javawebapp_vadzim.repository.RequestKeyRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class IdempotencyFilter implements Filter {

    private final RequestKeyRepository repository;

    public IdempotencyFilter(RequestKeyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String key = req.getHeader("Idempotency-Key");

        if (key != null) {
            if (repository.exists(key)) {
                throw new DuplicateRequestException("Duplicate request");
            }
            repository.save(key);
        }

        chain.doFilter(request, response);
    }
}