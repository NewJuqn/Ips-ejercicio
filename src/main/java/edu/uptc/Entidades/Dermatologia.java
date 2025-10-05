package edu.uptc.Entidades;

import java.time.LocalDate;

public class Dermatologia extends ServicioMedico {
    private String procedimientosEsteticos;

    public Dermatologia(LocalDate fechaDeAtencion, Medico medicoResponsable, String procedimientosEsteticos) {
        super(fechaDeAtencion, medicoResponsable);
        this.procedimientosEsteticos = procedimientosEsteticos;
    }

    /** 
     * @return String
     */
    public String getProcedimientosEsteticos() {
        return procedimientosEsteticos;
    }

    /** 
     * @param procedimientosEsteticos
     */
    public void setProcedimientosEsteticos(String procedimientosEsteticos) {
        this.procedimientosEsteticos = procedimientosEsteticos;
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Dermatologia con ID: " + getIdServicio() + " , Fecha de atencion: " + getFechaDeAtencion()
                + " , Procedimientos esteticos: " + procedimientosEsteticos + " y medico responsable: \n"
                + getMedicoResponsable();
    }
}
