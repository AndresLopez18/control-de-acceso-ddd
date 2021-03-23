package co.com.sofka.hojadevida.controldeacceso.valores;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.hojadevida.genericos.excepciones.ExceptionClassIllegalArgumentException;

import java.util.Map;
import java.util.Objects;

public class Email implements ValueObject<Map<String, String>> {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9](_(?!(\\.|_))|\\.(?!(_|\\.))|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]@(sofka)\\.com.co(\\W|$)";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9](_(?!(\\.|_))|\\.(?!(_|\\.))|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$";
    private static final String DOMINIO_REGEX = "^(sofka.com.co)$";

    private String username;
    private String dominio;

    public Email(String username, String dominio) {
        this.username = Objects.requireNonNull(username);
        this.dominio = Objects.requireNonNull(dominio);

        ExceptionClassIllegalArgumentException exceptionClassIllegalArgumentException = new ExceptionClassIllegalArgumentException();
        exceptionClassIllegalArgumentException.exceptionDontMathRegex(this.username, USERNAME_REGEX,"El username indicado no es valido");
        exceptionClassIllegalArgumentException.exceptionDontMathRegex(this.dominio, DOMINIO_REGEX,"El dominio indicado no es valido");
    }

    @Override
    public Map<String, String> value() {
        return Map.of(
                "username", username,
                "dominio", dominio
        );
    }

    public static String getEmailRegex() {
        return EMAIL_REGEX;
    }

    public String concatEmail(){
        String email = username + "@" + dominio;
        if(!email.matches(getEmailRegex())){
            return "El email indicado no pertenece a la compañia";
        }
        return email;
    }
}
