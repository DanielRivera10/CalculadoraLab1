public class Calculadora {

    //Suma
    public static double suma (double a, double b){

        return a+b;
    }
    //Resta
    public static double resta(double a, double b){

        return a-b;
    }
    //Multiplicacion
    public static double multiplicacion(double a, double b){

        return a*b;
    }
    //Division
    public static double division(double a, double b){

        return a/b;
    }
    //Seno
    public static double seno(double a){

        return Math.sin(a);
    }
    //Coseno
    public static double coseno(double a){

        return Math.cos(a);
    }
    //Tangente
    public static double tangente(double a){

        return Math.tan(a);
    }
    //Serie de fibonacci (Calcula el n-ésimo número de la serie de Fibonacci)
    public static int fibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int val = a + b;
            a = b;
            b = val;
        }
        return (n == 0) ? a : b;
    }






}
