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

    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * @return String
     */
    public String getCedula() {
        return cedula;
    }

    /** 
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /** 
     * @return String
     */
    public String getNumeroRegistroMedico() {
        return numeroRegistroMedico;
    }

    /** 
     * @param numeroRegistroMedico
     */
    public void setNumeroRegistroMedico(String numeroRegistroMedico) {
        this.numeroRegistroMedico = numeroRegistroMedico;
    }

    /** 
     * @return String
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /** 
     * @param especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Medico "+ nombre + " con cedula: " + cedula + "\nNumero de registro medico: " + numeroRegistroMedico
                + "\nEspecialidad: " + especialidad+"\n";
    }

}
