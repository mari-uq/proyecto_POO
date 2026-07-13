/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Entidades.Cliente;
import Entidades.Departamento;
import Entidades.Venta;
import Gestion.GestionVentas;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public class frmReservaVenta extends javax.swing.JFrame {

    public static GestionVentas controlVentas = new GestionVentas();

    public frmReservaVenta() {
        initComponentsCustom();
    }

    private void initComponentsCustom() {
        // Estilos Modernos Coincidentes
        Color azulOscuro = new Color(24, 43, 73);
        Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 12);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 16);

        // Paneles
        pnlIzquierdo = new javax.swing.JPanel();
        pnlDerecho = new javax.swing.JPanel();

        // Componentes del Formulario
        lblTitulo = new javax.swing.JLabel("OPERACIONES DE VENTA");
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(azulOscuro);

        lblDni = new javax.swing.JLabel("DNI Cliente:"); lblDni.setFont(fuenteLabel);
        lblCodDep = new javax.swing.JLabel("Código Depto:"); lblCodDep.setFont(fuenteLabel);
        lblPago = new javax.swing.JLabel("Mod. Pago:"); lblPago.setFont(fuenteLabel);
        lblFecha = new javax.swing.JLabel("Fecha (DD/MM):"); lblFecha.setFont(fuenteLabel);

        txtDni = new javax.swing.JTextField();
        txtCodDep = new javax.swing.JTextField();
        txtPago = new javax.swing.JTextField("Contado");
        txtFecha = new javax.swing.JTextField("13/07");

        btnReservar = new javax.swing.JButton("Reservar");
        btnVender = new javax.swing.JButton("Registrar Venta");
        
        // Área del Contrato
        txtContratoArea = new javax.swing.JTextArea(10, 30);
        txtContratoArea.setFont(new Font("Consolas", Font.PLAIN, 11));
        txtContratoArea.setEditable(false);
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(txtContratoArea);

        // Intentar cargar iconos decorativos
        try {
            btnReservar.setIcon(new ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // Puedes cambiarlo por otro luego
            btnVender.setIcon(new ImageIcon(getClass().getResource("/imagenes/check.png")));
            lblImagenLateral = new javax.swing.JLabel(new ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // Icono de módulo
        } catch (Exception e) {
            lblImagenLateral = new javax.swing.JLabel("[ Ventas ]");
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módulo de Ventas e Inmuebles");
        setResizable(false);

        // Colores de fondo de paneles
        pnlIzquierdo.setBackground(new Color(24, 43, 73)); // Fondo azul oscuro para contrastar
        pnlDerecho.setBackground(Color.WHITE);

        // EVENTO: BOTÓN RESERVAR
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cliente c = frmCliente.controlClientes.buscarClientePorDni(txtDni.getText());
                if (c == null) {
                    JOptionPane.showMessageDialog(null, "Error: El cliente no está registrado.");
                    return;
                }
                Departamento dep = new Departamento(txtCodDep.getText(), 5, 502, 75.5, 3, 2, "Flat", 280000.0, "Disponible");
                String resultado = controlVentas.reservarDepartamento("R-" + txtCodDep.getText(), c, dep, txtFecha.getText());
                JOptionPane.showMessageDialog(null, resultado);
            }
        });

        // EVENTO: BOTÓN VENDER
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cliente c = frmCliente.controlClientes.buscarClientePorDni(txtDni.getText());
                if (c == null) {
                    JOptionPane.showMessageDialog(null, "Error: El cliente debe estar registrado.");
                    return;
                }
                Departamento dep = new Departamento(txtCodDep.getText(), 5, 502, 75.5, 3, 2, "Flat", 280000.0, "Disponible");
                String resultado = controlVentas.registrarVenta("V-" + txtCodDep.getText(), c, dep, txtPago.getText());
                JOptionPane.showMessageDialog(null, resultado);

                if (!resultado.contains("Error")) {
                    Venta v = new Venta("V-" + txtCodDep.getText(), c, dep, txtPago.getText(), dep.getPrecioBase());
                    String contrato = controlVentas.generarContrato(v);
                    txtContratoArea.setText(contrato);
                }
            }
        });

        // Layout Panel Izquierdo (Lateral decorativo)
        javax.swing.GroupLayout layoutIzquierdo = new javax.swing.GroupLayout(pnlIzquierdo);
        pnlIzquierdo.setLayout(layoutIzquierdo);
        layoutIzquierdo.setHorizontalGroup(
            layoutIzquierdo.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutIzquierdo.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblImagenLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layoutIzquierdo.setVerticalGroup(
            layoutIzquierdo.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutIzquierdo.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblImagenLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Layout Panel Derecho (Formulario y área de texto)
        javax.swing.GroupLayout layoutDerecho = new javax.swing.GroupLayout(pnlDerecho);
        pnlDerecho.setLayout(layoutDerecho);
        layoutDerecho.setHorizontalGroup(
            layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutDerecho.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane)
                    .addComponent(lblTitulo)
                    .addGroup(layoutDerecho.createSequentialGroup()
                        .addGroup(layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDni)
                            .addComponent(lblCodDep)
                            .addComponent(lblPago)
                            .addComponent(lblFecha))
                        .addGap(20, 20, 20)
                        .addGroup(layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDni)
                            .addComponent(txtCodDep)
                            .addComponent(txtPago)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReservar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layoutDerecho.setVerticalGroup(
            layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutDerecho.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(20, 20, 20)
                .addGroup(layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodDep)
                    .addComponent(txtCodDep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPago)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layoutDerecho.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        // Ensamblado
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel lblCodDep;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPago;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblImagenLateral;
    private javax.swing.JPanel pnlIzquierdo;
    private javax.swing.JPanel pnlDerecho;
    private javax.swing.JTextField txtCodDep;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextArea txtContratoArea;
}
