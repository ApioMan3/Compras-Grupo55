/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Producto;
import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * productos, cantidades y precio costo
 * @author tasha
 */
public class DetalleCompraData {
    
     private Connection con = null;

    public DetalleCompraData() {
        con = Conexion.getConexion();
    }
    
    public ArrayList<DetalleCompra> obtenerCompras() { 
        ArrayList<DetalleCompra> compras = new ArrayList<>();
        try {
            String sql = "SELECT *"
                    + "FROM detalleCompra\n"
                    + "JOIN compra ON compra.idCompra = detalleCompra.idCompra\n"
                    + "JOIN producto ON compra.idProducto = producto.idProducto\n"
                    + "JOIN proveedor ON compra.idProveedor = proveedor.idProveedor";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();

                //creación del objeto producto
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("producto.estado"));
                
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setProveedor(proveedor);
                
                //Setear los datos de la inscripción
                detalleCompra.setIdDetalle(rs.getInt("idDetalle"));
                detalleCompra.setProducto(producto);
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioCosto(rs.getInt("precioCosto"));
                compras.add(detalleCompra);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla." + ex.getMessage());
        }
        return compras;
    }
    
}
