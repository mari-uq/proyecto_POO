/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Entidades.Departamento;
import Entidades.Venta;
import java.util.ArrayList;
/**
 *
 * @author PIERO
 */
public class ReporteGerencial {

    public String reporteIngresos(ArrayList<Venta> ventas) {

        double total = 0;

        for (int i = 0; i < ventas.size(); i++) {

            total = total + ventas.get(i).getPrecioFinal();

        }

        return "REPORTE DE INGRESOS"
                + "\nTotal de ventas: " + ventas.size()
                + "\nMonto recaudado: S/ " + total;

    }

    public String reporteDepartamentos(ArrayList<Departamento> departamentos) {
   
        int disponible = 0;
        int reservado = 0;
        int vendido = 0;

        for (int i = 0; i < departamentos.size(); i++) {

            String estado = departamentos.get(i).getEstado();

            if (estado.equalsIgnoreCase("Disponible")) {
                disponible++;

            }
            if (estado.equalsIgnoreCase("Reservado")) {
                reservado++;
            }
            if (estado.equalsIgnoreCase("Vendido")) {
                vendido++;
            }

        }

        return "REPORTE DE DEPARTAMENTOS"
                + "\nDisponibles: " + disponible
                + "\nReservados: " + reservado
                + "\nVendidos: " + vendido;

    }

}