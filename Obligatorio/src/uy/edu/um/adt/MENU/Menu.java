package uy.edu.um.adt.MENU;
import java.io.IOException;
import java.util.Scanner;

import uy.edu.um.adt.CSV.CSVreader;
import uy.edu.um.adt.ENTITIES.Fecha;
import uy.edu.um.adt.FUNCIONES.obligatorio;
import uy.edu.um.adt.FUNCIONES.obligatorioImpl;
import uy.edu.um.adt.TADS.MyHash.MyHash;




public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String eleccion;
        obligatorioImpl obligatorio = new obligatorioImpl();
        while (true) {
            mostrarMenu();
            eleccion = obtenerEleccion(scanner);

            switch (eleccion) {
                case "0": //20 seg aprox.
                    System.out.println("Ha seleccionado la opción 0.");
                    System.out.println("Cargando datos...");
                    obligatorio.cargarTweets("../obligatorio2023csv/f1_dataset.csv");
                    System.out.println("Cantidad de Hashtags: " + obligatorio.getHashtagsHash().size());
                    System.out.println("Cantidad de Tweets: "+ obligatorio.getTweetsHash().size());
                    System.out.println("Cantidad de Usuarios: "+ obligatorio.getUsuarios().size());
                    System.out.println("Cantidad de Piolotos: "+ obligatorio.getPilotos().size());
                    System.out.println("Se cargaron los datos correctamente.");

                    break;

                case "1":
                    System.out.println("Ha seleccionado la opción 1.");
                    System.out.println("Ingrese el mes  de la temporada :");
                    int mes =  Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el anio de la temporada :");
                    int anio =  Integer.parseInt(scanner.nextLine());
                    if(anio == 2021 && mes <= 12 && mes > 6){
                        obligatorio.PilotosMasMencionados(anio,mes);
                        break;
                    } else if (anio == 2022 && mes >= 1 && mes < 7) {
                        obligatorio.PilotosMasMencionados(anio,mes);
                        break;
                    }
                    System.out.println("Ingrese un mes y anio validos");
                        break;



                case "2":
                    System.out.println("Ha seleccionado la opción 2.");
                    obligatorio.usuariosMasTwits();
                    System.out.println("Se cargaron los datos correctamente.");

                    break;

                case "3":
                    System.out.println("Ha seleccionado la opción 3.");
                    System.out.println("Ingrese el dia que quieres consultar(YYYY-MM-DD) :");
                    String dia =  scanner.nextLine();
                    String[] fechaComponentsTweet = dia.split("-");
                    int anioTweet = Integer.parseInt(fechaComponentsTweet[0]);
                    int mesTweet = Integer.parseInt(fechaComponentsTweet[1]);
                    int diaTweet = Integer.parseInt(fechaComponentsTweet[2]);
                    obligatorio.cantHashtagsDistintos(diaTweet,mesTweet,anioTweet);
                    break;

                case "4":
                    System.out.println("Ha seleccionado la opción 4.");
                    System.out.println("Ingrese el dia que quieres consultar(YYYY-MM-DD) :");
                    String dia1 =  scanner.nextLine();
                    String[] fechaComponentsTweet1 = dia1.split("-");
                    int anioTweet1 = Integer.parseInt(fechaComponentsTweet1[0]);
                    int mesTweet1 = Integer.parseInt(fechaComponentsTweet1[1]);
                    int diaTweet1 = Integer.parseInt(fechaComponentsTweet1[2]);
                    obligatorio.hashtagMasUsado(diaTweet1,mesTweet1,anioTweet1);
                    break;

                case "5":
                    System.out.println("Ha seleccionado la opción 5.");
                    obligatorio.topCuentasMasFavoritos();
                    break;

                case "6":
                    System.out.println("Ha seleccionado la opción 6.");
                    System.out.println("Ingrese la palabra o frase que quieres consultar :");
                    String palabraFrase =  scanner.nextLine();
                    obligatorio.cantidadDeTweetsPalabraFrase(palabraFrase);

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

