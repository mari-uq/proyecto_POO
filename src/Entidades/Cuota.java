/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author PIERO
 */
import java.time.LocalDate;

public class Cuota {

    private int numeroCuota;
    private double montoTotal;
    private LocalDate fechaVencimiento;
    private double montoPagado;
    private String estado;

    public Cuota(int numeroCuota, double montoTotal, LocalDate fechaVencimiento) {
        this.numeroCuota = numeroCuota;
        this.montoTotal = montoTotal;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPagado=0;
        this.estado="Pendiente";
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    public double calcularSaldoPendiente() {
         return montoTotal - montoPagado;
    }
    
    public boolean estaVencida() {
    if (LocalDate.now().isAfter(fechaVencimiento)) {
        return true;
    } else {
        return false;
    }
      }
    
    public void registrarPago(double importe) {
    montoPagado = montoPagado + importe;
    if (montoPagado >= montoTotal) {
        montoPagado = montoTotal;
        estado = "PAGADA";
    } else {
        estado = "PARCIAL";
     }
    }
    
    public String mostrarCuota() {

    return "Cuota N° " + numeroCuota +
           "\nMonto Total: S/ " + montoTotal +
           "\nMonto Pagado: S/ " + montoPagado +
           "\nSaldo Pendiente: S/ " + calcularSaldoPendiente() +
           "\nFecha de Vencimiento: " + fechaVencimiento +
           "\nEstado: " + estado;

       }    
    
    

         
      
    
    

}

