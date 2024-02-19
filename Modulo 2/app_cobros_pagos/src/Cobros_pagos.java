import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Cobros_pagos {
    //opciones que ofrece el programa
    enum option {cobro, pago, movimientos, salir};
    //tipos de movimientos en la cuenta
    enum tipo_movimiento {cargo, abono};

    //Estructura de datos que nos permita guardar toda la información anterios. Datos de un movimiento
    //final porque no será una clase que vayamos a utilizar como base de otra.
    final class Movimiento {
        Date fecha_registro;
        tipo_movimiento tipo;
        String concepto;
        BigDecimal importe;

        //este metodo nos ayuda a visualizar los datos del movimiento por consola. Genera una cadena de carácteres.
        @Override
        public String toString() {
            return tipo.name() + " el " + fecha_registro + " por " + importe + " euros. '" + concepto + "'";
        }
    }

        final static int max_movimientos = 1024; //numero maximo de movimientos

        //vector que guardará los datos del programa
        Movimiento[] movimientos = new Movimiento[max_movimientos];
        //movimientos anotados en el vector
        int num_movimientos = 0;


    void bucleApp() {
        option option;
        do{
            muestra_lista_opciones();
            option = solicita_opcion();

            switch (option){
                case cobro:
                case pago:
                    anota_movimiento(option == Cobros_pagos.option.cobro ? tipo_movimiento.abono : tipo_movimiento.cargo);
                    break;
                case movimientos:
                    lista_movimientos();
                    break;
            }

        }
        while(option != Cobros_pagos.option.salir);
    }


//muestra la lista de opciones disponibles
void muestra_lista_opciones() {
    for (option una_opcion : option.values())
        System.out.printf("\t%d -> %s\n", una_opcion.ordinal(), una_opcion.name());
    }

//solicita al usuario la opcion que quiere ejecutar
option solicita_opcion(){
        Scanner scanner = new Scanner(System.in);
        int opcion_seleccionada;
        System.out.print("\nIntroduce el numero de opción a ejecutar: ");
        opcion_seleccionada = scanner.nextInt();
        return Cobros_pagos.option.values()[opcion_seleccionada];
    }

    //anota un nuevo movimiento
    void anota_movimiento(tipo_movimiento tipo_seleccionado){
           Scanner scanner = new Scanner(System.in);

        movimientos[num_movimientos] = new Movimiento();
        movimientos[num_movimientos].tipo = tipo_seleccionado;
        movimientos[num_movimientos].fecha_registro = new Date();

        System.out.print("Concepto: ");
        movimientos[num_movimientos].concepto = scanner.nextLine();

        System.out.print("Importe: ");
        movimientos[num_movimientos].importe = new BigDecimal(scanner.next());

        System.out.println("\nMovimiento anotado");
        num_movimientos++;
    }

    void lista_movimientos() {
        System.out.println();
        for(int indice = 0; indice < num_movimientos; indice++){
            System.out.println(movimientos[indice]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        (new Cobros_pagos()).bucleApp();
    }

}
