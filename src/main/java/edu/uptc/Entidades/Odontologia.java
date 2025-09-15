package edu.uptc.Entidades;

import java.time.LocalDate;

public class Odontologia extends ServicioMedico {
    private String implementosUsados;

    public Odontologia(LocalDate fechaDeAtencion, Medico medicoResponsable, String implementosUsados) {
        super(fechaDeAtencion, medicoResponsable);
        this.implementosUsados = implementosUsados;
    }

    public String getImplementosUsados() {
        return implementosUsados;
    }

    public void setImplementosUsados(String implementosUsados) {
        this.implementosUsados = implementosUsados;
    }

    @Override
    public String toString() {
        return "Odontologia con ID: " + getIdServicio() + " , Fecha de atencion: " + getFechaDeAtencion()
                + " , Implementos usados: " + implementosUsados + " y medico responsable: \n" + getMedicoResponsable();
    }
}
