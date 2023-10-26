# Files_java
Operaciones de gestión de ficheros y carpetas en java

- Crear y Realizar operaciones de lectura y escritura sobre ficheros.
- Realizar operaciones de gestión de ficheros y carpetas.
- Modularizar las operaciones sobre ficheros.

Ejercicio01

1.1Muestra por consola un menú con las siguientes opciones (y programa cada
opción en una función aparte) teniendo presente que si no existe una carpeta de nombre
“archivos” ubicada en la carpeta del proyecto, se cree de manera que quedará en la misma
carpeta que las carpetas src y bin.
Las opciones del menú son:
- Nuevo Archivo: debe llamar a una función que pida un nombre de archivo al usuario y cree
  un archivo con el nombre indicado dentro de la carpeta de nombre “archivos” ubicada en la
  carpeta del proyecto, y que rellene el archivo con un texto introducido por el usuario.
- Listar Archivos debe llamar a una función que muestre los nombres de archivos (sin carpetas)
  dentro de la carpeta “archivos” numerados: ej: 1-Archivo1.txt 2-Archivp2.txt .. y retorne un
  array con las rutas de los archivos.
- Muestra un Archivo debe de llamar a ListarArchivos para mostrar los archivos disponibles y
  permitir al usuario elegir qué documento quiere ver según su número y mostrar el contenido
  del documento por consola.
- Borrar un Archivo: debe llamar a una función que muestre los archivos dentro de la carpeta
  “archivos” numerados y permitir al usuario elegir qué documento quiere borrar según su
  número.
- Renombrar un Archivo: debe mostrar los archivos dentro de la carpeta “archivos” numerados
  y permitir al usuario elegir qué documento quiere renombrar según su número. A
  continuación, le pregunte el nuevo nombre y lo renombre si es válido. Si es un nombre
  inválido se debe mostrar un mensaje por consola al usuario y volver a ejecutar el menú.
- Reemplazar caracteres de un Archivo utilizando RandomAccessFile: debe de llamar a
  ListarArchivos para permitir al usuario elegir qué documento se quiere modificar según su
  número y a continuación pida qué carácter se quiere reemplazar y por qué nuevo carácter. Si
  el documento no existe o es inválido, se debe mostrar un mensaje por consola al usuario y
  volver a ejecutar el menú. Es obligatorio utilizar el RandomAccessFile para éste punto.
- Salir: debe terminar el programa. Si el usuario selecciona una opción no contemplada se
  tiene que volver a mostrar el menú.
      
    



