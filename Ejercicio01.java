package actividad04;

import java.io.*;

import actividad04.pideDatos.Pregunta;

/**
 *
 * @author Miguel de la Rubia
 */

public class Ejercicio01 {

    /**
     * comprueba si existe la carpeta y si no existe la crea
     *
     * @param rutaCarpeta
     */
    public static void checkCarpeta(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        } else {
            System.out.println("Existe la carpeta formacion");
        }

    }

    public static void main(String[] args) throws IOException {
        int opcion;
        String separador = File.separator; // String que utiliza el Sistema Operativo para separar carpetas al generar
                                           // su ruta
        String rutaProyecto = System.getProperty("user.dir"); // ruta hasta el proyecto donde se ejecuta nuestro
                                                              // programa
        String rutaCarpeta = rutaProyecto + separador + "archivos";

        File carpetaFormacion = new File(rutaCarpeta); // El objeto File nos permite tambien tener informacion sobre la
                                                       // carpeta
        if (!carpetaFormacion.exists()) { // comprobamos si la carpeta existe
            carpetaFormacion.mkdir(); // si la carpeta no existe, la creamos con mkdir();
        }

        do {
            System.out.println("\n------ Elige una opcion del menu ------");
            System.out.println("1. Nuevo Archivo");
            System.out.println("2. Listar Archivos ");
            System.out.println("3. Muestra un Archivo ");
            System.out.println("4. Borrar un Archivo");
            System.out.println("5. Renombrar un Archivo");
            System.out.println("6. Modificar un Archivo");
            System.out.println("7. Salir");

            opcion = Pregunta.pideValorMinMax(1, 7);

            switch (opcion) {
                case 1:
                    nuevoArchivo(rutaCarpeta);
                    break;
                case 2:
                    listarArchivos(rutaCarpeta, separador);
                    break;
                case 3:
                    muestraArchivo(rutaCarpeta, separador);
                    break;
                case 4:
                    borraArchivo(rutaCarpeta, separador);

                    break;
                case 5:
                    renombraArchivo(rutaCarpeta, separador);
                    break;
                case 6:
                    reemplazaCaracteres(rutaCarpeta, separador);

                    break;
                case 7:
                    System.out.println("Adios.");
            }

        } while (opcion != 7);

    }

    public static String[] listarArchivos(String rutaCarpeta, String sep) {
        File carpeta = new File(rutaCarpeta);

        String[] archivos = carpeta.list();
        checkCarpeta(rutaCarpeta);
        for (int k = 0; k < archivos.length; k++) {
            String nombreItem = archivos[k];
            File item = new File(rutaCarpeta + sep + nombreItem);
            if (item.isFile()) {
                System.out.println((k) + "- " + nombreItem);
            }
        }

        return (archivos);
    }

    /**
     *
     */
    private static void nuevoArchivo(String rutaCarpeta) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String separador = File.separator; // String que utiliza el Sistema Operativo para separar carpetas al generar
                                           // su ruta
        FileWriter fw;
        try {
            System.out.println("Introduce el nombre del archivo que quieres crear");
            String nombre = br.readLine();
            System.out.println("Introduce un texto:");
            String texto = br.readLine();

            fw = new FileWriter(rutaCarpeta + separador + nombre);// Creamos un Stream de escritura vinculado conel
                                                                  // archivo en el que queremos escribir.
            BufferedWriter bw = new BufferedWriter(fw); // Creamos un Buffer de escritura vinculado con el Stream. Esto
                                                        // nos permite escribir Strings en el buffer, y no bytes.
            bw.write(texto);
            bw.flush(); // obliga al buffer a escribir en el archivo todo aquello que contenga el
                        // buffer. (lo vacia)
            bw.close(); // vacia el buffer y libera el archivo cerrando la conexion con el

        } catch (IOException e1) {
            System.out.println("Se ha producido un error al intentar escribir en el archivo");
            System.out.println("El error producido es el siguiente:" + e1.getMessage());
        }

    }

    /**
     * debe de llamar a ListarArchivos para mostrar los archivos disponibles y
     * permitir al usuario elegir qué documento quiere ver según su número y mostrar
     * el contenido del documento por consola.
     */
    private static void muestraArchivo(String rutaCarpeta, String sep) {
        String archivos[] = listarArchivos(rutaCarpeta, sep);
        if (archivos.length > 0) {
            System.out.println("indica el numero de archivo que quieres ver:");
            int numArchivo = Pregunta.pideValorMinMax(0, archivos.length - 1);

            String rutaArchivo = archivos[numArchivo];
            try {
                FileReader fr = new FileReader(rutaCarpeta + sep + rutaArchivo);// Creamos un Stream de lectura
                                                                                // vinculado con el archivo que queremos
                                                                                // leer
                BufferedReader br = new BufferedReader(fr); // Buffer de lectura del stream creado

                String linea = "";
                linea = br.readLine(); // leemos la primera linea de texto
                while (linea != null) { // el bucle se ejecuta mientras la linea leida no sea null(en tal caso nos
                                        // indica que no quedan mas lineas para leer)
                    System.out.println(linea); // mostramos el texto leido
                    linea = br.readLine(); // leemos la siguiente linea de texto
                }
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("carpeta vacia");
        }
    }

    /**
     * debe llamar a una función que muestre los archivos dentro de la carpeta
     * “archivos” numerados y permitir al usuario elegir qué documento quiere borrar
     * según su número.
     *
     * @throws IOException
     */
    private static void borraArchivo(String rutaCarpeta, String sep) throws IOException {
        String archivos[] = listarArchivos(rutaCarpeta, sep);
        if (archivos.length > 0) {
            System.out.println("indica el numero de archivo que quieres borrar:");
            int numArchivo = Pregunta.pideValorMinMax(0, archivos.length - 1);

            String rutaArchivo = archivos[numArchivo];
            File archivo = new File(rutaCarpeta + sep + rutaArchivo);
            archivo.delete();
            System.out.println("Archivo '" + rutaArchivo + "' ha sido eliminado ");
        } else {
            System.out.println("carpeta vacia");
        }

    }

    /**
     * debe mostrar los archivos dentro de la carpeta “archivos” numerados y
     * permitir al usuario elegir qué documento quiere renombrar según su número. A
     * continuación le pregunte el nuevo nombre y lo renombre si es válido. Si es un
     * nombre inválido se debe mostrar un mensaje por consola al usuario y volver a
     * ejecutar el menú
     * 
     * @throws IOException
     */
    private static void renombraArchivo(String rutaCarpeta, String sep) throws IOException {
        String archivos[] = listarArchivos(rutaCarpeta, sep);
        if (archivos.length > 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("indica el numero de archivo que quieres modificar:");
            int numArchivo = Pregunta.pideValorMinMax(0, archivos.length - 1);
            String rutaArchivo = archivos[numArchivo];
            System.out.println("Introduce el nuevo nombre");
            String nombreNuevo = br.readLine();

            File archivo = new File(rutaCarpeta + sep + rutaArchivo);
            File archivoNuevo = new File(rutaCarpeta + sep + nombreNuevo);

            archivo.renameTo(archivoNuevo);
        } else {
            System.out.println("carpeta vacia");
        }

    }

    /**
     * debe de llamar a ListarArchivos para permitir al usuario elegir qué documento
     * se quiere modificar según su número y a continuación pida qué carácter se
     * quiere reemplazar y por qué nuevo carácter. Si el documento no existe o es
     * inválido, se debe mostrar un mensaje por consola al usuario y volver a
     * ejecutar el menú.
     */
    private static void reemplazaCaracteres(String rutaCarpeta, String sep) {
        String archivos[] = listarArchivos(rutaCarpeta, sep);
        if (archivos.length > 0) {
            System.out.println("indica el numero de archivo que quieres modificar:");
            int numArchivo = Pregunta.pideValorMinMax(0, archivos.length - 1);
            String rutaArchivo = archivos[numArchivo];
            File archivo = new File(rutaCarpeta + sep + rutaArchivo);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try {
              //  char char_find,char_replace;
                String text, txt_find, txt_replace;
                do{
                    System.out.println("Indica el caracter a reemplazar.Solo un caracter");
                    txt_find = br.readLine();
                } while(txt_find.length()!=1);
               // char_find=text.toCharArray()[0];

                do{
                    System.out.println("Indica el nuevo caracter.Solo un caracter");
                    txt_replace= br.readLine();
                } while(txt_replace.length()!=1);
               // char_replace=text.toCharArray()[0];
                
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");


                while (raf.getFilePointer() < raf.length()) {
                    Character chr = (char)raf.readByte();
                    if(chr.toString().compareTo(txt_find)==0){
                        raf.seek(raf.getFilePointer()-1);
                        raf.writeBytes(txt_replace);
                    }
                }
                raf.close();

            } catch (IOException e1) {
                System.out.println("Se ha producido un error al intentar escribir en el archivo:" + rutaArchivo);
                System.out.println("El error producido es el siguiente:" + e1.getMessage());
            }
        } else {
            System.out.println("carpeta vacia");
        }
    }

}
