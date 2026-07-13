/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Entidades.Cliente;
import Entidades.Departamento;
import Entidades.Reserva;
import Entidades.Venta;
import java.util.ArrayList;

public class GestionVentas {
    private ArrayList<Reserva> listaReservas;
    private ArrayList<Venta> listaVentas;

    public GestionVentas() {
        this.listaReservas = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
    }

    // 1. PROCESO DE SEPARACIÓN / RESERVA
    public String reservarDepartamento(String idReserva, Cliente cliente, Departamento dep, String fecha) {
        // Validación interactiva usando el "estado" de tu compañero
        if (dep.getEstado() != null && (dep.getEstado().equalsIgnoreCase("Reservado") || dep.getEstado().equalsIgnoreCase("Vendido"))) {
            return "Error: El departamento ya no está disponible.";
        }
        
        Reserva nuevaReserva = new Reserva(idReserva, cliente, dep, fecha);
        listaReservas.add(nuevaReserva);
        dep.setEstado("Reservado"); // Cambia el estado automáticamente
        return "Reserva realizada con éxito.";
    }

    // 2. PROCESO DE VENTA DIRECTA O DESDE RESERVA
    public String registrarVenta(String idVenta, Cliente cliente, Departamento dep, String modalidadPago) {
        // Validación: No se puede vender si ya está Vendido por otro
        if (dep.getEstado() != null && dep.getEstado().equalsIgnoreCase("Vendido")) {
            return "Error: El departamento ya fue vendido.";
        }

        // El precio base viene exacto del atributo de tu compañero
        double precioFinal = dep.getPrecioBase(); 
        
        Venta nuevaVenta = new Venta(idVenta, cliente, dep, modalidadPago, precioFinal);
        listaVentas.add(nuevaVenta);
        dep.setEstado("Vendido"); // Cambio automático de estado a Vendido
        
        return "Venta procesada con éxito.";
    }

    // 3. GENERACIÓN AUTOMÁTICA DEL CONTRATO DE COMPRA-VENTA
    public String generarContrato(Venta venta) {
        return "=========================================\n" +
               "       CONTRATO DE COMPRA-VENTA INMOBILIARIA  \n" +
               "=========================================\n" +
               "ID Venta: " + venta.getIdVenta() + "\n" +
               "CLIENTE:\n" +
               " - Nombre: " + venta.getCliente().getNombre() + "\n" +
               " - DNI: " + venta.getCliente().getDni() + "\n\n" +
               "INMUEBLE:\n" +
               " - Código Dep: " + venta.getDepartamento().getCodigo() + "\n" +
               " - Área: " + venta.getDepartamento().getArea() + " m2\n\n" +
               "CONDICIONES:\n" +
               " - Modalidad de Pago: " + venta.getModalidadPago() + "\n" +
               " - PRECIO TOTAL: S/. " + venta.getPrecioFinal() + "\n" +
               "=========================================";
    }

    public ArrayList<Reserva> getListaReservas() { return listaReservas; }
    public ArrayList<Venta> getListaVentas() { return listaVentas; }
}
