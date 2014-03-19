package pl.byd.wsg.promand.project4;

/**
 * Created by Paladin on 3/19/14.
 */
public class Config {

    public static String LINKEDIN_CONSUMER_KEY = "75bvl5uwz25stv";
    public static String LINKEDIN_CONSUMER_SECRET = "5iDLzOlllSGIqq3s";
    public static String scopeParams = "rw_nus+r_fullprofile";

    public static String OAUTH_CALLBACK_SCHEME = "x-oauthflow-linkedin";
    public static String OAUTH_CALLBACK_HOST = "callback";
    public static String OAUTH_CALLBACK_URL = OAUTH_CALLBACK_SCHEME + "://" + OAUTH_CALLBACK_HOST;
}
