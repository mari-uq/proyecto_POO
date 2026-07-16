/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Departamento departamento;
    private String fecha;

    public Reserva(String idReserva, Cliente cliente, Departamento departamento, String fecha) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.departamento = departamento;
        this.fecha = fecha;
    }

    // Getters y Setters
    public String getIdReserva() { return idReserva; }
    public Cliente getCliente() { return cliente; }
    public Departamento getDepartamento() { return departamento; }
    public String getFecha() { return fecha; }
}