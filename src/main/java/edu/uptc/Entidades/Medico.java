package edu.uptc.Entidades;

public class Medico {
    private String nombre;
    private String cedula;
    private String numeroRegistroMedico;
    private String especialidad;

    public Medico(String cedula, String especialidad, String nombre, String numeroRegistroMedico) {
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.nombre = nombre;
        this.numeroRegistroMedico = numeroRegistroMedico;
    }
    public Medico(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeroRegistroMedico() {
        return numeroRegistroMedico;
    }

    public void setNumeroRegistroMedico(String numeroRegistroMedico) {
        this.numeroRegistroMedico = numeroRegistroMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    @Override
    public String toString() {
        return "Medico "+ nombre + " con cedula: " + cedula + "\nNumero de registro medico: " + numeroRegistroMedico
                + "\nEspecialidad: " + especialidad+"\n";
    }

}
