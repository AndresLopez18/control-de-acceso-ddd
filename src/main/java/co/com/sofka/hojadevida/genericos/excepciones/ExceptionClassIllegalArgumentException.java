package co.com.sofka.hojadevida.genericos.excepciones;

public class ExceptionClassIllegalArgumentException extends IllegalArgumentException {
    public void exceptionIsBlank(String value, String mensaje){
        if(value.isBlank()){
            throw new IllegalArgumentException(mensaje);
        }
    }

    public void exceptionDontMathRegex(String value, String regex,String mensaje){
        if(!value.matches(regex)){
            throw new IllegalArgumentException(mensaje);
        }
    }
}
