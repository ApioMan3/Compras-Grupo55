/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.ProveedorData;
import entidades.Proveedor;
import javax.swing.JOptionPane;

/**
 *
 * @author ApioMan
 */
public class GestorProveedores extends javax.swing.JInternalFrame {

    /**
     * Creates new form gestorProveedores
     */
    public GestorProveedores() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfRazon = new javax.swing.JTextField();
        tfDomicilio = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setTitle("Gestor de Proveedores");
        setToolTipText("Gestor que permite buscar un proveedor en la base de datos, actualizarlo o crear uno nuevo.");

        jLabel1.setText("ID:");

        jLabel2.setText("Razón Social:");

        jLabel3.setText("Domicilio:");

        jLabel4.setText("Teléfono:");

        bBuscar.setBackground(new java.awt.Color(255, 255, 204));
        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        bNuevo.setBackground(new java.awt.Color(255, 255, 204));
        bNuevo.setText("Nuevo");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });

        bGuardar.setBackground(new java.awt.Color(255, 255, 204));
        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bSalir.setBackground(new java.awt.Color(255, 255, 204));
        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(bBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfRazon, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(bGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(bSalir)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfRazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNuevo)
                    .addComponent(bGuardar)
                    .addComponent(bSalir))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        try {
            int id = Integer.parseInt(tfID.getText());
            ProveedorData acceso = new ProveedorData();
            Proveedor proveedor = acceso.buscarProveedor(id);
            if (proveedor != null) {
                tfRazon.setText(proveedor.getRazonSocial());
                tfDomicilio.setText(proveedor.getDomicilio());
                tfTelefono.setText(proveedor.getTelefono());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el campo ID.");
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        vaciar();
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        ProveedorData acceso = new ProveedorData();
        Proveedor proveedor = null;
        try {
            if (!tfID.getText().equalsIgnoreCase("")) {
                proveedor = crearProveedor();
                boolean existe = acceso.verificarExistencia(proveedor);
                System.out.println(existe);

                if (existe) {
                    try {
                        acceso.modificarProveedor(proveedor);
                        vaciar();
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Error númerico " + e.getMessage());
                    }
                } else {

                    if (tfDomicilio.getText().isEmpty() || tfRazon.getText().isEmpty()|| tfTelefono.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No pueden haber campos vacíos.");
                    } else {
                        try {
                            proveedor = crearProveedorSinID();
                            acceso.guardarProveedor(proveedor);
                            vaciar();
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Error númerico " + e.getMessage());
                        }
                    }

                }
            } else {

                if (tfDomicilio.getText().isEmpty() || tfRazon.getText().isEmpty()|| tfTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No pueden haber campos vacíos.");
                } else {
                    try {
                        proveedor = crearProveedorSinID();
                            acceso.guardarProveedor(proveedor);
                            vaciar();
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Error númerico " + e.getMessage());
                    }
                }

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error númerico " + e.getMessage());
        }
    }//GEN-LAST:event_bGuardarActionPerformed

    private void vaciar() {
        tfID.setText("");
        tfRazon.setText("");
        tfDomicilio.setText("");
        tfTelefono.setText("");
    }

    private Proveedor crearProveedor() {
        Proveedor producto = new Proveedor();
        producto.setIdProveedor(Integer.parseInt(tfID.getText()));
        producto.setRazonSocial(tfRazon.getText());
        producto.setDomicilio(tfDomicilio.getText());
        producto.setTelefono(tfTelefono.getText());
        return producto;
    }

    private Proveedor crearProveedorSinID() {
        Proveedor producto = new Proveedor();
        producto.setRazonSocial(tfRazon.getText());
        producto.setDomicilio(tfDomicilio.getText());
        producto.setTelefono(tfTelefono.getText());
        return producto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tfDomicilio;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfRazon;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
