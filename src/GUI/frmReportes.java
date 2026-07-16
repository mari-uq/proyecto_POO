/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;

public class frmReportes extends javax.swing.JFrame {

    public frmReportes() {
        initComponentsCustom();
    }

    private void initComponentsCustom() {
        Color azulOscuro = new Color(24, 43, 73);
        
        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel("PANEL DE REPORTES GERENCIALES");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTitulo.setForeground(azulOscuro);

        btnReporteVentas = new javax.swing.JButton("Ventas por Asesor");
        btnReporteProyectos = new javax.swing.JButton("Proyectos Más Vendidos");
        btnReporteEstados = new javax.swing.JButton("Departamentos por Estado");
        
        txtAreaReportes = new javax.swing.JTextArea(12, 40);
        txtAreaReportes.setEditable(false);
        txtAreaReportes.setFont(new Font("Consolas", Font.PLAIN, 12));
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(txtAreaReportes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módulo de Finanzas");
        
        pnlPrincipal.setBackground(Color.WHITE);

        btnReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaReportes.setText("=== REPORTE: VENTAS POR ASESOR ===\n" +
                                       "1. Asesor Ventas (Tú) -> 1 Inmueble Vendido (S/. 280,000.0)\n" +
                                       "Región: Lima Metropolitana\n" +
                                       "Estado de Metas: 100% Completado.");
            }
        });

        btnReporteProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaReportes.setText("=== REPORTE: PROYECTOS MÁS VENDIDOS ===\n" +
                                       "1. Proyecto Edificio Edén - Depto 502 -> Vendido\n" +
                                       "Tipo de Unidad: Flat\n" +
                                       "Demanda actual: Alta.");
            }
        });

        btnReporteEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int totalReservados = frmReservaVenta.controlVentas.getListaReservas().size();
                int totalVendidos = frmReservaVenta.controlVentas.getListaVentas().size();
                
                txtAreaReportes.setText("=== REPORTE: DEPARTAMENTOS POR ESTADO ===\n" +
                                       " - Total Vendidos en esta sesión: " + totalVendidos + "\n" +
                                       " - Total Reservados en esta sesión: " + totalReservados + "\n" +
                                       " - Disponibles en Catálogo: Dinámico en memoria.");
            }
        });

        // Layout de Reportes
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReporteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporteProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporteEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        frameLayout.setVerticalGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    private javax.swing.JButton btnReporteEstados;
    private javax.swing.JButton btnReporteProyectos;
    private javax.swing.JButton btnReporteVentas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextArea txtAreaReportes;
}
