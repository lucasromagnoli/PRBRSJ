package br.com.lucasromagnoli.prbrsj.rest.processor;

import br.com.lucasromagnoli.prbrsj.rest.constants.ControllerMapping;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getMethod().getName().equals("postAccessToken");
    }

    @Override
    public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter methodParameter,
                                             MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                             ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        HttpServletRequest request = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
        HttpServletResponse response = ((ServletServerHttpResponse) serverHttpResponse).getServletResponse();
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;

        String refreshToken = body.getRefreshToken().getValue();
        insertRefreshTokenInCookie(refreshToken, request, response);
        removeRefreshTokenFromBody(token);

        return body;
    }

    private void removeRefreshTokenFromBody(DefaultOAuth2AccessToken token) {
        token.setRefreshToken(null);
    }

    private void insertRefreshTokenInCookie(String refreshToken, HttpServletRequest request, HttpServletResponse response) {
        Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setSecure(false); // TODO: Mudar conforme variavel de ambiente + Criar uma classe SUPPORT para gerenciar os cookies
        refreshTokenCookie.setPath(request.getContextPath() + ControllerMapping.AUTH_TOKEN_GENERATE);
        refreshTokenCookie.setMaxAge(2592000); //TODO: Mudar para .properties

        response.addCookie(refreshTokenCookie);
    }
}
