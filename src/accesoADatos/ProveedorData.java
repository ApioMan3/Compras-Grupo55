/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Producto;
import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tasha
 */
public class ProveedorData {
    
     private Connection con = null;
     
     public ProveedorData() {
        con = Conexion.getConexion();
    }
    
    public List<Proveedor> listarProveedores(){
                
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM proveedor";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();

                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Proveedor " + ex.getMessage());
        }
         return proveedores;
        
    }
    
    public Proveedor buscarProveedor(int id) {
        Proveedor proveedor = null;
        String sql = "SELECT razonSocial, domicilio, telefono FROM proveedor WHERE idProveedor = ? ";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(id);
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el proveedor o fue dado de baja."
                        + " Revise el apartado de Gestor de Proveedor.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proveedor " + ex.getMessage());
        }
        return proveedor;
    }
    
     public void modificarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedor SET razonSocial = ?, domicilio = ?, telefono = ? WHERE idProveedor = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getTelefono());
            ps.setInt(4, proveedor.getIdProveedor());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El proveedor no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proveedor " + ex.getMessage());
        }
    }
    
        public void guardarProveedor(Proveedor proveedor) {

        boolean existe = false;
        List<Proveedor> listados = listarProveedores(); //Array (?)
        for (Proveedor aux : listados) {
            if (proveedor.getIdProveedor() == aux.getIdProveedor()) {
                existe = true;
            }
        }
        if (existe) {
            modificarProveedor(proveedor);
        } else {

            String sql = "INSERT INTO `proveedor`(`idProveedor`, `razonSocial`, `domicilio`, `telefono`) VALUES ('[value-1]',?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, proveedor.getRazonSocial());
                ps.setString(2, proveedor.getDomicilio());
                ps.setString(3, proveedor.getTelefono());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Proveedor añadido con éxito.");
                }
                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de acceso: " + ex.getMessage());
            }
        }
    }
        
}
