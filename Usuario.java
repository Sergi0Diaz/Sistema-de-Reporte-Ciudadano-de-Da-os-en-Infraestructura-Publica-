import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Se crea una clase usuario que es el que hace el reporte.
class Usuario {
    private String nombre;
    private String documento;
    private String zona;

    public Usuario(String nombre, String documento, String zona){
        this.nombre = nombre;
        this.documento = documento;
        this.zona = zona;
    }

    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerDocumento(){
        return documento;
    }
    public String obtenerZona(){
        return zona;
    }

    //Usamos @Override para decir que estamos remplazando el metodo toString() original.
    //Por eso el nombre debe ser exactamente "toString", si no, da error.
    @Override
    public String toString(){
        return "Usuario: " + nombre + ", Documento: " + documento + ", Zona: " + zona + "📝";
    }
}

