package co.edu.uniempresarial;

import co.edu.uniempresarial.entity.Categorias;
import co.edu.uniempresarial.entity.Productos;
import co.edu.uniempresarial.repository.CategoriasRepository;
import co.edu.uniempresarial.repository.ProductosRepository;
import co.edu.uniempresarial.util.ConexionDB;
import java.util.List;

public class ProyectoUE {

    public static void main(String[] args) {
        ConexionDB conDB = new ConexionDB();
        conDB.getConectionDB();
        CategoriasRepository catRepository = new CategoriasRepository();
        Categorias categoria = new Categorias(1, "Electro");
        catRepository.actualizarCategoria(categoria);
         
    }
}
