/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Entidades.Cliente;
import Entidades.Departamento;
import Entidades.Venta;
import Gestion.GestionVentas;
import javax.swing.JOptionPane;

public class frmReservaVenta extends javax.swing.JFrame {

    // Instanciamos tu cerebro controlador de ventas y reservas
    public static GestionVentas controlVentas = new GestionVentas();

    public frmReservaVenta() {
        initComponentsCustom();
    }

    private void initComponentsCustom() {
        lblDni = new javax.swing.JLabel("DNI Cliente:");
        lblCodDep = new javax.swing.JLabel("Código Depto:");
        lblPago = new javax.swing.JLabel("Mod. Pago:");
        lblFecha = new javax.swing.JLabel("Fecha (DD/MM):");

        txtDni = new javax.swing.JTextField();
        txtCodDep = new javax.swing.JTextField();
        txtPago = new javax.swing.JTextField("Contado"); // Valor por defecto
        txtFecha = new javax.swing.JTextField("13/07");

        btnReservar = new javax.swing.JButton("Reservar Depto");
        btnVender = new javax.swing.JButton("Registrar Venta");
        
        txtContratoArea = new javax.swing.JTextArea(10, 30);
        txtContratoArea.setEditable(false);
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(txtContratoArea);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módulo de Ventas y Reservas - Asesor");

        // EVENTO: BOTÓN RESERVAR
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // 1. Buscamos si el cliente existe en la memoria del otro formulario
                Cliente c = frmCliente.controlClientes.buscarClientePorDni(txtDni.getText());
                if (c == null) {
                    JOptionPane.showMessageDialog(null, "Error: El cliente no está registrado primero.");
                    return;
                }

                // 2. Simulamos la existencia de un departamento con el código ingresado
                // (Para que encaje con la clase Departamento de tu compañero)
                Departamento dep = new Departamento(txtCodDep.getText(), 5, 502, 75.5, 3, 2, "Flat", 280000.0, "Disponible");

                // 3. Ejecutamos tu lógica de reserva
                String resultado = controlVentas.reservarDepartamento("R-" + txtCodDep.getText(), c, dep, txtFecha.getText());
                JOptionPane.showMessageDialog(null, resultado);
            }
        });

        // EVENTO: BOTÓN VENDER Y GENERAR CONTRATO
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cliente c = frmCliente.controlClientes.buscarClientePorDni(txtDni.getText());
                if (c == null) {
                    JOptionPane.showMessageDialog(null, "Error: El cliente debe estar registrado.");
                    return;
                }

                // Departamento simulado según los atributos exactos de tu compañero
                Departamento dep = new Departamento(txtCodDep.getText(), 5, 502, 75.5, 3, 2, "Flat", 280000.0, "Disponible");

                // Registramos la venta usando tu controlador
                String resultado = controlVentas.registrarVenta("V-" + txtCodDep.getText(), c, dep, txtPago.getText());
                JOptionPane.showMessageDialog(null, resultado);

                if (!resultado.contains("Error")) {
                    // Creamos el objeto venta para pasárselo a tu método de contrato automático
                    Venta v = new Venta("V-" + txtCodDep.getText(), c, dep, txtPago.getText(), dep.getPrecioBase());
                    String contrato = controlVentas.generarContrato(v);
                    
                    // Imprimimos el contrato en el cuadro de texto de la pantalla
                    txtContratoArea.setText(contrato);
                }
            }
        });

        // DISEÑO GEOMÉTRICO PLANO DE LA INTERFAZ
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDni)
                            .addComponent(lblCodDep)
                            .addComponent(lblPago)
                            .addComponent(lblFecha))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDni)
                            .addComponent(txtCodDep)
                            .addComponent(txtPago)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReservar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodDep)
                    .addComponent(txtCodDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPago)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
    private javax.swing.JTextField txtCodDep;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextArea txtContratoArea;
}
