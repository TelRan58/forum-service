package telran.java58.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class ExpiredPasswordFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isPasswordExpired = auth != null && auth.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_PASSWORD_EXPIRED"));
        if (isPasswordExpired && !request.getRequestURI().equals("/account/password")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Password expired");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
