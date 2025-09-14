package edu.uptc.Entidades;

import java.time.LocalDate;

public class Dermatologia extends ServicioMedico{
    private String procedimientosEsteticos;

    public Dermatologia(LocalDate fechaDeAtencion, Medico medicoResponsable, String procedimientosEsteticos) {
        super();
        this.procedimientosEsteticos = procedimientosEsteticos;
    }

    public Dermatologia(String procedimientosEsteticos) {
        this.procedimientosEsteticos = procedimientosEsteticos;
    }

    public String getProcedimientosEsteticos() {
        return procedimientosEsteticos;
    }

    public void setProcedimientosEsteticos(String procedimientosEsteticos) {
        this.procedimientosEsteticos = procedimientosEsteticos;
    }

}
