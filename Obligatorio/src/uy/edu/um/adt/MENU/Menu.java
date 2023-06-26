package uy.edu.um.adt.MENU;
import java.io.IOException;
import java.util.Scanner;
import uy.edu.um.adt.FUNCIONES.obligatorioImpl;





public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String eleccion;
        obligatorioImpl obligatorio = new obligatorioImpl();
        while (true) {
            mostrarMenu();
            eleccion = obtenerEleccion(scanner);

            switch (eleccion) {
                case "0": //9 seg aprox.
                    long startTime = System.currentTimeMillis();
                    System.out.println("Ha seleccionado la opción 0.");
                    System.out.println("Cargando datos...");
                    obligatorio.cargarTweets("../obligatorio2023csv/f1_dataset.csv");
                    System.out.println("Cantidad de Hashtags: " + obligatorio.getHashtagsHash().size());
                    System.out.println("Cantidad de Tweets: "+ obligatorio.getTweetsHash().size());
                    System.out.println("Cantidad de Usuarios: "+ obligatorio.getUsuarios().size());
                    System.out.println("Cantidad de Piolotos: "+ obligatorio.getPilotos().size());
                    System.out.println("Se cargaron los datos correctamente.");
                    long endTime = System.currentTimeMillis();
                    long executionTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución: " + executionTime + " milisegundos");
                    break;

                case "1":
                    System.out.println("Ha seleccionado la opción 1.");
                    System.out.println("Ingrese el mes  de la temporada :");
                    int mes =  Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el anio de la temporada :");
                    int anio =  Integer.parseInt(scanner.nextLine());
                    long startTime1 = System.currentTimeMillis();
                    if(anio == 2021 && mes <= 12 && mes > 6){
                        obligatorio.PilotosMasMencionados(anio,mes);
                        long endTime1 = System.currentTimeMillis();
                        long executionTime1 = endTime1 - startTime1;
                        System.out.println("Tiempo de ejecución: " + executionTime1 + " milisegundos");
                        break;
                    } else if (anio == 2022 && mes >= 1 && mes < 7) {
                        obligatorio.PilotosMasMencionados(anio,mes);
                        long endTime1 = System.currentTimeMillis();
                        long executionTime1 = endTime1 - startTime1;
                        System.out.println("Tiempo de ejecución: " + executionTime1 + " milisegundos");
                        break;
                    }
                    System.out.println("Ingrese un mes y anio validos");
                        break;



                case "2":
                    long startTime2 = System.currentTimeMillis();
                    System.out.println("Ha seleccionado la opción 2.");
                    obligatorio.usuariosMasTwits();
                    System.out.println("Se cargaron los datos correctamente.");
                    long endTime2 = System.currentTimeMillis();
                    long executionTime2 = endTime2 - startTime2;
                    System.out.println("Tiempo de ejecución: " + executionTime2 + " milisegundos");
                    break;

                case "3":
                    System.out.println("Ha seleccionado la opción 3.");
                    System.out.println("Ingrese el dia que quieres consultar(YYYY-MM-DD) :");
                    String dia =  scanner.nextLine();
                    String[] fechaComponentsTweet = dia.split("-");
                    int anioTweet = Integer.parseInt(fechaComponentsTweet[0]);
                    int mesTweet = Integer.parseInt(fechaComponentsTweet[1]);
                    int diaTweet = Integer.parseInt(fechaComponentsTweet[2]);
                    long startTime3 = System.currentTimeMillis();
                    obligatorio.cantHashtagsDistintos(diaTweet,mesTweet,anioTweet);
                    long endTime3 = System.currentTimeMillis();
                    long executionTime3 = endTime3 - startTime3;
                    System.out.println("Tiempo de ejecución: " + executionTime3 + " milisegundos");
                    break;

                case "4":
                    System.out.println("Ha seleccionado la opción 4.");
                    System.out.println("Ingrese el dia que quieres consultar(YYYY-MM-DD) :");
                    String dia1 =  scanner.nextLine();
                    String[] fechaComponentsTweet1 = dia1.split("-");
                    int anioTweet1 = Integer.parseInt(fechaComponentsTweet1[0]);
                    int mesTweet1 = Integer.parseInt(fechaComponentsTweet1[1]);
                    int diaTweet1 = Integer.parseInt(fechaComponentsTweet1[2]);
                    long startTime4 = System.currentTimeMillis();
                    obligatorio.hashtagMasUsado(diaTweet1,mesTweet1,anioTweet1);
                    long endTime4 = System.currentTimeMillis();
                    long executionTime4 = endTime4 - startTime4;
                    System.out.println("Tiempo de ejecución: " + executionTime4 + " milisegundos");
                    break;

                case "5":
                    System.out.println("Ha seleccionado la opción 5.");
                    long startTime5 = System.currentTimeMillis();
                    obligatorio.setFavoritos();//Lugo de la primera vez que se ejecuta ya es trivialhacer esta funcion, pero no estoy seguro de si se puede pone en el cargar datos.
                    obligatorio.topCuentasMasFavoritos();
                    long endTime5 = System.currentTimeMillis();
                    long executionTime5 = endTime5 - startTime5;
                    System.out.println("Tiempo de ejecución: " + executionTime5 + " milisegundos");
                    break;

                case "6":
                    System.out.println("Ha seleccionado la opción 6.");
                    System.out.println("Ingrese la palabra o frase que quieres consultar :");
                    String palabraFrase =  scanner.nextLine();
                    long startTime6 = System.currentTimeMillis();
                    obligatorio.cantidadDeTweetsPalabraFrase(palabraFrase);
                    long endTime6 = System.currentTimeMillis();
                    long executionTime6 = endTime6 - startTime6;
                    System.out.println("Tiempo de ejecución: " + executionTime6 + " milisegundos");
                    break;
                case "7":
                    System.out.println("Saliendo del menú...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("Bienvenido al menú:");
        System.out.println("1. Listar los 10 pilotos activos en la temporada 2023 más mencionados en Twitter.");
        System.out.println("2. Top 15 usuarios con más tweets.");
        System.out.println("3. Cantidad de hashtags distintos para un día dado.");
        System.out.println("4. Hashtag más usado para un día dado.");
        System.out.println("5. Top 7 cuentas con más favoritos.");
        System.out.println("6. Cantidad de tweets con una palabra o frase específicos.");
        System.out.println("7.Salir.");
    }

    public static String obtenerEleccion(Scanner scanner) {
        System.out.print("Ingrese su elección:  ");
        return scanner.nextLine();
    }
}

