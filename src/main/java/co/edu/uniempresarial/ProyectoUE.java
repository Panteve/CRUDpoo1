package co.edu.uniempresarial;

import co.edu.uniempresarial.entity.Productos;
import co.edu.uniempresarial.repository.ProductosRepository;
import co.edu.uniempresarial.util.ConexionDB;
import java.util.List;

public class ProyectoUE {

    public static void main(String[] args) {
        ConexionDB conDB = new ConexionDB();
        conDB.getConectionDB();
        ProductosRepository repository = new ProductosRepository();
        //Productos producto = new Productos("NK593","Nike dunk",9,250000);
        //Instanciar tipo repository para insertar en la BD
        /*
        
        boolean confirmacion = repository.registrarProdcuto(producto);
        System.out.println(confirmacion);
         */
 /*
        Traer todos los datos
        List<Productos> data = repository.getAllProductos();
        //Iterar la lista
        for(int i  = 0; i < data.size(); i++){
            Productos producto = data.get(i);
            System.out.println(producto);
        }
        System.out.println(data);
         */
 //Traer solo un dato
        String sentencia = repository.eleccionSentencia("referencia");
        List<Productos> data = repository.getProducto("nk", sentencia);
        for(int i  = 0; i < data.size(); i++){
            Productos producto = data.get(i);
            System.out.println(producto);
        }
         
    }
}
