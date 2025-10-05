package edu.uptc;

import edu.uptc.Controlador.ControladorClinica;
import edu.uptc.Gui.Gui;

public class Application {

    /** 
     * @param args
     */
    public static void main(String[] args) {
        ControladorClinica controlador = new ControladorClinica();
        Gui gui = new Gui(controlador);

        gui.iniciar();
    }
}
