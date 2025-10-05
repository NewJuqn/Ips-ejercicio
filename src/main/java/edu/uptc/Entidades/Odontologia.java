package edu.uptc.Entidades;

import java.time.LocalDate;

public class Odontologia extends ServicioMedico {
    private String implementosUsados;

    public Odontologia(LocalDate fechaDeAtencion, Medico medicoResponsable, String implementosUsados) {
        super(fechaDeAtencion, medicoResponsable);
        this.implementosUsados = implementosUsados;
    }

    /** 
     * @return String
     */
    public String getImplementosUsados() {
        return implementosUsados;
    }

    /** 
     * @param implementosUsados
     */
    public void setImplementosUsados(String implementosUsados) {
        this.implementosUsados = implementosUsados;
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Odontologia con ID: " + getIdServicio() + " , Fecha de atencion: " + getFechaDeAtencion()
                + " , Implementos usados: " + implementosUsados + " y medico responsable: \n" + getMedicoResponsable();
    }
}
