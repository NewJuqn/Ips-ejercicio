package edu.uptc.Entidades;

import java.time.LocalDate;

public class ServicioMedico {
    private int idServicio;
    private static int contador = 100;
    private LocalDate fechaDeAtencion;
    private Medico medicoResponsable;

    public ServicioMedico(){

    }

    public ServicioMedico(LocalDate fechaDeAtencion, Medico medicoResponsable) {
        this.fechaDeAtencion = fechaDeAtencion;
        this.idServicio = contador++;
        this.medicoResponsable = medicoResponsable;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public LocalDate getFechaDeAtencion() {
        return fechaDeAtencion;
    }

    public void setFechaDeAtencion(LocalDate fechaDeAtencion) {
        this.fechaDeAtencion = fechaDeAtencion;
    }

    public Medico getMedicoResponsable() {
        return medicoResponsable;
    }

    public void setMedicoResponsable(Medico medicoResponsable) {
        this.medicoResponsable = medicoResponsable;
    }

    @Override
    public String toString() {
        return "ServicioMedico [idServicio=" + idServicio + ", fechaDeAtencion=" + fechaDeAtencion
                + ", medicoResponsable=" + medicoResponsable + "]";
    }
    
}
