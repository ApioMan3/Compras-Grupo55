
package accesoADatos;

import entidades.Compra;
import entidades.Proveedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CompraData {
    
    private Connection con = null;

    public CompraData() {
        con = Conexion.getConexion();
    }
    
    public List<Compra> listarCompras() {
        List<Compra> compras = new ArrayList<>();
        try {
            String sql = "SELECT * FROM compra JOIN proveedor ON compra.idProveedor = proveedor.idProveedor";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setProveedor(proveedor);
                compras.add(compra);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Proveedor " + ex.getMessage());
        }
        return compras;
    }
    
    public List<Compra> listarComprasPorFecha(LocalDate fecha) {
        List<Compra> compras = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM compra JOIN proveedor ON compra.idProveedor = proveedor.idProveedor WHERE fecha = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setProveedor(proveedor);
                compras.add(compra);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Proveedor " + ex.getMessage());
        }
        return compras;
    }
    
    
    public List<Compra> listarComprasPorProveedor(int id) {
        List<Compra> compras = new ArrayList<>();
        
        try {
            String sql = "SELECT compra.*, proveedor.* FROM compra JOIN proveedor ON compra.idProveedor = proveedor.idProveedor WHERE compra.idProveedor = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setProveedor(proveedor);
                compras.add(compra);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Proveedor " + ex.getMessage());
        }
        return compras;
    }
    
    public int guardarCompra(Compra compra) {

        String sql = "INSERT INTO compra (fecha, idProveedor) VALUES (?,?)";
        int idcompra = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(compra.getFecha()));
            ps.setInt(2, compra.getProveedor().getIdProveedor());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idcompra = rs.getInt("insert_id");
                JOptionPane.showMessageDialog(null, "Compra añadida con exito.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de acceso: " + ex.getMessage());
        }
        return idcompra;
    }
}
