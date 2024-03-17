import java.math.BigDecimal;
public class Aplicacion {
    private static Aplicacion instancia; //atributo privado con la instancia

    //constructor privado solo accesible internamente
    private Aplicacion() {
        //inicialización de la unica instancia de la clase
        System.out.println("Instancia de Aplicación creada");
    }

    //Metodo para acceder a la instancia de la clase
    public static Aplicacion getInstance(){
        if (instancia == null)
            instancia = new Aplicacion();
        return instancia;
    }

    //ejecución de la aplicación

    public void run(){
        Cuenta banco = new Cuenta("Banco"), electricidad = new Cuenta("Electricidad");

        //saldo inicial en el banco
        banco.abono(new BigDecimal("874.53"));

        //anotamos un recibo
        BigDecimal importeRecibo = new BigDecimal("46.34");
        banco.cargo(importeRecibo);
        electricidad.abono(importeRecibo);

        System.out.println(banco + "\n" + electricidad);
    }
}
