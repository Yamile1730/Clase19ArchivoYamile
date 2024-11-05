import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String archivo = "D:/Clase19ArchivoYamile/test.txt";
        ArrayList<Integer> numeros = new ArrayList<>();
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {

                if (esNumero(linea)) {
                    int numero = Integer.parseInt(linea);
                    numeros.add(numero);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (numeros.isEmpty()) {
            System.out.println("No se encontraron numeros.");
            return;
        }

        float suma = 0;
        int mayor = numeros.get(0);
        int menor = numeros.get(0);

        for (int i = 0; i < numeros.size(); i++) {
            int numero = numeros.get(i);
            suma += numero;
            if (numero > mayor) {
                mayor = numero;
            }
            if (numero < menor) {
                menor = numero;
            }
        }

        float promedio = suma / numeros.size();

        System.out.println("Promedio: " + promedio);
        System.out.println("Numero más alto: " + mayor);
        System.out.println("Numero más baja: " + menor);
    }

    private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}