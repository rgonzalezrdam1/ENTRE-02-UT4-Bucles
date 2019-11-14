import java.util.Random;
/**
 * Rubén González Rivera  
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;

    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16             numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero){
        int contador = 1;
        int resultado = 1;
        while(Math.pow(2,contador) <= numero){
            resultado = (int)Math.pow(2,contador);
            contador ++;
        }
        return resultado;
    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero){
        System.out.printf("%6d = ", numero);
        int numero2 = 0;
        while( numero != numero2){
            System.out.printf("%6d", mayorPotencia2(numero - numero2));
            numero2 += mayorPotencia2(numero - numero2);
        }
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n){
        int contador = 1;
        int numero;
        int salida = 0;
        System.out.printf("%2s \n", "Nºs aleatorios como suma de potencias de 2");
        while(n >= contador){
            System.out.println();
            numero = generador.nextInt(256)-1;
            if(numero == 0){
                contador = n + 1;
                salida ++;
            }else{
                escribirSumaPotencias(numero);
                contador ++;
            }
        }
        System.out.println();
        if(salida == 1){
            System.out.printf("%2s", "Bucle terminado porque ha salido un 0");
        }else{
            System.out.printf("%2s %d %2s\n", "Bucle terminado porque se han generado ya", n, "aleatorios");
        }
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        for(int a = 1; a <= n ;a++){
            if(caracter == ASTERISCO){
                System.out.print(ASTERISCO);
            }else if(caracter == ESPACIO){
                System.out.print(ESPACIO);
            }else{
                System.out.printf("%28s","Introduce un caracter valido");
                a = n + 1;
            }
        }
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        int espacioBlanco = 0;
        for(int a = 1; escalones >= a; a++){
            for(int b = 1; b <= alto; b++){
                escribirCaracter(ancho * espacioBlanco,' ');
                escribirCaracter(ancho,'*');
                System.out.println();
            }
            espacioBlanco ++;
        }
    }
}
