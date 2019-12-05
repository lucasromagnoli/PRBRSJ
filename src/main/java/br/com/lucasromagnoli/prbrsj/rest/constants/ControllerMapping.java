package br.com.lucasromagnoli.prbrsj.rest.constants;

public class ControllerMapping {

    public static final String PATH_ROOT_USER                       = "/user";
    public static final String PATH_ROOT_OAUTH                      = "/oauth";
    public static final String PATH_ROOT_AUTH_TOKEN                 = "/auth/token";

    public static final String PATH_AUTH_TOKEN                      = "/token";
    public static final String PATH_AUTH_TOKEN_REVOKE               = "/revoke";
    public static final String PATH_AUTH_TOKEN_GENERATE             = "/generate";
    public static final String PATH_USER_LIST                       = "/list";

    public static final String OAUTH_TOKEN                          = PATH_ROOT_OAUTH+PATH_AUTH_TOKEN;
    public static final String AUTH_TOKEN_GENERATE                  = PATH_ROOT_AUTH_TOKEN+PATH_AUTH_TOKEN_GENERATE;
}
