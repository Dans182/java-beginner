import java.math.BigDecimal;
import java.util.Date;

public class Cuenta {
    //Atributos con el estado interno de cada cuenta, privado. Solo manipulable desde dentro de la clase
    private long numero;
    private String nombre;
    private BigDecimal saldo;

    public long getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Date getUltimo_movimiento() {
        return ultimo_movimiento;
    }

    //Atributo protegido, accesible para subclases de esta
    protected Date ultimo_movimiento;
    //Constante publica accesible para todos
    public static final long MAX_NUM_CUENTA = Long.MAX_VALUE;

    //Atributos estaticos, asociados A LA CLASE. Variables de la clase, unicos
    private static long siguiente_codigo = 1000L;
    private static long inicio_clase;

    //bloque de inicializacion de los atributos estaticos
    //no es un metodo. Se ejecuta en el momento en que la maquina virtual java cargue la clase Cuenta en memoria
    //sucede siempre antes de crear el primer objeto de la clase
    static {
        inicio_clase = System.nanoTime();
        System.out.println("Clase cuenta cargada " + inicio_clase);
    }

    //constructor mas generico que tome como parametros los 3 que se le pasan
    public Cuenta(long numero, String nombre, BigDecimal saldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Cuenta(long numero, String nombre){
        this(numero, nombre, new BigDecimal(0));
    }

    //Constructor de copia
    public Cuenta(Cuenta cuenta){
        this(cuenta.numero, cuenta.nombre, cuenta.saldo);
    }

    //Constructor por defecto
    public Cuenta(){
        this(Cuenta.siguiente_codigo, "Cuenta " + Cuenta.siguiente_codigo);
        Cuenta.siguiente_codigo++;
    }

    @Override public String toString(){
        return numero + ", " + nombre + ", " + saldo;
    }

    public BigDecimal cargo(BigDecimal importe) {
        saldo = saldo.subtract(importe);
        return saldo;
    }

    public BigDecimal abono(BigDecimal importe){
        saldo = saldo.add(importe);
        return saldo;
    }

    //agregamos un constructor que nos permita al crear un nuevo objeto de la clase cuenta
    public Cuenta(String nombre_cuenta){
        numero = siguiente_codigo++;
        nombre = nombre_cuenta;
        saldo = new BigDecimal(0);
    }



    public void muestra_estado() {
        System.out.println(
                "siguiente_codigo = " + siguiente_codigo + " \n" +
                "inicio_clase = " + inicio_clase + "\n" +
                        "numero = " + numero + "\n" +
                        "nombre  = " + nombre
        );
    }
}
