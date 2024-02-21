import java.util.Date;

public class TiposEstructurados {

    //Enums
    //Al no estar dentro de main, nos permite usar este método en cualquier otro.
    //Los enums son constantes.
    enum Mes{Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre}


    //Struct
    //Otro tipo de dato complejo son las estructuras
    //Enumeracion con los brillos de un objeto celeste
    enum Intensidad {
        cegador, brillante, visible, apagado, invisible
    }

    //estructura de datos para almacenar la información de un sistema solar
    static final class sistema_solar {
        String nombre;
        Intensidad brillo;
        int num_estrellas;
        int num_planetas;
        double diametro_ua;
        boolean hay_vida;
        Date fecha_registro;

        //le añadimos un metodo toString, para poder imprimir los datos de dicho sistema solar
        @Override
        //le añadimos la anotación override porque el metodo toString esta definido en todas las clases de Java
        //Se heredan automaticamente del tipo primitivo Object de Java
        //De esta manera estamos redefiniendo la función para nuestro tipo de dato en concreto
        public String toString() {
            return "Sistema solar: " + nombre +
                    " con brillo " + brillo.name() +
                    "\nTiene "+ num_estrellas +
                    " estrellas y " + num_planetas + " planetas \n" +
                    "su diametro es de " + diametro_ua +
                    " UAs y se registró el " + fecha_registro;
        }
    }
//el atributo final impide que esta clase se utilice como base de otra. Como si fuera una constante

public static void main(String[] args) {
        //tres constantes
    final int num_meses = 12;
    final int dias_año = 365;
    final int num_poblaciones = 50;

    //distintas formas de inicializar un vector
    //los siguientes son dos vectores/matrices/arrays unidimensionales
    int[] dias_mes = new int[num_meses],
    muestra_edades = {19, 32, 26, 54, 38};

    //vector bidimensional
    float[][] pluviometria = new float[dias_año][num_poblaciones];

    //acceso a un elemento de la matriz
    dias_mes[Mes.Enero.ordinal()] = 31;
    pluviometria[34][Mes.Diciembre.ordinal()] = 12.6f;

    //Obtenemos el numero de elementos de un vector
    System.out.println("Numero de elementos = " + muestra_edades.length);

    //Los vectores pueden obtenerse a partir de distintas operaciones
    String nombre_curso = "Iniciación a Java";
    //separamos la cadena a varias partes, usando el espacio como separador
    String[] partes_cadena = nombre_curso.split(" ");
    //el resultado es un vector de cadenas

    //Mostramos el numero de elementos obtenidos y el ultimo elemento del vector de cadenas
    System.out.println(
            "Numero de elementos: " + partes_cadena.length +
                    "\nUltima subcadena: " + partes_cadena[partes_cadena.length - 1]
    );

    //Uso de la estructura de datos sistema_solar
    //sistema_solar un_sistema_solar = new sistema_solar();
    //aca estamos creando una variable llamada un_sistema_solar, del tipo sistema_solar (de su izquierda)
    //como la variable un_sistema_solar contendra una referencia al objeto del tipo sistema_solar
    //tenemos que crear el objeto, haciendo uso de la palabra new acompañado del tipo, o la clase, sistema_solar()
    //Esto nos permite crear un objeto, tomando como referencia la clase sistema_solar() y nos permite acceder a los
    //miembros de dicho objeto y ya inicializados.
    sistema_solar un_sistema_solar = new sistema_solar();
    un_sistema_solar.nombre = "Carinae B21";
    un_sistema_solar.brillo = Intensidad.visible;
    un_sistema_solar.num_estrellas = 2;
    un_sistema_solar.num_planetas = 1;
    un_sistema_solar.diametro_ua = 7.6;
    un_sistema_solar.hay_vida = false;
    un_sistema_solar.fecha_registro = new Date();

    System.out.println(un_sistema_solar);
    }
}