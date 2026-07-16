/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Entidades.Cliente;
import Gestion.GestionClientes;
import javax.swing.JOptionPane;

public class frmCliente extends javax.swing.JFrame {

    // Instanciamos el controlador para manejar los clientes en memoria
    public static GestionClientes controlClientes = new GestionClientes();

    public frmCliente() {
        initComponentsCustom();
    }

    // Creación de la interfaz por código puro para evitar el bloqueo de NetBeans
    private void initComponentsCustom() {
        lblDni = new javax.swing.JLabel("DNI:");
        lblNombre = new javax.swing.JLabel("Nombre:");
        lblTelefono = new javax.swing.JLabel("Teléfono:");
        lblIngresos = new javax.swing.JLabel("Ingresos Mensuales:");

        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtIngresos = new javax.swing.JTextField();

        btnRegistrar = new javax.swing.JButton("Registrar");
        btnBuscar = new javax.swing.JButton("Buscar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Clientes - Asesor de Ventas");

        // Evento del botón Registrar
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String dni = txtDni.getText();
                    String nombre = txtNombre.getText();
                    String telf = txtTelefono.getText();
                    double ingresos = Double.parseDouble(txtIngresos.getText());

                    Cliente nuevo = new Cliente(dni, nombre, telf, ingresos);
                    boolean exito = controlClientes.agregarCliente(nuevo);

                    if (exito) {
                        JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
                        txtDni.setText(""); txtNombre.setText(""); txtTelefono.setText(""); txtIngresos.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: El DNI ya existe.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Llene los campos correctamente (Ingresos debe ser un número).");
                }
            }
        });

        // Evento del botón Buscar
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String dniBuscar = txtDni.getText();
                Cliente encontrado = controlClientes.buscarClientePorDni(dniBuscar);

                if (encontrado != null) {
                    txtNombre.setText(encontrado.getNombre());
                    txtTelefono.setText(encontrado.getTelefono());
                    txtIngresos.setText(String.valueOf(encontrado.getIngresosMensuales()));
                    JOptionPane.showMessageDialog(null, "Cliente encontrado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                }
            }
        });

        // Diseño rápido del formulario en pantalla
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDni)
                            .addComponent(lblNombre)
                            .addComponent(lblTelefono)
                            .addComponent(lblIngresos))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtTelefono)
                            .addComponent(txtIngresos))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresos)
                    .addComponent(txtIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnBuscar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    // Componentes visuales creados dinámicamente
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblIngresos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIngresos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
}
