package org.main.converter;

import org.main.MedioNotificado.EnvioMail;
import org.main.MedioNotificado.EnvioWhatsApp;
import org.main.MedioNotificado.MedioNotificado;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class MedioNotificadoConverter implements AttributeConverter<MedioNotificado, String> {
    @Override
    public String convertToDatabaseColumn(MedioNotificado medioNotificado) {
        if (medioNotificado == null) {
            return null;
        }
        return medioNotificado.nombre();
    }

    @Override
    public MedioNotificado convertToEntityAttribute(String dbData) {
        if(Objects.equals(dbData, "WhatsApp")){
            return new EnvioWhatsApp();
        }
        if(dbData.equals( "Mail")){
            return new EnvioMail();
        }
        return null;
    }
}
