# grupo13-p2-Obligatorio
Obligatorio de programacion 2 por Joaquin Heredero y Tomas Gonzalez
# Menú
Este programa implementa un menú interactivo que permite realizar varias operaciones relacionadas con el análisis de datos de tweets. A continuación se muestra cómo utilizar el programa y las opciones disponibles en el menú.

# Uso
El programa se ejecuta desde la clase Menu en el paquete principal. Al iniciarse, mostrará un menú de opciones numeradas en la consola. El usuario debe ingresar el número correspondiente a la opción deseada y presionar Enter para seleccionarla. Dependiendo de la opción elegida, se solicitarán entradas adicionales al usuario para completar la operación.

El programa lee datos de un archivo CSV que contiene información sobre tweets y pilotos. Para cargar los datos, el programa requiere que se proporcione la ruta del archivo CSV. Asegúrate de proporcionar la ruta correcta al archivo en la línea de código:
# obligatorio.cargarTweets("AQUI");
En la linea 27 del archivo Menu.java ubicado en Obligatorio\src\uy\edu\um\adt\MENU


## A continuación se describen las opciones disponibles en el menú:

1. Listar los 10 pilotos activos en la temporada 2023 más mencionados en Twitter.

	.Esta opción muestra los 10 pilotos activos en la temporada 2023 que son mencionados con mayor frecuencia en Twitter.

2.Top 15 usuarios con más tweets.

	.Esta opción muestra los 15 usuarios que tienen más tweets registrados en la base de datos.

3.Cantidad de hashtags distintos para un día dado.

	.Esta opción solicita al usuario que ingrese una fecha en el formato YYYY-MM-DD y muestra la cantidad de hashtags distintos utilizados en los tweets de ese día.

4.Hashtag más usado para un día dado.

	.Esta opción solicita al usuario que ingrese una fecha en el formato YYYY-MM-DD y muestra el hashtag más utilizado en los tweets de ese día.

5.Top 7 cuentas con más favoritos.

	.Esta opción muestra las 7 cuentas de usuario que tienen más favoritos registrados en los tweets.

6.Cantidad de tweets con una palabra o frase específicos.

	.Esta opción solicita al usuario que ingrese una palabra o frase y muestra la cantidad de tweets que contienen esa palabra o frase.

7.Salir.

	.Esta opción permite salir del programa.
 
Ten en cuenta que algunos datos, como la ruta del archivo CSV y los detalles de implementación específicos, pueden requerir modificaciones para que el programa se ejecute correctamente en tu entorno.
