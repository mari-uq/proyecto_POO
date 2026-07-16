/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

public class frmDepartamento extends javax.swing.JFrame {

    public frmDepartamento() {
        initComponentsCustom();
    }

    private void initComponentsCustom() {
        Color azulOscuro = new Color(24, 43, 73);
        Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 12);

        pnlIzquierdo = new javax.swing.JPanel();
        pnlDerecho = new javax.swing.JPanel();

        lblTitulo = new javax.swing.JLabel("REGISTRO DE DEPARTAMENTOS");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTitulo.setForeground(azulOscuro);

        lblCod = new javax.swing.JLabel("Código:"); lblCod.setFont(fuenteLabel);
        lblPiso = new javax.swing.JLabel("Piso:"); lblPiso.setFont(fuenteLabel);
        lblPrecio = new javax.swing.JLabel("Precio Base:"); lblPrecio.setFont(fuenteLabel);

        txtCod = new javax.swing.JTextField();
        txtPiso = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();

        btnGuardar = new javax.swing.JButton("Guardar Departamento");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módulo de Departamentos");
        setResizable(false);

        pnlIzquierdo.setBackground(azulOscuro);
        pnlDerecho.setBackground(Color.WHITE);

        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "Departamento guardado en el inventario inmobiliario.");
                txtCod.setText(""); txtPiso.setText(""); txtPrecio.setText("");
            }
        });

        // Layout Derecho
        javax.swing.GroupLayout pnlDerechoLayout = new javax.swing.GroupLayout(pnlDerecho);
        pnlDerecho.setLayout(pnlDerechoLayout);
        pnlDerechoLayout.setHorizontalGroup(
            pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitulo)
                    .addComponent(lblCod)
                    .addComponent(txtCod)
                    .addComponent(lblPiso)
                    .addComponent(txtPiso)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlDerechoLayout.setVerticalGroup(
            pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(15, 15, 15)
                .addComponent(lblCod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblPiso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIzquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblPiso;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlIzquierdo;
    private javax.swing.JPanel pnlDerecho;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtPrecio;
}