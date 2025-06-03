//Se crea una clase reporte, esta representa los reportes de daño.
class Reporte{
    private int id;
    private String tipo;
    private String zona;
    private String descripcion;
    private String fecha;
    private int urgencia;
    private String estado;

    public Reporte(int id, String tipo, String zona, String descripcion, String fecha, int urgencia){
        this.id = id;
        this.tipo = tipo;
        this.zona = zona;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.urgencia = urgencia;
        this.estado = "pendiente🔄️";
    }

    public int obtenerId(){
        return id;
    }
    public String obtenerTipo(){
        return tipo;
    }
    public String obtenerZona(){
        return zona;
    }
    public String obtenerEstado(){
        return estado;
    }
    public int obtenerUrgencia(){
        return urgencia;
    }

    void marcarSolucionado(){
        estado = "Solucionado✅";
    }

    @Override
    public String toString(){
        return "▶ [ID: " + id + "] Tipo: " + tipo + " | Zona: " + zona + " | Urgencia: " + urgencia +
                " | Estado: " + estado + " | Fecha: " + fecha + "\nDescripcion: " + descripcion;
    }
}