/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;

public class frmPrincipal extends javax.swing.JFrame {

    private String rolUsuario;

    public frmPrincipal(String rol) {
        this.rolUsuario = rol;
        initComponentsCustom();
        evaluarPermisos();
    }

    private void initComponentsCustom() {
        Color azulOscuro = new Color(24, 43, 73);
        
        pnlSuperior = new javax.swing.JPanel();
        pnlCentro = new javax.swing.JPanel();

        lblBienvenida = new javax.swing.JLabel("SISTEMA INMOBILIARIO - PANEL PRINCIPAL");
        lblBienvenida.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblBienvenida.setForeground(Color.WHITE);

        btnModuloAdmin = new javax.swing.JButton("Gestión Estructura (Admin)");
        btnModuloAsesor = new javax.swing.JButton("Gestión Ventas/Clientes (Asesor)");
        btnModuloGerente = new javax.swing.JButton("Reportes y Finanzas (Gerente)");
        btnCerrarSesion = new javax.swing.JButton("Cerrar Sesión");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel Principal");

        pnlSuperior.setBackground(azulOscuro);
        pnlCentro.setBackground(Color.WHITE);

        // Eventos para abrir los formularios correspondientes
        btnModuloAsesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new frmCliente().setVisible(true);
                new frmReservaVenta().setVisible(true);
            }
        });

        btnModuloGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new frmReportes().setVisible(true);
            }
        });

        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new frmLogin().setVisible(true);
                dispose();
            }
        });

        // Layout Superior
        pnlSuperior.add(lblBienvenida);

        // Layout Centro
        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModuloAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModuloAsesor, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(btnModuloGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnModuloAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnModuloAsesor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnModuloGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void evaluarPermisos() {
        if (rolUsuario.equals("Asesor")) {
            btnModuloAdmin.setEnabled(false);
            btnModuloGerente.setEnabled(false);
        } else if (rolUsuario.equals("Gerente")) {
            btnModuloAdmin.setEnabled(false);
            btnModuloAsesor.setEnabled(false);
        }
    }

    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnModuloAdmin;
    private javax.swing.JButton btnModuloAsesor;
    private javax.swing.JButton btnModuloGerente;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlSuperior;
}