/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class Venta {
    private String idVenta;
    private Cliente cliente;
    private Departamento departamento;
    private String modalidadPago; // "Contado" o "Credito"
    private double precioFinal;

    public Venta(String idVenta, Cliente cliente, Departamento departamento, String modalidadPago, double precioFinal) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.departamento = departamento;
        this.modalidadPago = modalidadPago;
        this.precioFinal = precioFinal;
    }

    // Getters y Setters
    public String getIdVenta() { return idVenta; }
    public Cliente getCliente() { return cliente; }
    public Departamento getDepartamento() { return departamento; }
    public String getModalidadPago() { return modalidadPago; }
    public double getPrecioFinal() { return precioFinal; }
}
