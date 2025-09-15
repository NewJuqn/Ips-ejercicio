package edu.uptc.Servicios;

import java.time.LocalDate;
import java.util.ArrayList;

import edu.uptc.Entidades.Dermatologia;
import edu.uptc.Entidades.Medicina_General;
import edu.uptc.Entidades.Medico;
import edu.uptc.Entidades.Odontologia;
import edu.uptc.Entidades.Paciente;
import edu.uptc.Entidades.ServicioMedico;

public class ClinicaServicios {
    private ArrayList<ServicioMedico> historialClinico;
    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;

    public ClinicaServicios() {
        this.historialClinico = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    // MEDICO
    public String registrarMedico(String nombre, String cedula, String especialidad, String numeroRegistroMedico) {
        if (buscarMedico(nombre, cedula) == null) {
            medicos.add(new Medico(cedula, especialidad, nombre, numeroRegistroMedico));
            return "Medico registrado exitosamente";
        }
        return null;
    }

    public String eliminarMedico(String nombre, String cedula) {
        Medico medicoEliminar = buscarMedico(nombre, cedula);
        if (medicoEliminar != null) {
            medicos.remove(medicoEliminar);
            return "Medico eliminado exitosamente";
        }
        return "Medico no encontrado";
    }

    public String actualizarMedico(Medico medicoActualizar, int opcion, String cambio) {
        switch (opcion) {
            case 1:
                medicoActualizar.setNombre(cambio);
                break;
            case 2:
                medicoActualizar.setCedula(cambio);
                break;
            case 3:
                medicoActualizar.setEspecialidad(cambio);
                break;
            default:
                break;
        }
        return "Cambio exitoso";
    }

    public Medico buscarMedico(String nombreMedico, String cedula) {
        for (Medico medicoAux : medicos) {
            if (medicoAux.getNombre().equalsIgnoreCase(nombreMedico)
                    && medicoAux.getCedula().equalsIgnoreCase(cedula)) {
                return medicoAux;
            }
        }
        return null;
    }

    public String mostrarTodosLosMedicos() {
        String todosLosMedicos = "";
        for (Medico medicoAux3 : medicos) {
            todosLosMedicos += medicoAux3.toString() + "\n";
        }
        return todosLosMedicos;
    }

    public String buscarMedicoEspecialidad(String especialidad) {
        String medicosConCoincidencia = "";
        for (Medico medicoAux2 : medicos) {
            if (medicoAux2.getEspecialidad().equalsIgnoreCase(especialidad)) {
                medicosConCoincidencia += medicoAux2.getNombre() + " con cedula: " + medicoAux2.getCedula() + "\n";
            }
        }
        return medicosConCoincidencia;
    }

    // PACIENTE
    public String registrarPaciente(String nombre, String cedula, LocalDate fechaDeNacimiento, String genero) {
        if (buscarPaciente(cedula) == null) {
            pacientes.add(new Paciente(nombre, cedula, fechaDeNacimiento, genero));
            return "Paciente registrado exitosamente";
        } else {
            return "Paciente ya registrado";
        }
    }

    public Paciente buscarPaciente(String cedula) {
        for (Paciente pacienteAux : pacientes) {
            if (pacienteAux.getCedula().equalsIgnoreCase(cedula)) {
                return pacienteAux;
            }
        }
        return null;
    }

    public String mostrarTodosLosPacientes() {
        String todosLosPacientes = "";
        for (Paciente pacienteAux : pacientes) {
            todosLosPacientes += pacienteAux.toString() + "\n";
        }
        return todosLosPacientes;
    }

    public String eliminarPaciente(String cedula) {
        Paciente pacienteEliminar = buscarPaciente(cedula);
        pacientes.remove(pacienteEliminar);
        return "Paciente eliminado exitosamente";
    }

    public String actualizarPaciente(Paciente pacienteActualizar, int opcion, String cambio) {
        switch (opcion) {
            case 1:
                pacienteActualizar.setNombre(cambio);
                break;
            case 2:
                pacienteActualizar.setCedula(cambio);
                break;
            case 3:
                pacienteActualizar.setGenero(cambio);
                break;
            default:
                break;
        }
        return "Cambio exitoso";
    }

    public String verHistorialClinicoPaciente(String cedula) {
        Paciente pacienteVer = buscarPaciente(cedula);
        if (pacienteVer != null) {
            String historialClinicoPaciente = pacienteVer.getNombre() + " con cedula: " + pacienteVer.getCedula()
                    + "\n";
            for (ServicioMedico servicioMedicoAux : pacienteVer.getServiciosMedicosPaciente()) {
                historialClinicoPaciente += servicioMedicoAux.toString() + "\n";
            }
            return "Historial clinico: \n" + historialClinicoPaciente;
        } else {
            return "No se encontro el paciente";
        }

    }

    // SERVICIO MEDICO
    public String registrarCita(Paciente pacienteParaCita, Medico medicoElegido, LocalDate fecha,
            boolean solicitudExamenPrevencion, boolean solicitudExamenPromocion) {
        ServicioMedico nuevoServicio = new Medicina_General(solicitudExamenPrevencion, solicitudExamenPromocion, fecha,
                medicoElegido);
        pacienteParaCita.agregarServicio(nuevoServicio);
        historialClinico.add(nuevoServicio);
        return "Cita registrada exitosamente";
    }

    public String registrarCita(Paciente pacieneParaCita, Medico medicoElegido, LocalDate fecha,
            String implementosUsados) {
        ServicioMedico nuevoServicio = new Odontologia(fecha, medicoElegido, implementosUsados);
        pacieneParaCita.agregarServicio(nuevoServicio);
        historialClinico.add(nuevoServicio);
        return "Cita registrada exitosamente";
    }

    public String registrarCitaDermatologia(Paciente pacienteParaCita, Medico medicoElegido, LocalDate fecha,
            String procedimientosEsteticos) {
        ServicioMedico nuevoServicio = new Dermatologia(fecha, medicoElegido, procedimientosEsteticos);
        pacienteParaCita.agregarServicio(nuevoServicio);
        historialClinico.add(nuevoServicio);
        return "Cita registrada exitosamente";
    }

    public ServicioMedico buscarServicioMedico(int idServicio) {
        for (ServicioMedico servicioMedico : historialClinico) {
            if (servicioMedico.getIdServicio() == idServicio) {
                return servicioMedico;
            }
        }
        return null;
    }

    public String buscarServicioMedicoConPaciente(int idServicio) {
        ServicioMedico servicio = buscarServicioMedico(idServicio);
        if (servicio != null) {
            for (Paciente paciente : pacientes) {
                for (ServicioMedico servicioAux : paciente.getServiciosMedicosPaciente()) {
                    if (servicioAux.getIdServicio() == idServicio) {
                        return "Servicio encontrado:\n" + servicio.toString() +
                                "\nPaciente: " + paciente.getNombre() + " (" + paciente.getCedula() + ")";
                    }
                }
            }
            return servicio.toString() + "\n(Paciente no encontrado)";
        }
        return "Servicio no encontrado";
    }

    public String eliminarCita(Paciente pacienteEliminarCita, int idServicioPaciente) {
        for (ServicioMedico servicioMedico : pacienteEliminarCita.getServiciosMedicosPaciente()) {
            if (servicioMedico.getIdServicio() == idServicioPaciente) {
                pacienteEliminarCita.getServiciosMedicosPaciente().remove(servicioMedico);
                return "Eliminado exitosamente";
            }
        }
        return "No se encontro el paciente o no existe ese id de servicio, revise nuevamente";
    }

    public String mostrarHistorialClinico() {
        String todosLosServiciosMedicos = "";
        for (ServicioMedico servicioMedico : historialClinico) {
            todosLosServiciosMedicos += servicioMedico.toString() + "\n";
        }
        return todosLosServiciosMedicos;
    }

    public String actualizarServicioMedicoFecha(ServicioMedico servicio, LocalDate fechaCambio) {
        servicio.setFechaDeAtencion(fechaCambio);
        return "Fecha cambiada exitosamente";
    }

    public String actualizarMedicoDeServicioMedico(ServicioMedico servicio, Medico medicoCambio) {
        servicio.setMedicoResponsable(medicoCambio);
        return "Medico cambiado exitosamente";
    }
}
