package edu.uptc.Entidades;

import java.time.LocalDate;

public class Medicina_General extends ServicioMedico {
    private boolean solicitudExamenPromocion;
    private boolean solicitudExamenPrevencion;

    public Medicina_General(boolean solicitudExamenPrevencion, boolean solicitudExamenPromocion,
            LocalDate fechaDeAtencion, Medico medicoResponsable) {
        super(fechaDeAtencion, medicoResponsable);
        this.solicitudExamenPrevencion = solicitudExamenPrevencion;
        this.solicitudExamenPromocion = solicitudExamenPromocion;
    }

    /** 
     * @return boolean
     */
    public boolean isSolicitudExamenPromocion() {
        return solicitudExamenPromocion;
    }

    /** 
     * @param solicitudExamenPromocion
     */
    public void setSolicitudExamenPromocion(boolean solicitudExamenPromocion) {
        this.solicitudExamenPromocion = solicitudExamenPromocion;
    }

    /** 
     * @return boolean
     */
    public boolean isSolicitudExamenPrevencion() {
        return solicitudExamenPrevencion;
    }

    /** 
     * @param solicitudExamenPrevencion
     */
    public void setSolicitudExamenPrevencion(boolean solicitudExamenPrevencion) {
        this.solicitudExamenPrevencion = solicitudExamenPrevencion;
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Medicina General con ID: " + getIdServicio() + " , Fecha de atencion: " + getFechaDeAtencion()
                + " , Examen prevencion: " + solicitudExamenPrevencion + " , Examen promocion: "
                + solicitudExamenPromocion
                + " y medico responsable: \n" + getMedicoResponsable();
    }

}
