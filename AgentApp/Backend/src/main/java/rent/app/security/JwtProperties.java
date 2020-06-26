package rent.app.security;

public class JwtProperties {

    public static final String SECRET = "agentApp123"; //sluzi za dekodiranje jwt tokena
    public static final int EXPIRATION_TIME = 864000000;//10 days (koliko traje jwt token)
    public static final String TOKEN_PREFIX = "Bearer "; //prefix za jwt token
    public static final String HEADER_STRING =  "Authorization"; //naziv atributa u headeru requesta

}
