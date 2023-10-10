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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * productos, cantidades y precio costo
 *
 * @author tasha
 */
public class DetalleCompraData {

    private Connection con = null;

    public DetalleCompraData() {
        con = Conexion.getConexion();
    }

    public ArrayList<Compra> obtenerCompras() {
        ArrayList<Compra> compras = new ArrayList<>();
        try {
            String sql = "SELECT compra.*, proveedor.*, producto.*\n"
                    + "FROM compra\n"
                    + "JOIN proveedor ON compras.razonSocial = proveedor.razonSocial\n"
                    + "JOIN producto ON compras.idProducto = producto.idProducto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();

                //creación del objeto producto
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("producto.estado"));

                //creación del objeto proveedor
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));

                //Setear los datos de la inscripción
                compra.setIdCompra(rs.getInt("idCompra"));
                //compra.setProducto(producto);
                compra.setProveedor(proveedor);

                compras.add(compra);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla." + ex.getMessage());
        }
        return compras;
    }

    public void guardarDetalleCompra(DetalleCompra detalle, int idCompra) {
        String sql = "INSERT INTO detallecompra(`cantidad`,`precioCosto`,`idCompra`,`idProducto`) VALUES (?,?,?,?)";
        int cantidadDetalles = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioCosto());
            ps.setInt(3, idCompra);
            ps.setInt(4, detalle.getProducto().getIdProducto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cantidadDetalles++;
            }
            
            JOptionPane.showMessageDialog(null, cantidadDetalles + " detalle/s añadido/s con exito.");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de acceso: " + ex.getMessage());
        }
    }
}
