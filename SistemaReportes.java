import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class sistemaReportes{
    private ArrayList<Reporte> reportes; //Lista que guarda todos los reportes.
    private HashMap<Integer, Usuario> usuariosPorReporte; // Mapa que asocia el ID de un reporte con su usuario correspondiente.
    private int contadorId; //Contador para asignar Ids unicos a cada reporte nuevo.

    public sistemaReportes(){
        reportes = new ArrayList<>();
        usuariosPorReporte = new HashMap<>();
        contadorId = 1;
    }

    void agregarReporte(Usuario u, String tipo, String zona, String descripcion, String fecha, int urgencia){
        //Se crea un nuevo reporte con el ID actual y los datos recibidos.
        Reporte nuevo = new Reporte(contadorId, tipo, zona, descripcion, fecha, urgencia);
        reportes.add(nuevo); //Se agrega el nuevo reporte a la lista de reportes.
        usuariosPorReporte.put(contadorId, u); //Se asocia el reporte creado con el usuario que lo hizo.
        System.out.println("Reporte registrado con exito. ID: " + contadorId + "✅");
        contadorId++; //Se incrementa el contador para el proximo reporte que se cree.
    }

    void listaReportes(){
        if (reportes.isEmpty()){
            System.out.println("No hay reportes registrados❌");
            return;
        }
        for (Reporte r: reportes){ //Recorre cada reporte en la lista.
            System.out.println(r); //Con esto se muestra la informacion del reporte.
            Usuario u = usuariosPorReporte.get(r.obtenerId()); //Aqui busca el usuario que hizo ese reporte usando su ID.
            if (u != null){ //Si se encuentra un usuario, se muestra su nombre.
                System.out.println("• Hecho por: " + u.obtenerNombre());
                System.out.println("• Documento: " + u.obtenerDocumento());
            }
        }
    }

    void buscarZona(String zona){
        boolean encontrado = false; //Se crea esta variable para saber si se encontro al menos un reporte.
        for (Reporte r: reportes){
            if (r.obtenerZona().equalsIgnoreCase(zona.trim())){ //Aqui si la zona del reporte coincide, lo muestra.
                System.out.println(r);
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontraron reportes en esa zona📭");
        }
    }

    void cambiarEstado(int id){
        for (Reporte r: reportes){
            //Aqui si el ID coincide marca el reporte como solucionado, muestra el mensaje y termina el metodo.
            if (r.obtenerId() == id){
                r.marcarSolucionado();
                System.out.println("Reporte marcado como solucionado✅");
                return;
            }
        }
        System.out.println("No se encontro un reporte con ese ID❌");
    }

    void mostrarEstadisticas(){
        if (reportes.isEmpty()){
            System.out.println("No hay datos para mostrar estadisticas❌");
            return;
        }
        //Aqui se crea un HashMap para guardar cada tipo de reporte y cuantas veces aparece.
        HashMap<String, Integer> conteoPorTipo = new HashMap<>();
        for (Reporte r: reportes){
            //Aqui obtiene el tipo de reporte.
            String tipo = r.obtenerTipo();
            //Se verifica si ese tipo ya esta en el mapa
            if (!conteoPorTipo.containsKey(tipo)) {
                conteoPorTipo.put(tipo, 1); //Si no esta, lo agrega al mapa con valor 1
            }else {
                //Si ya esta en el map, aumenta el valor actual en 1.
                //get(tipo) obtiene el numero actual de reportes de ese tipo
                conteoPorTipo.put(tipo, conteoPorTipo.get(tipo) + 1);
            }
        }
        System.out.println("\nEstadisticas de reportes por tipo: ");
        //Se recorre todas las entradas del HashMap (clave: tipo, valor: cantidad).
        //Map.Entry representa cada elemento del mapa.
        for (Map.Entry<String, Integer> entry: conteoPorTipo.entrySet()) {
            //entry.getKey() obtiene el tipo.
            //entry.getValue() obtiene la cantidad de reportes
            System.out.println("• " + entry.getKey() + ": " + entry.getValue() + " reportes🗂️");
        }
    }
}