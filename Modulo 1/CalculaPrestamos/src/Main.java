import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double importe, tipo, limite;
        int periodo;

        System.out.println("Introduce el importe del préstamo: ");
        //System.out.print("Introduce el importe del préstamo: ");
        importe = scanner.nextDouble();

        System.out.println("Introduce el tipo de interés: ");
        tipo = scanner.nextDouble();

        System.out.println("Introduce el tiempo de amortización (años): ");
        periodo = scanner.nextInt();

        System.out.println("Introduce el límite que puedes pagar: ");
        limite = scanner.nextDouble();

        periodo *= 12;
        //periodo = periodo * 12;
        tipo = tipo / 1200;

        double numerador = tipo * Math.pow(1 + tipo, periodo);
        double denominador = Math.pow(1 + tipo, periodo) - 1;
        double cuota = importe * (numerador / denominador);

        System.out.println("La cuota mensual será de " + cuota +
                 "\nLa cuota será tu límite ? -> " + (cuota > limite));
    }
}