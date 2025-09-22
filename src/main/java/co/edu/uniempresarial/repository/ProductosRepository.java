package co.edu.uniempresarial.repository;

import co.edu.uniempresarial.entity.Productos;
import co.edu.uniempresarial.util.ConexionDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductosRepository {

    //Atributos 
    private ConexionDB conexionDB;//Objeto
    private PreparedStatement preStm;

    //Constructor
    public ProductosRepository() {
        this.conexionDB = new ConexionDB();
        this.preStm = null;
    }

    //Metodos Crud
    public boolean registrarProdcuto(Productos producto) {
        Connection con = conexionDB.getConectionDB();
        String sqlQuery = "INSERT INTO productos VALUES(null,?,?,?,?,?,?)";
        int status = 1;
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, producto.getPro_referencia());
                this.preStm.setString(2, producto.getPro_nombre());
                this.preStm.setInt(3, producto.getPro_stock());
                this.preStm.setInt(4, producto.getPro_precio());
                this.preStm.setInt(5, status);
                this.preStm.setInt(6, producto.getCat_id());

                int response = this.preStm.executeUpdate();
                if (response > 0) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            if ((con != null) && (this.preStm != null)) {
                try {
                    con.close();
                    this.preStm.close();
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return true;
    }

    //Consulta para traer todos los datos
    public List<Productos> getAllProductos() {
        Connection con = conexionDB.getConectionDB();
        String sqlQuery = "SELECT * FROM productos WHERE pro_status = 1;";
        List<Productos> productosList = new ArrayList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                productosList.add(new Productos(resultSet.getInt("pro_id"), resultSet.getString("pro_referencia"), resultSet.getString("pro_nombre"), resultSet.getInt("pro_stock"), resultSet.getInt("pro_precio"), resultSet.getInt("cat_id"), resultSet.getInt("pro_status") ));
            
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            if ((con != null) && (this.preStm != null)) {
                try {
                    con.close();
                    this.preStm.close();
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return productosList;
    }

    //metodo para actualizar -> recibir objeto
    public boolean actualizarProducto(Productos producto) {
        Connection con = conexionDB.getConectionDB();
        String sqlQuery = "UPDATE productos SET pro_referencia = ?, pro_nombre = ?, pro_stock = ?, pro_precio = ?, cat_id = ? WHERE pro_id  = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, producto.getPro_referencia());
                this.preStm.setString(2, producto.getPro_nombre());
                this.preStm.setInt(3, producto.getPro_stock());
                this.preStm.setInt(4, producto.getPro_precio());
                this.preStm.setInt(5, producto.getCat_id());
                this.preStm.setInt(6, producto.getPro_id());
                
                System.out.println(producto.getCat_id());

                int response = this.preStm.executeUpdate();
                if (response > 0) {
                    JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            if ((con != null) && (this.preStm != null)) {
                try {
                    con.close();
                    this.preStm.close();
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return true;
    }

    //Metodo para dar de baja -> ID  -> actualizar el statis a 0
    public boolean bajaProducto(int id) {
        Connection con = conexionDB.getConectionDB();
        String sqlQuery = "UPDATE productos SET pro_status = 0 WHERE pro_id  = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, id);

                int response = this.preStm.executeUpdate();
                if (response > 0) {
                    JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            if ((con != null) && (this.preStm != null)) {
                try {
                    con.close();
                    this.preStm.close();
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return true;
    }

    //Seleccion de sentencia
    public String eleccionSentencia(String eleccion){
        String sqlQuery = "";
        if ("nombre".equals(eleccion)) {
            sqlQuery = "SELECT * FROM productos WHERE pro_status = 1 AND pro_nombre LIKE ?";
        } else if ("referencia".equals(eleccion)) {
            sqlQuery = "SELECT * FROM productos WHERE pro_status = 1 AND pro_referencia LIKE ?";
        } else if ("stock".equals(eleccion)) {
            sqlQuery = "SELECT * FROM productos WHERE pro_status = 1 AND pro_stock LIKE ?";
        } else if ("precio".equals(eleccion)) {
            sqlQuery = "SELECT * FROM productos WHERE pro_status = 1 AND pro_precio LIKE ?";
        }
        return sqlQuery;
    }

    //Consultas o busquedas -> Todos los datos 
    public List<Productos> getProducto(String busqueda, String sqlQuery) {
        Connection con = conexionDB.getConectionDB();
        List<Productos> productosList = new ArrayList<>();
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, busqueda + "%");

                ResultSet resultSet = this.preStm.executeQuery();
                while (resultSet.next()) {
                    productosList.add(new Productos(resultSet.getInt("pro_id"), resultSet.getString("pro_referencia"), resultSet.getString("pro_nombre"), resultSet.getInt("pro_stock"), resultSet.getInt("pro_precio"), resultSet.getInt("cat_id"), resultSet.getInt("pro_status")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            if ((con != null) && (this.preStm != null)) {
                try {
                    con.close();
                    this.preStm.close();
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return productosList;
    }

}
