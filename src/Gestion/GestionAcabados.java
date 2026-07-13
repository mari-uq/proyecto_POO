/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Entidades.Acabado;

/**
 *
 * @author marie
 */
public class GestionAcabados {

    // Arreglo donde se almacenarán los acabados
    private Acabado[] acabados;

    // Cantidad de acabados registrados
    private int cantidad;

    // Constructor
    public GestionAcabados() {

        acabados = new Acabado[100];
        cantidad = 0;

    }

    // ============================
    // AGREGAR ACABADO
    // ============================
    public boolean agregarAcabado(Acabado acabado) {

        // Verifica si ya existe un acabado con el mismo nombre
        if (buscarAcabado(acabado.getNombre()) != null) {
            return false;
        }

        // Guarda el acabado
        acabados[cantidad] = acabado;

        // Incrementa la cantidad
        cantidad++;

        return true;

    }

    // ============================
    // BUSCAR ACABADO
    // ============================
    public Acabado buscarAcabado(String nombre) {

        for (int i = 0; i < cantidad; i++) {

            if (acabados[i].getNombre().equalsIgnoreCase(nombre)) {

                return acabados[i];
            }
        }

        return null;

    }

    // ============================
    // MODIFICAR ACABADO
    // ============================
    public boolean modificarAcabado(Acabado acabado) {

        for (int i = 0; i < cantidad; i++) {

            if (acabados[i].getNombre().equalsIgnoreCase(acabado.getNombre())) {

                acabados[i] = acabado;

                return true;
            }
        }
        return false;

    }

    // ============================
    // ELIMINAR ACABADO
    // ============================
    public boolean eliminarAcabado(String nombre) {

        for (int i = 0; i < cantidad; i++) {

            if (acabados[i].getNombre().equalsIgnoreCase(nombre)) {

                for (int j = i; j < cantidad - 1; j++) {

                    acabados[j] = acabados[j + 1];

                }

                acabados[cantidad - 1] = null;

                cantidad--;

                return true;
            }
        }
        return false;

    }

    // Devuelve el arreglo de acabados
    public Acabado[] getAcabados() {

        return acabados;

    }

    // Devuelve la cantidad de acabados registrados
    public int getCantidad() {

        return cantidad;

    }

}
