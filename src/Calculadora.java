import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculadora {

    private double actualNumber;
    private String operation = "";
    boolean flag = true;
    private final Scanner scanner = new Scanner(System.in);

    public void calculator (){


        System.out.println("##### Calculadora ######");
        System.out.println(" ");
        System.out.print("Digite el primer valor:  ");
        actualNumber = scanner.nextInt();
        showCalculator();
        do{

            int option = scanner.nextInt();

            switch (option){
                case 0 : restore();
                    break;
                case 1 : suma(operatorsOptions("suma", "+", true));
                    break;
                case 2 : resta(operatorsOptions("resta", "-", true));
                    break;
                case 3 : multiplicacion(operatorsOptions("multiplicacion", "*", true));
                    break;
                case 4 : division(operatorsOptions("division", "/", true));
                    break;
                case 5 : mcm(operatorsOptions("MCM", "MCM", true));
                    break;
                case 6 : mcd(actualNumber, operatorsOptions("MCD", "MCD", true), true);
                    break;
                case 7 : fibonacci(operatorsOptions("Fibonacci", "Fibonacci", false));
                    break;
                case 8 : seno(operatorsOptions("Seno", "", false));
                    break;
                case 9 : coseno(operatorsOptions("Coseno", "", false));
                    break;
                case 10 : tangente(operatorsOptions("Tangente", "", false));
                    break;
                case 11 : factorial(operatorsOptions("Factorial", "",false));
                    break;
                case 12 : potencia(operatorsOptions("Potencia", "Potencia", true));
                    break;
                case 13: raiz(operatorsOptions("Raiz", "raiz", true));
                    break;
                case 14: iva(operatorsOptions("porcentaje del iva", "%", true));
                    break;
                default:
                    System.out.print(""" 
                                                                               FIN DE LA CALCULADORA
                                                                               
                                                             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠒⠒⠢⢄⡀⠀⠀⢠⡏⠉⠉⠉⠑⠒⠤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠀⠀⠀⠀⠀⠙⢦⠀⡇⡇⠀⠀⠀⠀⠀⠀⠈⠱⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠊⠉⠉⠙⠒⢤⡀⠀⣼⠀⠀⢀⣶⣤⠀⠀⠀⢣⡇⡇⠀⠀⢴⣶⣦⠀⠀⠀⢳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                              ⠀⠀⠀⢀⣠⠤⢄⠀⠀⢰⡇⠀⠀⣠⣀⠀⠀⠈⢦⡿⡀⠀⠈⡟⣟⡇⠀⠀⢸⡇⡆⠀⠀⡼⢻⣠⠀⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                              ⠀⢀⠖⠉⠀⠀⠀⣱⡀⡞⡇⠀⠀⣿⣿⢣⠀⠀⠈⣧⣣⠀⠀⠉⠋⠀⠀⠀⣸⡇⠇⠀⠀⠈⠉⠀⠀⠀⢀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                              ⣠⠏⠀⠀⣴⢴⣿⣿⠗⢷⡹⡀⠀⠘⠾⠾⠀⠀⠀⣿⣿⣧⡀⠀⠀⠀⢀⣴⠇⣇⣆⣀⢀⣀⣀⣀⣀⣤⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                              ⣿⠀⠀⢸⢻⡞⠋⠀⠀⠀⢿⣷⣄⠀⠀⠀⠀⠀⣠⡇⠙⢿⣽⣷⣶⣶⣿⠋⢰⣿⣿⣿⣿⣿⣿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                              ⡿⡄⠀⠈⢻⣝⣶⣶⠀⠀⠀⣿⣿⣱⣶⣶⣶⣾⡟⠀⠀⠀⢈⡉⠉⢩⡖⠒⠈⠉⡏⡴⡏⠉⠉⠉⠉⠉⠉⠉⠉⡇⠀⠀⢀⣴⠒⠢⠤⣀
                                                              ⢣⣸⣆⡀⠀⠈⠉⠁⠀⠀⣠⣷⠈⠙⠛⠛⠛⠉⢀⣴⡊⠉⠁⠈⢢⣿⠀⠀⠀⢸⠡⠀⠁⠀⠀⠀⣠⣀⣀⣀⣀⡇⠀⢰⢁⡇⠀⠀⠀⢠
                                                              ⠀⠻⣿⣟⢦⣤⡤⣤⣴⣾⡿⢃⡠⠔⠒⠉⠛⠢⣾⢿⣿⣦⡀⠀⠀⠉⠀⠀⢀⡇⢸⠀⠀⠀⠀⠀⠿⠿⠿⣿⡟⠀⢀⠇⢸⠀⠀⠀⠀⠘
                                                              ⠀⠀⠈⠙⠛⠿⠿⠿⠛⠋⢰⡋⠀⠀⢠⣤⡄⠀⠈⡆⠙⢿⣿⣦⣀⠀⠀⠀⣜⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⢀⠃⠀⡸⠀⠇⠀⠀⠀⠀⠀
                                                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢣⠀⠀⠈⠛⠁⠀⢴⠥⡀⠀⠙⢿⡿⡆⠀⠀⢸⠀⢸⢰⠀⠀⠀⢀⣿⣶⣶⡾⠀⢀⠇⣸⠀⠀⠀⠀⠀⠀
                                                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡀⢇⠀⠀⠀⢀⡀⠀⠀⠈⢢⠀⠀⢃⢱⠀⠀⠀⡇⢸⢸⠀⠀⠀⠈⠉⠉⠉⢱⠀⠼⣾⣿⣿⣷⣦⠴⠀⠀
                                                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢱⠘⡄⠀⠀⢹⣿⡇⠀⠀⠈⡆⠀⢸⠈⡇⢀⣀⣵⢨⣸⣦⣤⣤⣄⣀⣀⣀⡞⠀⣠⡞⠉⠈⠉⢣⡀⠀⠀
                                                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢃⠘⡄⠀⠀⠉⠀⠀⣠⣾⠁⠀⠀⣧⣿⣿⡿⠃⠸⠿⣿⣿⣿⣿⣿⣿⠟⠁⣼⣾⠀⠀⠀⠀⢠⠇⠀⠀
                                                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠹⣀⣀⣤⣶⣿⡿⠃⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⢻⣿⣷⣦⣤⣤⠎⠀⠀⠀
                                                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣤⣿⡿⠟⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠀⠀⠀⠀⠀ """);
                    break;
            }
        }while (flag);
    }

    public double operatorsOptions(String option, String operator, boolean isNumberRequired) {
        if (isNumberRequired){
            System.out.print("Escribe el numero de " + option+": ");
            int operatorOptionSelected =  scanner.nextInt();
            DecimalFormat df = new DecimalFormat("#.##########");
            operation = df.format(actualNumber) +  " " + operator + " " + operatorOptionSelected + " = ";
            return operatorOptionSelected;
        }else {
            DecimalFormat df = new DecimalFormat("#.##########");
            operation = option + " : " + df.format(actualNumber) + " = ";
            return actualNumber;
        }

    }

    public void showCalculator(){
        String[] options = {
                "0. Reestablecer",
                "1. Suma",
                "2. Resta",
                "3. Multiplicacion",
                "4. Division",
                "5. MCM",
                "6. MCD",
                "7. Fibonacci",
                "8. Seno (grados)",
                "9. Coseno (grados)",
                "10. Tangente (grados)",
                "11. Factorial",
                "12. Potencia",
                "13. Raiz",
                "14. Iva",
                "15. Cerrar calculadora",
        };

        DecimalFormat df = new DecimalFormat("#.##########"); // Hasta 10 decimales máx.
        String screen = operation + df.format(actualNumber);

        System.out.println("  ╔════════════════════════════════════════════════════════════════╗");
        System.out.println("  ║ ███████████████████████████████████████████████████████████████║");
        System.out.printf ("  ║ █ %-56s   ██║%n", screen);
        System.out.println("  ║ ███████████████████████████████████████████████████████████████║");

// Botones base
        String[] buttons = {
                "┌───────┬───────┬───────┬───────┐",
                "│   7   │   8   │   9   │   +   │",
                "├───────┼───────┼───────┼───────┤",
                "│   4   │   5   │   6   │   -   │",
                "├───────┼───────┼───────┼───────┤",
                "│   1   │   2   │   3   │   ×   │",
                "├───────┼───────┼───────┼───────┤",
                "│   .   │   0   │   =   │   ÷   │",
                "└───────┴───────┴───────┴───────┘"
        };

// Dibujar botones y las opciones al lado
        int maxLineas = Math.max(buttons.length, options.length);
        for (int i = 0; i < maxLineas; i++) {
            if (i < buttons.length) {
                // si hay un boton al lado
                String boton = buttons[i];
                String opcion = i < options.length ? options[i] : "";
                System.out.printf("  ║ %-31s │  %-25s ║%n", boton, opcion);
            } else {
                // si no hay boton al lado
                // se formatea al 33 para evitar las lineas donde no son
                String opcion = i < options.length ? options[i] : "";
                System.out.printf("  ║ %-33s │  %-25s ║%n", "", opcion);
            }
        }

        System.out.println("  ╚════════════════════════════════════════════════════════════════╝");
    }


    //Suma
    public void suma (double b){
        actualNumber = actualNumber+b;
        showCalculator();
    }
    //Resta
    public void resta(double b){
        actualNumber = actualNumber-b;
        showCalculator();
    }
    //Multiplicacion
    public void multiplicacion(double b){
        actualNumber = actualNumber*b;
        showCalculator();
    }
    //Division
    public void division(double b){
        if (b == 0){
            System.out.println("error");
        }else{
            actualNumber = actualNumber/b;
            showCalculator();
        }

    }
    //Seno
    public void seno(double a){

        actualNumber = Math.sin(Math.toRadians(a));
        showCalculator();
    }
    //Coseno
    public void coseno(double a){

        actualNumber = Math.cos(Math.toRadians(a));
        showCalculator();
    }
    //Tangente
    public void tangente(double a){

        actualNumber = Math.tan(Math.toRadians(a));
        showCalculator();
    }
    //Serie de fibonacci (Calcula el n-ésimo número de  la serie de Fibonacci)
    public void fibonacci(double n) {
        n = (int) actualNumber;
        if (n == 0) {
            System.out.println("error");
            return;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int val = a + b;
            a = b;
            b = val;
        }
        if (n == 0) {
            actualNumber = a;
        }else {
            actualNumber = b;
        }
        showCalculator();
    }
    // factorial
    public void factorial (double n) {
        if (n < 0){
            System.out.println("El factorial no está definido para números negativos.");
            return;
        }
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        actualNumber = resultado;
        showCalculator();
    }

    //minimo comun multiplo necesita de maximo para funcionar
    public void mcm(double b) {
        actualNumber= Math.abs(actualNumber * b) / mcd(actualNumber, b, false);
        showCalculator();
    }

    //este codigo de maximo sale de chatgpt y hace funcionar al minimo :)
    public double mcd(double a, double b, boolean showCalculator) {
        while (b != 0) {
            double temp = b;
            b = a % b;
            a = temp;
        }
        //return Math.abs(a);
        actualNumber = a;
        if (showCalculator){
            showCalculator();
        }

        return a;


    }

    //potencia enecima
    public void potencia(double b) {
        actualNumber =  Math.pow(actualNumber, b);
        showCalculator();
    }
    //raiz enecima
    public void raiz (double b){
        actualNumber = Math.pow(actualNumber, 1/b);
        showCalculator();
    }
    //Porcentaje Iva
    public void iva (double b){
        actualNumber = actualNumber *(b/100);
        showCalculator();
    }



    //Vuelve el primer valor a cero
    public void restore(){
        System.out.println("Escribe un numero");
        actualNumber = scanner.nextInt();
        operation = "";
        showCalculator();
    }


    public double getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(double value) {
        this.actualNumber = value;
        this.operation = "";
    }

}
