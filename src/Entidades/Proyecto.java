/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author marie
 */
public class Proyecto {

    // ATRIBUTOS DEL PROYECTO

    private String nombre; // Nombre del proyecto.
    private String direccion; // Dirección del proyecto.
    private String distrito; // Distrito donde se ubica.
    private int numeroPisos; // Cantidad de pisos.
    private String fechaInicio; // Fecha de inicio de obra.
    private String fechaEntrega; // Fecha estimada de entrega.
    private String estado; // Estado del proyecto.

    // ATRIBUTOS PARA DEPARTAMENTOS

    private Departamento[] departamentos; // Arreglo de departamentos del proyecto.
    private int cantidadDepartamentos; // Cantidad de departamentos registrados.

    // CONSTRUCTORES

    public Proyecto() {

        departamentos = new Departamento[300]; // Espacio para 300 departamentos.
        cantidadDepartamentos = 0; // Inicialmente no hay departamentos.

    }

    public Proyecto(String nombre, String direccion, String distrito,
            int numeroPisos, String fechaInicio,
            String fechaEntrega, String estado) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.distrito = distrito;
        this.numeroPisos = numeroPisos;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;

        departamentos = new Departamento[300]; // Inicializa el arreglo.
        cantidadDepartamentos = 0; // Inicializa el contador.

    }


    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    // GETTERS PARA DEPARTAMENTOS

    public Departamento[] getDepartamentos() {
        return departamentos;
    }

    public int getCantidadDepartamentos() {
        return cantidadDepartamentos;
    }

    public void setCantidadDepartamentos(int cantidadDepartamentos) {
        this.cantidadDepartamentos = cantidadDepartamentos;
    }

    // ============================

    @Override
    public String toString() {
        return nombre;
    }

}
