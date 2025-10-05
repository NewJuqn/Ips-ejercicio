package edu.uptc.Entidades;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Paciente {
    private String nombre;
    private String cedula;
    private LocalDate fechaDeNacimiento;
    private int edad;
    private String genero;
    private ArrayList<ServicioMedico> serviciosMedicosPaciente;
    public Paciente(){

    }
    public Paciente(String nombre, String cedula, LocalDate fechaDeNacimiento, String genero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.edad = Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
        this.genero = genero;
        this.serviciosMedicosPaciente = new ArrayList<>();
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
     * @return LocalDate
     */
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /** 
     * @param fechaDeNacimiento
     */
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /** 
     * @return int
     */
    public int getEdad() {
        return edad;
    }

    /** 
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /** 
     * @return String
     */
    public String getGenero() {
        return genero;
    }

    /** 
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /** 
     * @return ArrayList<ServicioMedico>
     */
    public ArrayList<ServicioMedico> getServiciosMedicosPaciente() {
        return serviciosMedicosPaciente;
    }

    /** 
     * @param serviciosMedicosPaciente
     */
    public void setServiciosMedicosPaciente(ArrayList<ServicioMedico> serviciosMedicosPaciente) {
        this.serviciosMedicosPaciente = serviciosMedicosPaciente;
    }
    /** 
     * @param servicioAgregado
     */
    public void agregarServicio(ServicioMedico servicioAgregado){
        serviciosMedicosPaciente.add(servicioAgregado);
    }
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Paciente "+nombre + " con cedula: " + cedula + " , Fecha de nacimiento: " + fechaDeNacimiento
                + " , Edad: " + edad + " , Genero: " + genero +"\n";
    }

}
