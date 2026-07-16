/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Entidades.Proyecto;

/**
 *
 * @author marie
 */
public class GestionProyectos {

    // Arreglo donde se almacenarán los proyectos
    private Proyecto[] proyectos;

    // Cantidad de proyectos registrados
    private int cantidad;

    // Constructor
    public GestionProyectos() {

        proyectos = new Proyecto[100];
        cantidad = 0;

    }

    // ============================
    // AGREGAR PROYECTO
    // ============================
    public boolean agregarProyecto(Proyecto proyecto) {

        // Verifica si ya existe un proyecto con el mismo nombre
        if (buscarProyecto(proyecto.getNombre()) != null) {
            return false;
        }

        // Guarda el proyecto
        proyectos[cantidad] = proyecto;

        // Incrementa la cantidad
        cantidad++;

        return true;
    }

    // ============================
    // BUSCAR PROYECTO
    // ============================
    public Proyecto buscarProyecto(String nombre) {

        for (int i = 0; i < cantidad; i++) {

            if (proyectos[i].getNombre().equalsIgnoreCase(nombre)) {

                return proyectos[i];
            }
        }

        return null;

    }

    // ============================
    // MODIFICAR PROYECTO
    // ============================
    public boolean modificarProyecto(Proyecto proyecto) {

        for (int i = 0; i < cantidad; i++) {

            if (proyectos[i].getNombre().equalsIgnoreCase(proyecto.getNombre())) {

                proyectos[i] = proyecto;

                return true;
            }
        }
        return false;

    }

    // ============================
    // ELIMINAR PROYECTO
    // ============================
    public boolean eliminarProyecto(String nombre) {

        for (int i = 0; i < cantidad; i++) {

            if (proyectos[i].getNombre().equalsIgnoreCase(nombre)) {

                for (int j = i; j < cantidad - 1; j++) {

                    proyectos[j] = proyectos[j + 1];

                }

                proyectos[cantidad - 1] = null;

                cantidad--;

                return true;
            }
        }

        return false;

    }

    // Devuelve el arreglo de proyectos
    public Proyecto[] getProyectos() {

        return proyectos;

    }

    // Devuelve la cantidad de proyectos registrados
    public int getCantidad() {

        return cantidad;

    }

}