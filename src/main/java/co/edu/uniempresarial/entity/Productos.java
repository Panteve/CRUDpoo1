
package co.edu.uniempresarial.entity;

import java.util.logging.Logger;

public class Productos {
    //Atributos
    private int pro_id ;
    private String pro_referencia ;
    private String pro_nombre;
    private int pro_stock;
    private int pro_precio;
    private int cat_id;
    private int pro_status;
     //Constructores 

    public Productos(int pro_id, String pro_referencia, String pro_nombre, int pro_stock, int pro_precio,int cat_id ,int pro_status) {
        this.pro_id = pro_id;
        this.pro_referencia = pro_referencia;
        this.pro_nombre = pro_nombre;
        this.pro_stock = pro_stock;
        this.pro_precio = pro_precio;
        this.cat_id = cat_id;
        this.pro_status = pro_status;
    }

    public Productos(String pro_referencia, String pro_nombre, int pro_stock, int pro_precio, int cat_id) {
        this.pro_referencia = pro_referencia;
        this.pro_nombre = pro_nombre;
        this.pro_stock = pro_stock;
        this.pro_precio = pro_precio;
         this.cat_id = cat_id;
    }

    public Productos() {
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }
    

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_referencia() {
        return pro_referencia;
    }

    public void setPro_referencia(String pro_referencia) {
        this.pro_referencia = pro_referencia;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public int getPro_stock() {
        return pro_stock;
    }

    public void setPro_stock(int pro_stock) {
        this.pro_stock = pro_stock;
    }

    public int getPro_precio() {
        return pro_precio;
    }

    public void setPro_precio(int pro_precio) {
        this.pro_precio = pro_precio;
    }

    public int getPro_status() {
        return pro_status;
    }

    public void setPro_status(int pro_status) {
        this.pro_status = pro_status;
    }

    @Override
    public String toString() {
        return "Productos{" + "pro_id=" + pro_id + ", pro_referencia=" + pro_referencia + ", pro_nombre=" + pro_nombre + ", pro_stock=" + pro_stock + ", pro_precio=" + pro_precio + ", cat_id=" + cat_id + ", pro_status=" + pro_status + '}';
    }

    
}
