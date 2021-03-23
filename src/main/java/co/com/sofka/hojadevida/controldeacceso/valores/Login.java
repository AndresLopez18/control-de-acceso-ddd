package co.com.sofka.hojadevida.controldeacceso.valores;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.hojadevida.genericos.excepciones.ExceptionClassIllegalArgumentException;

import java.util.Map;
import java.util.Objects;

public class Login implements ValueObject<Map<String, Object>> {
    private static final String TELEFONO_REGEX = "[\\d]{7}\\|{10}";

    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final Email email;
    private final String token;

    public Login(String nombre, String apellido, String telefono, Email email, String token) {
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        this.telefono = Objects.requireNonNull(telefono);
        this.email = Objects.requireNonNull(email);
        this.token = Objects.requireNonNull(token);

        ExceptionClassIllegalArgumentException exceptionClassIllegalArgumentException = new ExceptionClassIllegalArgumentException();
        exceptionClassIllegalArgumentException.exceptionIsBlank(this.nombre, "El nombre debe contener caracteres");
        exceptionClassIllegalArgumentException.exceptionIsBlank(this.apellido, "El apellido debe contener caracteres");
        exceptionClassIllegalArgumentException.exceptionDontMathRegex(this.telefono, TELEFONO_REGEX,
                "El telefono debe contener caracteres y deben ser exactamente 7 o 10 números");
    }

    @Override
    public Map<String, Object> value() {
        return Map.of(
                "nombre", nombre,
                "apellido", apellido,
                "telefono", telefono,
                "email", email,
                "token", token
        );
    }
}
