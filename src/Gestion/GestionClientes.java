/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Entidades.Cliente;
import java.util.ArrayList;

public class GestionClientes {
    // Lista en memoria para almacenar los clientes
    private ArrayList<Cliente> listaClientes;

    public GestionClientes() {
        listaClientes = new ArrayList<>();
    }

    // 1. CREAR (Agregar Cliente)
    public boolean agregarCliente(Cliente nuevoCliente) {
        if (buscarClientePorDni(nuevoCliente.getDni()) == null) {
            listaClientes.add(nuevoCliente);
            return true; // Agregado con éxito
        }
        return false; // Ya existe un cliente con ese DNI
    }

    // 2. LEER (Buscar por DNI)
    public Cliente buscarClientePorDni(String dni) {
        for (Cliente c : listaClientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null; // No encontrado
    }

    // 3. ACTUALIZAR (Modificar Datos)
    public boolean modificarCliente(String dni, String nuevoNombre, String nuevoTelf, double nuevosIngresos) {
        Cliente c = buscarClientePorDni(dni);
        if (c != null) {
            c.setNombre(nuevoNombre);
            c.setTelefono(nuevoTelf);
            c.setIngresosMensuales(nuevosIngresos);
            return true;
        }
        return false;
    }

    // 4. ELIMINAR
    public boolean eliminarCliente(String dni) {
        Cliente c = buscarClientePorDni(dni);
        if (c != null) {
            listaClientes.remove(c);
            return true;
        }
        return false;
    }

    // Obtener toda la lista (para llenar tablas en la interfaz)
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}
