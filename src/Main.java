import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String archivo = "D:/Nov4/test.txt";
        ArrayList<Integer> notas = new ArrayList<>();
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {
                // Verifica si la línea es un número con el metodo "esNumero"
                // Si es asi convierte la linea en entero
                if (esNumero(linea)) {
                    int nota = Integer.parseInt(linea);
                    notas.add(nota);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (notas.isEmpty()) {
            System.out.println("No se encontraron notas.");
            return;
        }

        float suma = 0;
        int mayor = notas.get(0);
        int menor = notas.get(0);

        for (int i = 0; i < notas.size(); i++) {
            int nota = notas.get(i);
            suma += nota;
            if (nota > mayor) {
                mayor = nota;
            }
            if (nota < menor) {
                menor = nota;
            }
        }

        float promedio = suma / notas.size();

        System.out.println("Promedio: " + promedio);
        System.out.println("Nota más alta: " + mayor);
        System.out.println("Nota más baja: " + menor);
    }

    // Método para verificar si es un número
    private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}