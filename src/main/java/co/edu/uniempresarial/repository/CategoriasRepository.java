package co.edu.uniempresarial.repository;

import co.edu.uniempresarial.entity.Categorias;
import co.edu.uniempresarial.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriasRepository {

    //Atributos 
    private ConexionDB conexionDB;//Objeto
    private PreparedStatement preStm;

    //Constructor
    public CategoriasRepository() {
        this.conexionDB = new ConexionDB();
        this.preStm = null;
    }

    //Metodos CRUD
    public boolean regsitrarCategorias(Categorias categoria) {
        Connection con = conexionDB.getConectionDB();
        String sqlQuery = "INSERT INTO categorias VALUES(null,?,?)";
        int status = 1;
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, categoria.getCat_nombre());
                this.preStm.setInt(2, status);

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
    public List<Categorias> getAllCategorias() {
        Connection con = conexionDB.getConectionDB();
        String sqlQuery = "SELECT * FROM categorias WHERE cat_status = 1;";
        List<Categorias> categoriasList = new ArrayList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                categoriasList.add(new Categorias(resultSet.getInt("cat_id"), resultSet.getString("cat_nombre"), resultSet.getInt("cat_status")));
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
        return categoriasList;
    }

    //Consulta para actualizar
    public boolean actualizarCategoria(Categorias categoria) {
        Connection con = conexionDB.getConectionDB();
        String sqlQuery = "UPDATE categorias SET cat_nombre = ? WHERE cat_id  = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, categoria.getCat_nombre());
                this.preStm.setInt(2, categoria.getCat_id());

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

    //Dar de baja categoria
    public boolean bajaCategoria(int id) {
        Connection con = conexionDB.getConectionDB();
        String sqlQuery = "UPDATE categorias SET cat_status = 0 WHERE cat_id  = ?";
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
    //Seleccion de la sentencia 
     public String eleccionSentencia(String eleccion){
        String sqlQuery = "";
        if ("id".equals(eleccion)) {
            sqlQuery = "SELECT * FROM categorias WHERE cat_status = 1 AND cat_id = ?";
        } else if ("nombre".equals(eleccion)) {
            sqlQuery = "SELECT * FROM categorias WHERE cat_status = 1 AND cat_nombre LIKE ?";
        }
        return sqlQuery;
    }
    
    //Get una categoria
    public List<Categorias> getCategoria(String busqueda, String sqlQuery) {
        Connection con = conexionDB.getConectionDB();
        List<Categorias> categoriasList = new ArrayList();
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, busqueda + "%");

                ResultSet resultSet = this.preStm.executeQuery();
                while (resultSet.next()) {
                    categoriasList.add(new Categorias(resultSet.getInt("cat_id"), resultSet.getString("cat_nombre"), resultSet.getInt("cat_status")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (this.preStm != null) {
                    this.preStm.close();
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex.getMessage());
            }
        }
        return categoriasList; 
    }

}
