/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniempresarial.entity;

/**
 *
 * @author DIEGO
 */
public class Categorias {
    private int cat_id;
    private String cat_nombre;
    private int cat_status;

    public Categorias(int cat_id, String cat_nombre, int cat_status) {
        this.cat_id = cat_id;
        this.cat_nombre = cat_nombre;
        this.cat_status = cat_status;
    }

    public Categorias(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }

    public int getCat_status() {
        return cat_status;
    }

    public void setCat_status(int cat_status) {
        this.cat_status = cat_status;
    }

    @Override
    public String toString() {
        return "Categorias{" + "cat_id=" + cat_id + ", cat_nombre=" + cat_nombre + ", cat_status=" + cat_status + '}';
    }
    
}
