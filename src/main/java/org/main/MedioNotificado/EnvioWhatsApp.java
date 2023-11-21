package org.main.MedioNotificado;

public class EnvioWhatsApp implements MedioNotificado{
    @Override
    public void enviarNotificacion() {

    }

    @Override
    public String nombre() {
        return "WhatsApp";
    }
}
