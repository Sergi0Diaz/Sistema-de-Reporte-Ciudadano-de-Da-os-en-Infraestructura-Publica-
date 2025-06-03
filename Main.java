import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        sistemaReportes sistema = new sistemaReportes();

        int opcion = 0;
        do{
            System.out.println("\n⚠️Sistema de Reporte de Daños En La Infraestructura Publica⚠️");
            System.out.println("1. Registrar nuevo reporte🚧");
            System.out.println("2. Listar todos los reportes🗂️");
            System.out.println("3. Buscar reportes por zona🗺️");
            System.out.println("4. Marcar reporte como solucionado🏗️");
            System.out.println("5. Ver estadisticas📊");
            System.out.println("6. Salir del sistema👋🏼");
            System.out.print("📋Elige una opcion: ");

            try { //El try intenta ejecutar codigo que puede fallar.
                opcion = Integer.parseInt(obj.nextLine());
                switch (opcion){
                    case 1:
                        System.out.print("👱🏼‍♂️Nombre del ciudadano: ");
                        String nombre = obj.nextLine();
                        System.out.print("🪪Documento: ");
                        String documento = obj.nextLine();
                        System.out.print("🗺️Zona(Centro, Norte, Sur, Este, Oeste): ");
                        String zona = obj.nextLine().trim();
                        if (!Validador.validarZona(zona)){ //Valida si la zona ingresada es valida.
                            System.out.println("Zona invalida❌");
                            break;
                        }
                        System.out.print("⚠️Tipo de daño(bache, poste, semaforo...): ");
                        String tipo = obj.nextLine().trim().toLowerCase();
                        System.out.print("📝Descripcion del daño: ");
                        String descripcion = obj.nextLine();
                        System.out.print("📆Fecha de reporte (dd/mm/aaaa): ");
                        String fecha = obj.nextLine();
                        System.out.print("🆘Nivel de urgencia (1-5): ");
                        int urgencia = Integer.parseInt(obj.nextLine()); //Se coloca asi apra evitar saltos de linea.

                        if (!Validador.validarUrgencia(urgencia)){
                            System.out.println("Urgencia fuera de rango❌");
                            break;
                        }

                        Usuario usuario = new Usuario(nombre, documento, zona);
                        sistema.agregarReporte(usuario, tipo, zona, descripcion, fecha, urgencia);
                        break;

                    case 2:
                        sistema.listaReportes();
                        break;

                    case 3:
                        System.out.print("🗺️Ingresa la zona a buscar: ");
                        String zonaBuscar = obj.nextLine();
                        sistema.buscarZona(zonaBuscar);
                        break;

                    case 4:
                        System.out.print("🔢ID del reporte a marcar como solucionado: ");
                        int id = Integer.parseInt(obj.nextLine());
                        sistema.cambiarEstado(id);
                        break;

                    case 5:
                        sistema.mostrarEstadisticas();
                        break;

                    case 6:
                        System.out.println("👋🏼Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion no valida❌");
                }
            }catch (Exception e){
                System.out.println("Error: entrada no valida. Intentalo de nuevo❌");
            }
        }while (opcion != 6);

        obj.close();
    }
}