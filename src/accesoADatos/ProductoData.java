package accesoADatos;

import entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ProductoData {
    
    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarProducto(Producto producto) {
        /* CHEQUEO PARA CUANDO YA EXISTA EL METODO LISTAR PRODUCTOS
        boolean existe = false;
        List<Producto> listados = listarProductos();
        
        for (Producto aux : listados) {
            if (aux.getIdProducto() ==alumno.getIdProducto()) {
                existe = true;
            }
 
        }
        
        if (existe) {
            modificarAlumno(alumno);
        } else{
        */
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
         //}

    }
    
}
