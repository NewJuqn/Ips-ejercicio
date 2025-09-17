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
        try {
            // Solo validar que no estén vacíos
            if (nombre == null || nombre.trim().isEmpty() || 
                cedula == null || cedula.trim().isEmpty() ||
                especialidad == null || especialidad.trim().isEmpty() ||
                numeroRegistroMedico == null || numeroRegistroMedico.trim().isEmpty()) {
                return "Error: Todos los campos son obligatorios";
            }
            
            return this.clinicaServicios.registrarMedico(nombre, cedula, especialidad, numeroRegistroMedico);
        } catch (Exception e) {
            return "Error al registrar médico";
        }
    }
    public String eliminarMedico(String nombre, String cedula){
        try {
            if (nombre == null || nombre.trim().isEmpty() || cedula == null || cedula.trim().isEmpty()) {
                return "Error: Nombre y cédula son obligatorios";
            }
            return this.clinicaServicios.eliminarMedico(nombre, cedula);
        } catch (Exception e) {
            return "Error al eliminar médico";
        }
    }
    public String actualizarMedico(Medico medicoActualizar, int opcion, String cambio){
        try {
            if (medicoActualizar == null) {
                return "Error: Médico no encontrado";
            }
            if (cambio == null || cambio.trim().isEmpty()) {
                return "Error: El nuevo valor no puede estar vacío";
            }
            return this.clinicaServicios.actualizarMedico(medicoActualizar, opcion, cambio);
        } catch (Exception e) {
            return "Error al actualizar médico";
        }
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
        try {
            if (nombre == null || nombre.trim().isEmpty() || 
                cedula == null || cedula.trim().isEmpty() ||
                genero == null || genero.trim().isEmpty() ||
                fechaDeNacimiento == null) {
                return "Error: Todos los campos son obligatorios";
            }
            
            return this.clinicaServicios.registrarPaciente(nombre, cedula, fechaDeNacimiento, genero);
        } catch (Exception e) {
            return "Error al registrar paciente";
        }
    }
    public Paciente buscarPaciente(String cedula){
        return this.clinicaServicios.buscarPaciente(cedula);
    }
    public String mostrarTodosLosPacientes(){
        return this.clinicaServicios.mostrarTodosLosPacientes();
    }
    public String eliminarPaciente(String cedula){
        try {
            if (cedula == null || cedula.trim().isEmpty()) {
                return "Error: La cédula es obligatoria";
            }
            return this.clinicaServicios.eliminarPaciente(cedula);
        } catch (Exception e) {
            return "Error al eliminar paciente";
        }
    }
    public String actualizarPaciente(Paciente pacienteActualizar, int opcion, String cambio){
        try {
            if (pacienteActualizar == null) {
                return "Error: Paciente no encontrado";
            }
            if (cambio == null || cambio.trim().isEmpty()) {
                return "Error: El nuevo valor no puede estar vacío";
            }
            return this.clinicaServicios.actualizarPaciente(pacienteActualizar, opcion, cambio);
        } catch (Exception e) {
            return "Error al actualizar paciente";
        }
    }
    public String verHistorialClinicoPaciente(String cedula){
        return this.clinicaServicios.verHistorialClinicoPaciente(cedula);
    }
    //Servicio medico
    public String registrarCita(Paciente pacienteParaCita, Medico medicoElegido, LocalDate fecha, boolean solicitudExamenPrevencion, boolean solicitudExamenPromocion){
        try {
            if (pacienteParaCita == null || medicoElegido == null || fecha == null) {
                return "Error: Paciente, médico y fecha son obligatorios";
            }
            return this.clinicaServicios.registrarCita(pacienteParaCita, medicoElegido, fecha, solicitudExamenPrevencion, solicitudExamenPromocion);
        } catch (Exception e) {
            return "Error al registrar cita";
        }
    }
    public String registrarCita(Paciente pacieneParaCita, Medico medicoElegido, LocalDate fecha, String implementosUsados){
        try {
            if (pacieneParaCita == null || medicoElegido == null || fecha == null || 
                implementosUsados == null || implementosUsados.trim().isEmpty()) {
                return "Error: Todos los campos son obligatorios";
            }
            return this.clinicaServicios.registrarCita(pacieneParaCita, medicoElegido, fecha, implementosUsados);
        } catch (Exception e) {
            return "Error al registrar cita de odontología";
        }
    }
    public String registrarCitaDermatologia(Paciente pacienteParaCita, Medico medicoElegido, LocalDate fecha, String procedimientosEsteticos){
        try {
            if (pacienteParaCita == null || medicoElegido == null || fecha == null || 
                procedimientosEsteticos == null || procedimientosEsteticos.trim().isEmpty()) {
                return "Error: Todos los campos son obligatorios";
            }
            return this.clinicaServicios.registrarCitaDermatologia(pacienteParaCita, medicoElegido, fecha, procedimientosEsteticos);
        } catch (Exception e) {
            return "Error al registrar cita de dermatología";
        }
    }
    public ServicioMedico buscarServicioMedico(int idServicio){
        return this.clinicaServicios.buscarServicioMedico(idServicio);
    }
    public String buscarServicioMedicoConPaciente(int idServicio){
        return this.clinicaServicios.buscarServicioMedicoConPaciente(idServicio);
    }
    public String eliminarCita(Paciente pacienteEliminar, int idServicio){
        try {
            if (pacienteEliminar == null) {
                return "Error: Paciente no encontrado";
            }
            return this.clinicaServicios.eliminarCita(pacienteEliminar, idServicio);
        } catch (Exception e) {
            return "Error al eliminar cita";
        }
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
