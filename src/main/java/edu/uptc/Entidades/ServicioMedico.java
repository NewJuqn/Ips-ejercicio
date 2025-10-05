package edu.uptc.Entidades;

import java.time.LocalDate;

public abstract class ServicioMedico {
    private int idServicio;
    private static int contador = 100;
    private LocalDate fechaDeAtencion;
    private Medico medicoResponsable;

    public ServicioMedico(LocalDate fechaDeAtencion, Medico medicoResponsable) {
        this.fechaDeAtencion = fechaDeAtencion;
        this.idServicio = contador++;
        this.medicoResponsable = medicoResponsable;
    }

    /** 
     * @return int
     */
    public int getIdServicio() {
        return idServicio;
    }

    /** 
     * @param idServicio
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    /** 
     * @return LocalDate
     */
    public LocalDate getFechaDeAtencion() {
        return fechaDeAtencion;
    }

    /** 
     * @param fechaDeAtencion
     */
    public void setFechaDeAtencion(LocalDate fechaDeAtencion) {
        this.fechaDeAtencion = fechaDeAtencion;
    }

    /** 
     * @return Medico
     */
    public Medico getMedicoResponsable() {
        return medicoResponsable;
    }

    /** 
     * @param medicoResponsable
     */
    public void setMedicoResponsable(Medico medicoResponsable) {
        this.medicoResponsable = medicoResponsable;
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "ServicioMedico con ID: " + idServicio + " , Fecha de atencion: " + fechaDeAtencion
                + " y medico responsable: \n" + medicoResponsable;
    }
    
}
