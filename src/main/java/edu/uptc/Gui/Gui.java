package edu.uptc.Gui;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import edu.uptc.Controlador.ControladorClinica;
import edu.uptc.Entidades.Medico;
import edu.uptc.Entidades.Paciente;
import edu.uptc.Entidades.ServicioMedico;

public class Gui {
    private ControladorClinica controlador;

    public Gui(ControladorClinica controlador) {
        this.controlador = controlador;
    }

    public void iniciar() {
        String menuPrincipal = """
                ***IPS Salud Boyaca***
                1. Registrar cita
                2. Menu de medicos
                3. Menu de pacientes
                4. Menu de solicitudes medicas
                5. Salir
                """;
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (opcion) {
                case 1:
                    vistaRegistrarCita();
                    break;
                case 2:
                    vistaMenuDeMedicos();
                    break;
                case 3:
                    vistaMenuDePacientes();
                    break;
                case 4:
                    vistaMenuSolicitudesMedicas();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error");
                    break;
            }
        } while (opcion != 5);
    }

    public void vistaRegistrarCita() {
        String menuCitas = """
                1. Cita para medicina general
                2. Cita para odontologia
                3. Cita para dermatologia
                                """;
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula del paciente:");
        Paciente paciente = controlador.buscarPaciente(cedula);
        if (paciente == null) {
            JOptionPane.showMessageDialog(null, "Usuario no registrado... procediendo");
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente:");
            int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de nacimiento:"));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento:"));
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimeinto:"));
            LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
            String genero = JOptionPane.showInputDialog("Ingrese el genero:");
            JOptionPane.showMessageDialog(null, controlador.registrarPaciente(nombre, cedula, fechaNacimiento, genero));
            paciente = controlador.buscarPaciente(cedula);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario ya registrado...");
        }
        int opcionCitas = Integer.parseInt(JOptionPane.showInputDialog(menuCitas));
        LocalDate fechaAtendido = LocalDate.now();
        switch (opcionCitas) {
            case 1:
                String medicoNombre = JOptionPane
                        .showInputDialog(controlador.buscarMedicoEspecialidad("Medicina general") + "\n"
                                + "Escribe el nombre del medico:");
                String cedulaMedico = JOptionPane.showInputDialog("Ingresa la cedula del medico:");
                Medico medicoElegido = controlador.buscarMedico(medicoNombre, cedulaMedico);
                if (medicoElegido != null) {
                    int examenes = JOptionPane.showConfirmDialog(null, "Examenes de prevencion o promocion: ",
                            "Examenes",
                            JOptionPane.YES_NO_OPTION);
                    boolean solicitudExamenPrevencion = false;
                    boolean solicitudExamenPromocion = false;
                    if (examenes == JOptionPane.YES_OPTION) {
                        String cualExamen = JOptionPane.showInputDialog("Prevencion o promocion:");
                        if (cualExamen.equalsIgnoreCase("Prevencion")) {
                            solicitudExamenPrevencion = true;
                        } else if (cualExamen.equalsIgnoreCase("Promocion")) {
                            solicitudExamenPromocion = true;
                        }
                    }
                    JOptionPane.showMessageDialog(null,
                            controlador.registrarCita(paciente, medicoElegido, fechaAtendido,
                                    solicitudExamenPrevencion, solicitudExamenPromocion));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el medico");
                }
                break;
            case 2:
                String medicoNombre2 = JOptionPane.showInputDialog(
                        controlador.buscarMedicoEspecialidad("Odontologia") + "\n" + "Escribe el nombre del medico:");
                String cedulaMedico2 = JOptionPane.showInputDialog("Ingresa la cedula del medico:");
                Medico medicoElegido2 = controlador.buscarMedico(medicoNombre2, cedulaMedico2);
                String implementosUsados = JOptionPane.showInputDialog("Implementos usados:");
                if (medicoElegido2 != null) {
                    JOptionPane.showMessageDialog(null,
                            controlador.registrarCita(paciente, medicoElegido2, fechaAtendido, implementosUsados));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el medico");
                }

                break;
            case 3:
                String medicoNombre3 = JOptionPane.showInputDialog(
                        controlador.buscarMedicoEspecialidad("Dermatologia") + "\n" + "Escribe el nombre del medico:");
                String cedulaMedico3 = JOptionPane.showInputDialog("Ingresa la cedula del medico:");
                Medico medicoElegido3 = controlador.buscarMedico(medicoNombre3, cedulaMedico3);
                String procedimientosEsteticos = JOptionPane.showInputDialog("Procedimientos esteticos aplicados:");
                if (medicoElegido3 != null) {
                    JOptionPane.showMessageDialog(null, controlador.registrarCitaDermatologia(paciente, medicoElegido3,
                            fechaAtendido, procedimientosEsteticos));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el medico");
                }

                break;
            default:
                JOptionPane.showMessageDialog(null, "Error");
                break;
        }
    }

    public void vistaMenuDeMedicos() {
        int opcionMenuMedicos;
        do {
            opcionMenuMedicos = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Registrar medico
                    2. Eliminar medico
                    3. Actualizar medico
                    4. Ver todos los medicos
                    5. Ver medicos por especialidad
                    6. Buscar medico
                    7. Salir
                    """));
            switch (opcionMenuMedicos) {
                case 1:
                    String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico:");
                    String cedulaMedico = JOptionPane.showInputDialog("Ingrese la cedula del medico:");
                    String numeroRegistroMedico = JOptionPane.showInputDialog("Ingrese el numero de registro medico:");
                    String especialidadMedico = JOptionPane.showInputDialog("Ingrese la especialidad del medico:");
                    JOptionPane.showMessageDialog(null, controlador.registrarMedico(nombreMedico, cedulaMedico,
                            especialidadMedico, numeroRegistroMedico));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, controlador.mostrarTodosLosMedicos());
                    String nombreMedicoEliminar = JOptionPane.showInputDialog("Ingrese el nombre del medico");
                    String cedulaMedicoEliminar = JOptionPane.showInputDialog("Ingrese la cedula del medico:");
                    JOptionPane.showMessageDialog(null,
                            controlador.eliminarMedico(nombreMedicoEliminar, cedulaMedicoEliminar));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, controlador.mostrarTodosLosMedicos());
                    String nombreActualizarMedico = JOptionPane
                            .showInputDialog("Ingrese el nombre del medico a modificar:");
                    String cedulaActualizarMedico = JOptionPane
                            .showInputDialog("Ingrese la cedula del medico a modificar:");
                    Medico medicoActualizar = controlador.buscarMedico(nombreActualizarMedico, cedulaActualizarMedico);
                    int opcionActualizarMedico;
                    if (medicoActualizar != null) {
                        do {
                            opcionActualizarMedico = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1. Nombre
                                    2. Cedula
                                    3. Especialidad
                                    4. Salir
                                    """));
                            if (opcionActualizarMedico < 4 && opcionActualizarMedico > 0) {
                                String cambioActualizar = JOptionPane.showInputDialog("Ingrese la modificacion:");
                                JOptionPane.showMessageDialog(null, controlador.actualizarMedico(medicoActualizar,
                                        opcionActualizarMedico, cambioActualizar));
                            }
                        } while (opcionActualizarMedico != 4);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el medico");
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, controlador.mostrarTodosLosMedicos());
                    break;
                case 5:
                    String especialidad = JOptionPane.showInputDialog("Ingrese una especialidad:");
                    JOptionPane.showMessageDialog(null, controlador.buscarMedicoEspecialidad(especialidad));
                    break;
                case 6:
                    String nombreBuscarMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico:");
                    String cedulaBuscarMedico = JOptionPane.showInputDialog("Ingrese la cedula del medico:");
                    Medico medicoBuscado = controlador.buscarMedico(nombreBuscarMedico, cedulaBuscarMedico);
                    if (medicoBuscado!=null) {
                        JOptionPane.showMessageDialog(null, medicoBuscado.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "Medico no encontrado");
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error");
                    break;
            }
        } while (opcionMenuMedicos != 7);
    }

    public void vistaMenuDePacientes() {
        int opcionMenuPacientes;
        do {
            opcionMenuPacientes = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Eliminar paciente
                    2. Actualizar paciente
                    3. Ver todos los pacientes
                    4. Buscar paciente
                    5. Salir
                    """));
            switch (opcionMenuPacientes) {
                case 1:
                    String cedulaPacienteEliminar = JOptionPane.showInputDialog(
                            controlador.mostrarTodosLosPacientes() + "\n" + "Ingrese la cedula del paciente a eliminar:");
                    JOptionPane.showMessageDialog(null, controlador.eliminarPaciente(cedulaPacienteEliminar));
                    break;
                case 2:
                    String cedulaPacienteActualizar = JOptionPane
                            .showInputDialog(controlador.mostrarTodosLosPacientes()+"\n Ingrese la cedula del paciente a actualizar:");
                    Paciente pacienteActualizar = controlador.buscarPaciente(cedulaPacienteActualizar);
                    int opcionActualizarPaciente;
                    if (pacienteActualizar != null) {
                        do {
                            opcionActualizarPaciente = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1. Nombre
                                    2. Cedula
                                    3. Genero
                                    4. Salir
                                    """));
                            if (opcionActualizarPaciente < 4 && opcionActualizarPaciente > 0) {
                                String actualizarDatosPaciente = JOptionPane.showInputDialog("Ingrese la modifcacion:");
                                JOptionPane.showMessageDialog(null, controlador.actualizarPaciente(pacienteActualizar, opcionActualizarPaciente,
                                        actualizarDatosPaciente));
                            }
                        } while (opcionActualizarPaciente != 4);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el paciente");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, controlador.mostrarTodosLosPacientes());
                    break;
                case 4:
                    String cedulaBuscarPaciente = JOptionPane.showInputDialog("Ingrese la cedula del paciente:");
                    Paciente pacientebuscado = controlador.buscarPaciente(cedulaBuscarPaciente);
                    if (pacientebuscado!=null) {
                        JOptionPane.showMessageDialog(null, pacientebuscado.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el paciente");
                    }
                    
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error");
                    break;
            }
        } while (opcionMenuPacientes != 5);
    }

    public void vistaMenuSolicitudesMedicas() {
        int opcionMenuSolicitudes;
        do {
            opcionMenuSolicitudes = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Eliminar servicios medicos de un paciente
                    2. Actualizar servicios medicos de un paciente
                    3. Ver servicios medicos de un paciente
                    4. Ver todas los servicios medicos
                    5. Buscar servicio medico por ID
                    6. Salir
                    """));
            switch (opcionMenuSolicitudes) {
                case 1:
                    String cedulaPacienteEliminarServicioMedico = JOptionPane.showInputDialog(
                            controlador.mostrarTodosLosPacientes() + "\n" + "Ingrese la cedula del paciente:");
                    Paciente pacienteEliminarServicio = controlador
                            .buscarPaciente(cedulaPacienteEliminarServicioMedico);
                    if (pacienteEliminarServicio != null) {
                        int idServicioEliminar = Integer.parseInt(JOptionPane.showInputDialog(
                                controlador.verHistorialClinicoPaciente(cedulaPacienteEliminarServicioMedico) + "\n"
                                        + "Ingrese el id que quiere eliminar:"));
                        JOptionPane.showMessageDialog(null,
                                controlador.eliminarCita(pacienteEliminarServicio, idServicioEliminar));
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el paciente");
                    }
                    break;
                case 2:
                    String cedulaActualizarServicio = JOptionPane.showInputDialog(controlador.mostrarTodosLosPacientes()+"Ingrese la cedula del paciente:");
                    int idServicioActualizar = Integer.parseInt(JOptionPane.showInputDialog(
                            controlador.verHistorialClinicoPaciente(cedulaActualizarServicio) + "\n" + "Ingrese el id del servicio a actualizar:"));
                    ServicioMedico servicioActualizar = controlador.buscarServicioMedico(idServicioActualizar);
                    if (servicioActualizar != null) {
                        int opcionActualizarServicio = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Fecha de atencion
                                2. Medico responsable
                                """));
                        switch (opcionActualizarServicio) {
                            case 1:
                                int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia nuevo:"));
                                int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes nuevo:"));
                                int ano = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ano nuevo:"));
                                LocalDate fechaNueva = LocalDate.of(ano, mes, dia);
                                JOptionPane.showMessageDialog(null,
                                        controlador.actualizarServicioMedicoFecha(servicioActualizar, fechaNueva));
                                break;
                            case 2:
                                String nombreMedicoCambio = JOptionPane.showInputDialog(
                                        controlador.mostrarTodosLosMedicos() + "\n" + "Ingrese el nombre del medico:");
                                String cedulaMedicoCambio = JOptionPane.showInputDialog("Ingresa la cedula del medio:");
                                Medico medicoCambio = controlador.buscarMedico(nombreMedicoCambio, cedulaMedicoCambio);
                                if (medicoCambio != null) {
                                    JOptionPane.showMessageDialog(null, controlador
                                            .actualizarMedicoDeServicioMedico(servicioActualizar, medicoCambio));
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se encontro al medico");
                                }

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Error");
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro ese servicio");
                    }

                    break;
                case 3:
                    String cedulaBuscar = JOptionPane.showInputDialog("Ingrese la cedula del paciente:");
                    JOptionPane.showMessageDialog(null, controlador.verHistorialClinicoPaciente(cedulaBuscar));
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, controlador.mostrarHistorialClinico());
                    break;
                case 5:
                    int idServicioMedico = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingresa el id del servicio Medico:"));
                    JOptionPane.showMessageDialog(null, controlador.buscarServicioMedicoConPaciente(idServicioMedico));
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo..");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error");
                    break;
            }
        } while (opcionMenuSolicitudes != 6);
    }
}
