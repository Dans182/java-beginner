public class Main {

    private void run() {
        //Cuenta una_cuenta = new Cuenta("cuenta_pepe");

        //una_cuenta.ultimo_movimiento()
        //Solo me muestra el metodo ultimo_movimiento. Por estar actualmente
        //en una clase distinta a la clase Cuenta, solo puedo acceder a los
        //protected. Los privados no puedo. solo podría desde la propia clase
        //cuenta
        //al ser protected, hace que el atributo sea accesible tanto para las clases
        //derivadas de Cuenta como para las clases que pertenezcan al mismo paquete
        //Cuenta.MAX_NUM_CUENTA();
        //Si envez de usar el nombre del objeto como arriba, usamos el de la clase, podemos acceder a los atributos
        //publico de dicha clase.

        //una_cuenta.muestra_estado();

        //(new Cuenta("Cuenta pepe")).muestra_estado();

        Aplicacion.getInstance().run();
    }
    
    public static void main(String[] args) {
        (new Main()).run();
    }


}