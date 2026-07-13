/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


import java.time.LocalDate;
/**
 *
 * @author PIERO
 */
public class CronogramaPago {
    private int idCronograma;
    private double monto;
    private double cuotaInicial;
    private int cantCuotas;
    private Cuota[]coutas;
    private int totalcoutas;

    public CronogramaPago(int idCronograma, double monto, double cuotaInicial, int cantCuotas) {
        this.idCronograma = idCronograma;
        this.monto = monto;
        this.cuotaInicial = cuotaInicial;
        this.cantCuotas = cantCuotas;
        this.coutas = new Cuota[cantCuotas];
        this.totalcoutas = 0;
    }

    public int getIdCronograma() {
        return idCronograma;
    }

    public void setIdCronograma(int idCronograma) {
        this.idCronograma = idCronograma;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getCuotaInicial() {
        return cuotaInicial;
    }

    public void setCuotaInicial(double cuotaInicial) {
        this.cuotaInicial = cuotaInicial;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public Cuota[] getCoutas() {
        return coutas;
    }

    public void setCoutas(Cuota[] coutas) {
        this.coutas = coutas;
    }

    public int getTotalcoutas() {
        return totalcoutas;
    }

    public void setTotalcoutas(int totalcoutas) {
        this.totalcoutas = totalcoutas;
    }
    public void registrarcuota(LocalDate fechapago){
        if(totalcoutas<cantCuotas){
            double saldo=monto- cuotaInicial;
            double montoCuota=saldo/cantCuotas;    
            int numero = totalcoutas+1;
            Cuota nuevaCuota = new Cuota(numero, montoCuota, fechapago);
            coutas[totalcoutas] = nuevaCuota;
            totalcoutas++;
        }else{
            System.out.println("No se pueden registrar más cuotas.");

            
        }
    }
    public void realizarPago(int numero, double importe) {

    for (int i = 0; i < totalcoutas; i++) {

        if (coutas[i].getNumeroCuota() == numero) {

            coutas[i].registrarPago(importe);
            return;
        }
    }
    System.out.println("La cuota no existe.");
   }

        
        
    
    
}

