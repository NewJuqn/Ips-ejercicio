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

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<ServicioMedico> getServiciosMedicosPaciente() {
        return serviciosMedicosPaciente;
    }

    public void setServiciosMedicosPaciente(ArrayList<ServicioMedico> serviciosMedicosPaciente) {
        this.serviciosMedicosPaciente = serviciosMedicosPaciente;
    }
    public void agregarServicio(ServicioMedico servicioAgregado){
        serviciosMedicosPaciente.add(servicioAgregado);
    }
    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", cedula=" + cedula + ", fechaDeNacimiento=" + fechaDeNacimiento
                + ", edad=" + edad + ", genero=" + genero + ", serviciosMedicosPaciente=" + serviciosMedicosPaciente
                + "]";
    }

}
