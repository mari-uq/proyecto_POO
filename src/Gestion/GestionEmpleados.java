/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Entidades.Empleado;

/**
 *
 * @author marie
 */
public class GestionEmpleados {

    // Arreglo donde se almacenarán los empleados
    private Empleado[] empleados;

    // Indica cuántos empleados hay registrados
    private int cantidad;

    // Constructor
    public GestionEmpleados() {

        empleados = new Empleado[100]; // Se crea el arreglo con capacidad para 100 empleados
        cantidad = 0; // Inicialmente no hay empleados

    }

    // ============================
    // AGREGAR EMPLEADO
    // ============================
    public boolean agregarEmpleado(Empleado empleado) {

        // Verifica si ya existe un empleado con el mismo DNI
        if (buscarEmpleado(empleado.getDni()) != null) {
            return false;
        }

        // Guarda el empleado en la siguiente posición libre
        empleados[cantidad] = empleado;

        // Incrementa la cantidad de empleados
        cantidad++;

        return true;

    }

    // ============================
    // BUSCAR EMPLEADO POR DNI
    // ============================
    public Empleado buscarEmpleado(String dni) {

        // Recorre únicamente los empleados registrados
        for (int i = 0; i < cantidad; i++) {

            // Compara el DNI
            if (empleados[i].getDni().equals(dni)) {

                return empleados[i];
            }
        }

        // Si no existe retorna null
        return null;

    }

    // ============================
    // MODIFICAR EMPLEADO
    // ============================
    public boolean modificarEmpleado(Empleado empleado) {

        // Busca el empleado por DNI
        for (int i = 0; i < cantidad; i++) {

            if (empleados[i].getDni().equals(empleado.getDni())) {

                // Reemplaza el objeto por el nuevo
                empleados[i] = empleado;

                return true;
            }
        }

        return false;

    }

    // ============================
    // ELIMINAR EMPLEADO
    // ============================
    public boolean eliminarEmpleado(String dni) {

        // Busca la posición del empleado
        for (int i = 0; i < cantidad; i++) {

            if (empleados[i].getDni().equals(dni)) {

                // Mueve todos los empleados una posición hacia la izquierda
                for (int j = i; j < cantidad - 1; j++) {

                    empleados[j] = empleados[j + 1];

                }

                // Elimina la última referencia
                empleados[cantidad - 1] = null;

                // Disminuye la cantidad
                cantidad--;

                return true;
            }
        }

        return false;

    }

    // ============================
    // DEVUELVE EL ARREGLO
    // ============================
    public Empleado[] getEmpleados() {

        return empleados;

    }

    // ============================
    // DEVUELVE LA CANTIDAD
    // ============================
    public int getCantidad() {

        return cantidad;

    }

}