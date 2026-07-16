/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author marie
 */
public class AsesorVenta extends Empleado {

    public AsesorVenta() {
    }

    public AsesorVenta(String dni, String nombres, String apellidos,
            String usuario, String password) {

        super(dni, nombres, apellidos, usuario, password, "Asesor");
    }

    @Override
    public String getTipoEmpleado() {
        return "Asesor";
    }
}