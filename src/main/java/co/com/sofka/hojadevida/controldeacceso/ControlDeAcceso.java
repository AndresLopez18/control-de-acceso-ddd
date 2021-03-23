package co.com.sofka.hojadevida.controldeacceso;

import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofka.hojadevida.controldeacceso.valores.ControlDeAccesoId;
import co.com.sofka.hojadevida.controldeacceso.valores.Login;
import co.com.sofka.hojadevida.genericos.values.Estado;
import co.com.sofka.hojadevida.rol.valores.RolId;

public class ControlDeAcceso extends AggregateRoot<ControlDeAccesoId> {
    private Login login;
    private Estado estado;
    private final RolId rolId;

    private ControlDeAcceso(ControlDeAccesoId controlDeAccesoId, Login login, Estado estado, RolId rolId) {
        super(controlDeAccesoId);
        this.login = login;
        this.estado = estado;
        this.rolId = rolId;
    }

    public void asociarRolParaLogin() {

    }

    public void activarLogin() {
        if (this.estado.equals(true)){
            throw new IllegalArgumentException("Este login ya esta activado");
        }else{
            this.estado=new Estado(true);
        }

    }

    public void desactivarLogin() {
        if (this.estado.equals(false)){
            throw new IllegalArgumentException("Este login ya esta desactivado");
        }else{
            this.estado=new Estado(false);
        }

    }


}
