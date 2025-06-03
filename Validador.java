//Se crea clase para validaciones
class Validador{
    //Aqui retorna true solo si 'texto' no es null, no está vacío y no contiene solo espacios.
    public static boolean validarTexto(String texto){
        return texto != null && !texto.trim().isEmpty();
    }

    //Aqui se verifica que el valor de urgencia este entre 1 y 5.
    public static boolean validarUrgencia(int urgencia){
        return urgencia >= 1 && urgencia <= 5;
    }

    //Aqui se verifica si la zona dada es una de las zonas validas, ignorando las mayusculas y minusculas.
    public static boolean validarZona(String zona){
        String[] zonasValidas = {"Centro", "Norte", "Sur", "Este", "Oeste"};
        for (String z: zonasValidas){
            if (z.equalsIgnoreCase(zona.trim())){
                return true;
            }
        }
        return false;
    }
}