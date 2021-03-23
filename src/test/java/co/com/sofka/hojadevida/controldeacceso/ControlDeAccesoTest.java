package co.com.sofka.hojadevida.controldeacceso;

import co.com.sofka.hojadevida.controldeacceso.valores.ControlDeAccesoId;
import co.com.sofka.hojadevida.controldeacceso.valores.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ControlDeAccesoTest{

    @Test
    @Order(1)
    public void verificarEmailSofka(){
        Email email = new Email("daniela.diaz", "sofka.com.co");
        Assertions.assertEquals("daniela.diaz@sofka.com.co", email.concatEmail());
    }


}
