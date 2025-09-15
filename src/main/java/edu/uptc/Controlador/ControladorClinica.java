package edu.uptc.Controlador;

import java.time.LocalDate;

import edu.uptc.Entidades.Medico;
import edu.uptc.Entidades.Paciente;
import edu.uptc.Entidades.ServicioMedico;
import edu.uptc.Servicios.ClinicaServicios;

public class ControladorClinica {
    private ClinicaServicios clinicaServicios;

    public ControladorClinica() {
        this.clinicaServicios = new ClinicaServicios();
    }
    //Medico
    public String registrarMedico(String nombre, String cedula, String especialidad, String numeroRegistroMedico){
        return this.clinicaServicios.registrarMedico(nombre, cedula, especialidad, numeroRegistroMedico);
    }
    public String eliminarMedico(String nombre, String cedula){
        return this.clinicaServicios.eliminarMedico(nombre, cedula);
    }
    public String actualizarMedico(Medico medicoActualizar, int opcion, String cambio){
        return this.clinicaServicios.actualizarMedico(medicoActualizar, opcion, cambio);
    }
    public Medico buscarMedico(String nombreMedico, String cedula){
        return this.clinicaServicios.buscarMedico(nombreMedico, cedula);
    }
    public String mostrarTodosLosMedicos(){
        return this.clinicaServicios.mostrarTodosLosMedicos();
    }
    public String buscarMedicoEspecialidad(String especialidad){
        return this.clinicaServicios.buscarMedicoEspecialidad(especialidad);
    }
    //Paciente
    public String registrarPaciente(String nombre, String cedula, LocalDate fechaDeNacimiento, String genero){
        return this.clinicaServicios.registrarPaciente(nombre, cedula, fechaDeNacimiento, genero);
    }
    public Paciente buscarPaciente(String cedula){
        return this.clinicaServicios.buscarPaciente(cedula);
    }
    public String mostrarTodosLosPacientes(){
        return this.clinicaServicios.mostrarTodosLosPacientes();
    }
    public String eliminarPaciente(String cedula){
        return this.clinicaServicios.eliminarPaciente(cedula);
    }
    public String actualizarPaciente(Paciente pacienteActualizar, int opcion, String cambio){
        return this.clinicaServicios.actualizarPaciente(pacienteActualizar, opcion, cambio);
    }
    public String verHistorialClinicoPaciente(String cedula){
        return this.clinicaServicios.verHistorialClinicoPaciente(cedula);
    }
    //Servicio medico
    public String registrarCita(Paciente pacienteParaCita, Medico medicoElegido, LocalDate fecha, boolean solicitudExamenPrevencion, boolean solicitudExamenPromocion){
        return this.clinicaServicios.registrarCita(pacienteParaCita, medicoElegido, fecha, solicitudExamenPrevencion, solicitudExamenPromocion);
    }
    public String registrarCita(Paciente pacieneParaCita, Medico medicoElegido, LocalDate fecha, String implementosUsados){
        return this.clinicaServicios.registrarCita(pacieneParaCita, medicoElegido, fecha, implementosUsados);
    }
    public String registrarCitaDermatologia(Paciente pacienteParaCita, Medico medicoElegido, LocalDate fecha, String procedimientosEsteticos){
        return this.clinicaServicios.registrarCitaDermatologia(pacienteParaCita, medicoElegido, fecha, procedimientosEsteticos);
    }
    public ServicioMedico buscarServicioMedico(int idServicio){
        return this.clinicaServicios.buscarServicioMedico(idServicio);
    }
    public String buscarServicioMedicoConPaciente(int idServicio){
        return this.clinicaServicios.buscarServicioMedicoConPaciente(idServicio);
    }
    public String eliminarCita(Paciente pacienteEliminar, int idServicio){
        return this.clinicaServicios.eliminarCita(pacienteEliminar, idServicio);
    }
    public String mostrarHistorialClinico(){
        return this.clinicaServicios.mostrarHistorialClinico();
    }
    public String actualizarServicioMedicoFecha(ServicioMedico servicio, LocalDate fechaCambiar){
        return this.clinicaServicios.actualizarServicioMedicoFecha(servicio, fechaCambiar);
    }
    public String actualizarMedicoDeServicioMedico(ServicioMedico servicio, Medico medicoCambio){
        return this.clinicaServicios.actualizarMedicoDeServicioMedico(servicio, medicoCambio);
    }
    
}
