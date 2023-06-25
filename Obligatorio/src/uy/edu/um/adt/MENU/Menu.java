package uy.edu.um.adt.MENU;
import java.io.IOException;
import java.util.Scanner;

import uy.edu.um.adt.ENTITIES.Fecha;
import uy.edu.um.adt.FUNCIONES.FuncionesImpl;
import uy.edu.um.adt.CSV.IngresoDeDatos;
import uy.edu.um.adt.TADS.MyHash.MyHash;

import static uy.edu.um.adt.CSV.IngresoDeDatos.*;


public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String eleccion;
        IngresoDeDatos obligatorio = new IngresoDeDatos();

        while (true) {
            mostrarMenu();
            eleccion = obtenerEleccion(scanner);

            switch (eleccion) {
                case "0":
                    System.out.println("Ha seleccionado la opción 0.");
                    IngresarDatos("../obligatorio2023csv/f1_dataset.csv");
                    System.out.println("Se cargaron los datos correctamente.");
                    System.out.println("Cantidad de Hashtags: " + getCantHashtags());
                    System.out.println("Cantidad de Tweets: "+ getCantTweets());
                    System.out.println("Cantidad de Usuarios: "+ getCantUsuarios());
                    System.out.println("Cantidad de Piolotos: "+ getPilotos().size());
                    getTweets();
                    break;

                case "1":
                    System.out.println("Ha seleccionado la opción 1.");
                    System.out.println("Ingrese el mes  de la temporada :");
                    String mes =  scanner.nextLine();
                    System.out.println("Ingrese el dia de la temporada :");
                    String dia =  scanner.nextLine();
                    Integer diaInt = Integer.parseInt(dia);
                    Integer mesInt = Integer.parseInt(mes);
                    break;



                case "2":
                    System.out.println("Ha seleccionado la opción 2.");
                    FuncionesImpl funciones = new FuncionesImpl();
                    funciones.usuariosMasTwits(getTweets(), getUsuarios(), getListaClaves());
                    System.out.println("Se cargaron los datos correctamente.");
                    break;

                case "3":
                    System.out.println("Ha seleccionado la opción 3.");
                    break;

                case "4":
                    System.out.println("Ha seleccionado la opción 4.");
                    System.out.println("Ingrese el dia que quieres consultar(YYYY-MM-DD) :");
                    dia =  scanner.nextLine();
                    String[] fechaComponentsTweet = dia.split("-");
                    Long anioTweet = Long.parseLong(fechaComponentsTweet[0]);
                    Long mesTweet = Long.parseLong(fechaComponentsTweet[1]);
                    Long diaTweet = Long.parseLong(fechaComponentsTweet[2]);
                    Fecha fechaTweet = new Fecha(anioTweet, mesTweet, diaTweet);
                    break;

                case "5":
                    System.out.println("Ha seleccionado la opción 5.");
                    break;

                case "6":
                    System.out.println("Ha seleccionado la opción 6.");
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

