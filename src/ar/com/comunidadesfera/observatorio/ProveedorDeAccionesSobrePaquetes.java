package ar.com.comunidadesfera.observatorio;

import ar.com.comunidadesfera.observatorio.jdt.AbrirAsistenteCrearClaseJava;

public class ProveedorDeAccionesSobrePaquetes extends ProveedorDeAccionesObservatorio {

    @Override
    protected void addActions() {

        actions.add(new AbrirAsistenteCrearClaseJava());
    }

}
