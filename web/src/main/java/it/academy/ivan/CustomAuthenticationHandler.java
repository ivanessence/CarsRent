package it.academy.ivan;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Ivan on 06.07.2016.
 */
public class CustomAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {


    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        String userTargetUrl = "/user";
        String adminTargetUrl = "/main";
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("1")) {
            getRedirectStrategy().sendRedirect(request, response, adminTargetUrl);
        }
        else if(roles.contains("0")) {
            getRedirectStrategy().sendRedirect(request, response, userTargetUrl);
        }
        else {
            super.onAuthenticationSuccess(request, response, authentication);
            return;
        }
    }
}
