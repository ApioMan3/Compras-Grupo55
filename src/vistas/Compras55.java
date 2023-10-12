/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author tasha
 */
public class Compras55 extends javax.swing.JFrame {

    /**
     * -Registrar compra con detalles de compras
     * -Compras por fecha 
     * -Compras por proveedor 
     * -Lista de productos por compra
     * -Proveedores por producto 
     * -Productos mas comprados entre fechas
     * -Productos debajo del stock minimo
     *
     */
    public Compras55() {
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

        dpEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        compras = new javax.swing.JMenu();
        jmRegistrar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmComprasPorFecha = new javax.swing.JMenuItem();
        jmComprasPorProveedor = new javax.swing.JMenuItem();
        jmProductosPorCompra = new javax.swing.JMenuItem();
        jmProveedoresPorProducto = new javax.swing.JMenuItem();
        jmProductosPorFechas = new javax.swing.JMenuItem();
        jmProductosBajoStock = new javax.swing.JMenuItem();
        productos = new javax.swing.JMenu();
        jmProductos = new javax.swing.JMenuItem();
        proveedores = new javax.swing.JMenu();
        jmProveedores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 650));

        javax.swing.GroupLayout dpEscritorioLayout = new javax.swing.GroupLayout(dpEscritorio);
        dpEscritorio.setLayout(dpEscritorioLayout);
        dpEscritorioLayout.setHorizontalGroup(
            dpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        dpEscritorioLayout.setVerticalGroup(
            dpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 829, Short.MAX_VALUE)
        );

        compras.setText("Compras");
        compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprasActionPerformed(evt);
            }
        });

        jmRegistrar.setText("Registrar Compra");
        jmRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRegistrarActionPerformed(evt);
            }
        });
        compras.add(jmRegistrar);

        jMenu1.setText("Consultas");

        jmComprasPorFecha.setText("Compras por Fecha");
        jmComprasPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmComprasPorFechaActionPerformed(evt);
            }
        });
        jMenu1.add(jmComprasPorFecha);

        jmComprasPorProveedor.setText("Compras por Proveedor");
        jmComprasPorProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmComprasPorProveedorActionPerformed(evt);
            }
        });
        jMenu1.add(jmComprasPorProveedor);

        jmProductosPorCompra.setText("Productos por Compra");
        jmProductosPorCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProductosPorCompraActionPerformed(evt);
            }
        });
        jMenu1.add(jmProductosPorCompra);

        jmProveedoresPorProducto.setText("Proveedores por Producto");
        jmProveedoresPorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProveedoresPorProductoActionPerformed(evt);
            }
        });
        jMenu1.add(jmProveedoresPorProducto);

        jmProductosPorFechas.setText("Productos por Fechas");
        jmProductosPorFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProductosPorFechasActionPerformed(evt);
            }
        });
        jMenu1.add(jmProductosPorFechas);

        jmProductosBajoStock.setText("Productos con bajo Stock");
        jmProductosBajoStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProductosBajoStockActionPerformed(evt);
            }
        });
        jMenu1.add(jmProductosBajoStock);

        compras.add(jMenu1);

        jMenuBar1.add(compras);

        productos.setText("Productos");
        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });

        jmProductos.setText("Gestor de Productos");
        jmProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProductosActionPerformed(evt);
            }
        });
        productos.add(jmProductos);

        jMenuBar1.add(productos);

        proveedores.setText("Proveedores");

        jmProveedores.setText("Gestor de Proveedores");
        jmProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProveedoresActionPerformed(evt);
            }
        });
        proveedores.add(jmProveedores);

        jMenuBar1.add(proveedores);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpEscritorio)
        );

        getAccessibleContext().setAccessibleName("Gestor Universidad G55");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprasActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed

    }//GEN-LAST:event_productosActionPerformed

    private void jmProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProductosActionPerformed
        dpEscritorio.removeAll();
        dpEscritorio.repaint();
        gestorProductos gp = new gestorProductos();
        gp.setVisible(true);
        dpEscritorio.add(gp);
        dpEscritorio.moveToFront(gp);
    }//GEN-LAST:event_jmProductosActionPerformed

    private void jmProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProveedoresActionPerformed
        dpEscritorio.removeAll();
        dpEscritorio.repaint();
        gestorProveedores gp = new gestorProveedores();
        gp.setVisible(true);
        dpEscritorio.add(gp);
        dpEscritorio.moveToFront(gp);
    }//GEN-LAST:event_jmProveedoresActionPerformed

    private void jmComprasPorProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmComprasPorProveedorActionPerformed
        dpEscritorio.removeAll();
        dpEscritorio.repaint();
        ComprasPorProveedor cp = new ComprasPorProveedor();
        cp.setVisible(true);
        dpEscritorio.add(cp);
        dpEscritorio.moveToFront(cp);
    }//GEN-LAST:event_jmComprasPorProveedorActionPerformed

    private void jmRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRegistrarActionPerformed
        dpEscritorio.removeAll();
        dpEscritorio.repaint();
        registrarCompra rc = new registrarCompra();
        rc.setVisible(true);
        dpEscritorio.add(rc);
        dpEscritorio.moveToFront(rc);
    }//GEN-LAST:event_jmRegistrarActionPerformed

    private void jmComprasPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmComprasPorFechaActionPerformed
        dpEscritorio.removeAll();
        dpEscritorio.repaint();
        ComprasPorFecha cf = new ComprasPorFecha();
        cf.setVisible(true);
        dpEscritorio.add(cf);
        dpEscritorio.moveToFront(cf);
    }//GEN-LAST:event_jmComprasPorFechaActionPerformed

    private void jmProductosPorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProductosPorCompraActionPerformed
         dpEscritorio.removeAll();
        dpEscritorio.repaint();
        ProductosPorCompra ch = new ProductosPorCompra();
        ch.setVisible(true);
        dpEscritorio.add(ch);
        dpEscritorio.moveToFront(ch);
    }//GEN-LAST:event_jmProductosPorCompraActionPerformed

    private void jmProveedoresPorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProveedoresPorProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmProveedoresPorProductoActionPerformed

    private void jmProductosPorFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProductosPorFechasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmProductosPorFechasActionPerformed

    private void jmProductosBajoStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProductosBajoStockActionPerformed
        dpEscritorio.removeAll();
        dpEscritorio.repaint();
        ProductosConBajoStock ps = new ProductosConBajoStock();
        ps.setVisible(true);
        dpEscritorio.add(ps);
        dpEscritorio.moveToFront(ps);
    }//GEN-LAST:event_jmProductosBajoStockActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compras55.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras55.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras55.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras55.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras55().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu compras;
    private javax.swing.JDesktopPane dpEscritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmComprasPorFecha;
    private javax.swing.JMenuItem jmComprasPorProveedor;
    private javax.swing.JMenuItem jmProductos;
    private javax.swing.JMenuItem jmProductosBajoStock;
    private javax.swing.JMenuItem jmProductosPorCompra;
    private javax.swing.JMenuItem jmProductosPorFechas;
    private javax.swing.JMenuItem jmProveedores;
    private javax.swing.JMenuItem jmProveedoresPorProducto;
    private javax.swing.JMenuItem jmRegistrar;
    private javax.swing.JMenu productos;
    private javax.swing.JMenu proveedores;
    // End of variables declaration//GEN-END:variables
}
