package accesoADatos;

import entidades.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoData {

    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }

    public void modificarProducto(Producto producto) {

        String sql = "UPDATE producto SET nombre = ?, descripcion = ? , stock = ? , precioActual = ? , estado = ? WHERE idProducto = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getStock());
            ps.setDouble(4, producto.getPrecioActual());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getIdProducto());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }

    }

    public void guardarProducto(Producto producto) {

        String sql = "INSERT INTO `producto`(`idProducto`,`nombre`, `descripcion`, `precioActual`, `stock`, `estado`) VALUES ('[value-1]',?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Producto añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de acceso: " + ex.getMessage());
        }

    }

    public Producto buscarProducto(int id) {
        Producto producto = null;
        String sql = "SELECT nombre, descripcion, precioActual, stock, estado FROM producto WHERE idProducto = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(id);
                producto.setNombreProducto(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto con dicho ID.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return producto;
    }

    public void modificarProductoEstado(int id) {

        String sql = "UPDATE producto SET estado = ? WHERE idProducto = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. " + ex.getMessage());
        }
    }

    public List<Producto> listarTodosLosProductos() {

        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return productos;
    }

    public List<Producto> listarTodosLosProductosActivos() {

        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return productos;
    }

    public boolean verificarExistencia(Producto producto) {
        boolean existencia = false;
        List<Producto> listados = listarTodosLosProductos();

        for (Producto aux : listados) {
            if (aux.getIdProducto() == producto.getIdProducto()) {
                existencia = true;
            }
        }

        return existencia;
    }

    public void actualizarStock(int stockComprado, int idProducto) {

        String sql = "UPDATE producto SET stock = stock + ? WHERE idProducto = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, stockComprado);
            ps.setInt(2, idProducto);
            int exito = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto " + ex.getMessage());
        }

    }

    public List<Producto> productosConBajoStock(int id) {

        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto WHERE stock BETWEEN 0 AND ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Producto " + ex.getMessage());
        }
        return productos;
    }

}
