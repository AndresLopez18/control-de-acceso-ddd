package co.com.sofka.hojadevida.rol;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.hojadevida.rol.valores.RolId;


public class Rol extends AggregateEvent<RolId> {


    public Rol(RolId entityId) {
        super(entityId);
    }
}
