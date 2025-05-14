import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        int seleccionMonedaBase;
        String base = "";
        int seleccionMonedaObjetivo;
        String objetivo = "";
        double cantidad = 0;
        double cantidadConvertida = 0;
        ArrayList<String> conversionesUsadas = new ArrayList<>();

        ConsultaApi consultaApi = new ConsultaApi();
        Scanner sc = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        System.out.println("\n * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\n               ¡BIENVENIDO!");

        while (true) {
            System.out.println("\n     ¿Qué moneda quieres convertir?:\n");
            for (Moneda m : Moneda.listaMonedas) {
                System.out.printf("%-18s %-25s\n", m.pais, m.nombre + " (" + m.codigo + ")");
            }

            while (true) {
                System.out.print("\nIngresa el número de tu selección: ");
                if (sc.hasNextInt()) {
                    seleccionMonedaBase = sc.nextInt();

                    if(seleccionMonedaBase >= 1 && seleccionMonedaBase <= 15) {
                        base = Moneda.listaMonedas.get(seleccionMonedaBase - 1).codigo;
                        System.out.println("\nMuy bien, seleccionaste" + Moneda.listaMonedas.get(seleccionMonedaBase - 1).nombre + ",");
                        break;
                    } else {
                        System.out.println("Por favor selecciona una opción válida (del 1 al 15)");
                    }
                } else {
                    System.out.println("Por favor selecciona una opción válida, sólo se admiten números");
                    sc.next();
                }
            }

            while (true) {
                System.out.println("¿a qué moneda la quieres convertir?");
                System.out.print("Ingresa el número: ");
                if (sc.hasNextInt()) {
                    seleccionMonedaObjetivo = sc.nextInt();

                    if(seleccionMonedaObjetivo >= 1 && seleccionMonedaObjetivo <= 15) {
                        objetivo = Moneda.listaMonedas.get(seleccionMonedaObjetivo - 1).codigo;
                        System.out.println("\nPerfecto, entonces haremos la conversión de" + Moneda.listaMonedas.get(seleccionMonedaBase - 1).nombre +
                                " a" + Moneda.listaMonedas.get(seleccionMonedaObjetivo - 1).nombre + ".");
                        break;
                    } else {
                        System.out.println("Por favor selecciona una opción válida (del 1 al 15)");
                    }
                } else {
                    System.out.println("Por favor selecciona una opción válida, sólo se admiten números");
                    sc.next();
                }
            }

            while (true) {
                System.out.print("Ingresa la cantidad que quieres convertir: ");
                if (sc.hasNextDouble()) {
                    cantidad = sc.nextDouble();

                    if (cantidad > 0) {
                        consultaApi.consulta(base, objetivo);
                        cantidadConvertida = cantidad * consultaApi.cambio;
                        String cantidadEnTexto = String.format("%.2f", cantidad);
                        String cantidadConvertidaEnTexto = String.format("%.2f", cantidadConvertida);

                        System.out.printf(
                                "\nEl tipo de cambio es: " + consultaApi.cambio + "\n" + cantidadEnTexto +
                                        ((cantidad == 1) ? Moneda.listaMonedas.get(seleccionMonedaBase - 1).nombre :
                                                Moneda.listaMonedas.get(seleccionMonedaBase - 1).nombres) +
                                        ((cantidad == 1) ? " equivale a " : " equivalen a ") + cantidadConvertidaEnTexto +
                                        ((cantidadConvertidaEnTexto.equals("1.00")) ? Moneda.listaMonedas.get(seleccionMonedaObjetivo - 1).nombre :
                                                Moneda.listaMonedas.get(seleccionMonedaObjetivo - 1).nombres) + ".\n"
                        );

                        conversionesUsadas.add(
                                "\n" + cantidadEnTexto +
                                        ((cantidad == 1) ? Moneda.listaMonedas.get(seleccionMonedaBase - 1).nombre :
                                                Moneda.listaMonedas.get(seleccionMonedaBase - 1).nombres) +
                                        ((cantidad == 1) ? " equivale a " : " equivalen a ") + cantidadConvertidaEnTexto +
                                        ((cantidadConvertidaEnTexto.equals("1.00")) ? Moneda.listaMonedas.get(seleccionMonedaObjetivo - 1).nombre :
                                                Moneda.listaMonedas.get(seleccionMonedaObjetivo - 1).nombres) + ".\n"
                        );
                        break;
                    } else {
                        System.out.println("Por favor ingresa una cantidad mayor que 0");
                    }
                }else {
                    System.out.println("Por favor ingresa sólo números");
                    sc.next();
                }
            }

            System.out.println("\nQuieres convertir otra moneda? 1: Sí. Cualquier otra tecla: Salir. ");
            String seguir = sc.next();

            if (!seguir.equals("1")) {
                System.out.println("\n\nÉSTAS SON LAS CONVERSIONES QUE UTILIZASTE EN ÉSTA SESIÓN:");
                for(String s : conversionesUsadas) {
                    System.out.print(s);
                }
                System.out.println("\n\nGRACIAS POR USAR NUESTRA APLICACIÓN.");

                break;
            } else {
                System.out.println("               Muy bien.");
            }
        }
    }
}
