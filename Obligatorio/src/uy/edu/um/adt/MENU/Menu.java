package uy.edu.um.adt.MENU;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String eleccion;

        while (true) {
            mostrarMenu();
            eleccion = obtenerEleccion(scanner);

            switch (eleccion) {
                case "1":
                    System.out.println("Ha seleccionado la opción 1.");

                    break;

                case "2":
                    System.out.println("Ha seleccionado la opción 2.");
                    break;

                case "3":
                    System.out.println("Ha seleccionado la opción 3.");
                    break;

                case "4":
                    System.out.println("Ha seleccionado la opción 4.");
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

