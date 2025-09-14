package edu.uptc.Entidades;

import java.time.LocalDate;

public class Odontologia extends ServicioMedico{
    private String implementosUsados;

    public Odontologia(LocalDate fechaDeAtencion, Medico medicoResponsable, String implementosUsados) {
        super();
        this.implementosUsados = implementosUsados;
    }

    public Odontologia(String implementosUsados) {
        this.implementosUsados = implementosUsados;
    }

    public String getImplementosUsados() {
        return implementosUsados;
    }

    public void setImplementosUsados(String implementosUsados) {
        this.implementosUsados = implementosUsados;
    }
    
}
