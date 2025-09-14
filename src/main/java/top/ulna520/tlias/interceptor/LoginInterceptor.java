package top.ulna520.tlias.interceptor;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.ulna520.tlias.service.UserService;
import top.ulna520.tlias.util.JwtUttil;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUttil jwtUttil;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String url = req.getRequestURL().toString();
        if ("/login".equals(url)) {
            return true;
        }
        String token = req.getHeader("token");
        if (token == null || token.equals("")) {
            resp.sendRedirect("/login");
            return false;
        }
        try {
            boolean valid = jwtUttil.validateJwt(token);
            if(!valid){
                resp.sendRedirect("/login");
                return false;
            }
        }
        catch (Exception e) {
            resp.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
