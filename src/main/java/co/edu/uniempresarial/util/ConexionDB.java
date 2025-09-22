
package co.edu.uniempresarial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionDB {
    private String user;
    private String password;
    private String dataBase;
    private String port;
    private String url;
    private String serverData;
    Connection con;

    //Constructor 
    public ConexionDB(){
        this.user = "root";
        this.password = "";
        this.dataBase = "tienda";
        this.port = "3306";
        this.serverData = "localhost";
        this.url = "jdbc:mysql://"+this.serverData+":"+this.port+"/"+this.dataBase;
        this.con = null;
    }
    //Metodo de conexion a la DB
    private Connection connecting(){
    //Usi de control excepxion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conectado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay conexion:"+ e.getMessage());
            System.out.println("***********Error"+ e);
            this.con = null;
        }
    return this.con;
    }
    public Connection getConectionDB(){
        return this.connecting();
    }
}
