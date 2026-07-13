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



public class Pago {

    private int idPago;
    private LocalDate fechaRegistro;
    private double importe;
    private String tipoPago;
    private String detalle;

    public Pago(int idPago, LocalDate fechaRegistro, double importe, String tipoPago, String detalle) {
        this.idPago = idPago;
        this.fechaRegistro = fechaRegistro;
        this.importe = importe;
        this.tipoPago = tipoPago;
        this.detalle = detalle;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    public String verPago() {

        return "id pago: " + idPago
                + "\nfecha: " + fechaRegistro
                + "\nimporte: S/ " + importe
                + "\ntipo de pago: " + tipoPago
                + "\ndetalle: " + detalle;

    }
}//nice