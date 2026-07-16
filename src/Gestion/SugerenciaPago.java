/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author PIERO
 */
public class SugerenciaPago {

    private String recomendacion;

    public SugerenciaPago() {
        recomendacion = "SIN EVALUAR";
    }

    public String evaluarPago(double precioDepartamento,
                              double ingresoMensual) {

        if (ingresoMensual <= 0) {

            recomendacion = "INGRESO NO VÁLIDO";

        } else if (precioDepartamento <= ingresoMensual * 20) {

            recomendacion = "PAGO AL CONTADO";

        } else if (precioDepartamento <= ingresoMensual * 50) {

            recomendacion = "CUOTAS CORTAS";

        } else {

            recomendacion = "CUOTAS LARGAS";

        }

        return recomendacion;
    }

    public String getRecomendacion() {
        return recomendacion;
    }
}