package co.com.sofka.hojadevida.genericos.values;

import co.com.sofka.domain.generic.ValueObject;

public class Estado implements ValueObject<Boolean> {
    private final boolean estado;

    public Estado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public Boolean value() {
        return estado;
    }



}
