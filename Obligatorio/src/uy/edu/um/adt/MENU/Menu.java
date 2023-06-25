package uy.edu.um.adt.MENU;
import java.io.IOException;
import java.util.Scanner;

import uy.edu.um.adt.FUNCIONES.FuncionesImpl;


public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String eleccion;
        FuncionesImpl funciones = new FuncionesImpl();
        while (true) {
            mostrarMenu();
            eleccion = obtenerEleccion(scanner);

            switch (eleccion) {
                case "0": //20 seg aprox.
                    System.out.println("Ha seleccionado la opción 0.");
                    funciones.CargarDatos("C:\\Users\\Evo-i7\\OneDrive\\Escritorio\\f1_dataset_test.csv");
                    System.out.println("Se cargaron los datos correctamente.");

                    break;

                case "1":
                    System.out.println("Ha seleccionado la opción 1.");
                    System.out.println("Ingrese el mes  de la temporada :");
                    int mes =  Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el anio de la temporada :");
                    int anio =  Integer.parseInt(scanner.nextLine());
                    if(anio>2023 || anio<2021 || mes>12 || mes<1){
                        System.out.println("Ingrese un mes y anio validos");
                        break;
                    }
                    funciones.pilotosMasMencionados(anio,mes);



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

