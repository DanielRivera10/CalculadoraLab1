import java.util.Scanner;

public class Calculadora {

    private double actualNumber;
    boolean flag = true;
    private final Scanner scanner = new Scanner(System.in);

    public void calculator (){

        restore();
        System.out.println("##### Calculadora ######");
        System.out.println("""
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠛⠛⢻⡻⠿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣟⣫⡾⠛⠛⠛⠛⠛⠛⠿⣾⣽⡻⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⡟⣼⠏⠄⠄⠄⠄⠄⠄⣀⣀⡀⣙⣿⣎⢿⣿⣿⣿
                ⣿⣿⣿⣿⣿⢹⡟⠄⠄⠄⣰⡾⠟⠛⠛⠛⠛⠛⠛⠿⣮⡻⣿⣿
                ⣿⡿⢟⣻⣟⣽⠇⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⢿⡹⣿
                ⡟⣼⡟⠉⠉⣿⠄⠄⠄⠄⢿⡄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣼⢟⣿
                ⣇⣿⠁⠄⠄⣿⠄⠄⠄⠄⠘⢿⣦⣄⣀⣀⣀⣀⣤⡴⣾⣏⣾⣿
                ⡇⣿⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠈⠉⠛⠋⠉⠉⠄⠄⢻⣿⣿⣿
                ⢃⣿⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸⣧⣿⣿
                ⡻⣿⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣸⣧⣿⣿
                ⡇⣿⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣿⢹⣿⣿
                ⣿⡸⢷⣤⣤⣿⡀⠄⠄⠄⠄⢠⣤⣄⣀⣀⣀⠄⠄⢠⣿⣿⣿⣿
                ⣿⣿⣷⣿⣷⣿⡇⠄⠄⠄⠄⢸⡏⡍⣿⡏⠄⠄⠄⢸⡏⣿⣿⣿
                ⣿⣿⣿⣿⣿⢼⡇⠄⠄⠄⠄⣸⡇⣷⣻⣆⣀⣀⣀⣼⣻⣿⣿⣿
                ⣿⣿⣿⣿⣿⣜⠿⢦⣤⣤⡾⢟⣰⣿⣷⣭⣯⣭⣯⣥⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿""");
        System.out.print("Digita numero ");
        actualNumber = scanner.nextInt();
        do{

            System.out.println("elige ");
            System.out.println("1. suma");
            System.out.println("2. resta");
            System.out.println("3. multi");
            System.out.println("4. divi");
            int option = scanner.nextInt();

            switch (option){
                case 1 : suma(operatorsOptions("suma", "+"));
                break;
                case 2 : resta(operatorsOptions("resta", "-"));
                break;
                case 3 : multiplicacion(operatorsOptions("multiplicacion", "*"));
                break;
                case 4 : division(operatorsOptions("division", "/"));
                break;
            }
        }while (flag);
    }

    public double operatorsOptions(String option, String operator) {
        System.out.println(option);
        System.out.println("-----------");
        System.out.print(actualNumber + " " + operator + " ");
        return scanner.nextInt();

    }

    public void showCalculator(){
        System.out.printf(
                "  ╔══════════════════════════════════════════════════════════════╗%n" +
                        "  ║ ████████████████████████████████████████████████████████████ ║%n" +
                        "  ║ █ %-56s █ ║%n" +
                        "  ║ ████████████████████████████████████████████████████████████ ║%n" +
                        "  ║ ┌───────┬───────┬───────┬───────┐                           ║%n" +
                        "  ║ │   7   │   8   │   9   │   +   │                           ║%n" +
                        "  ║ ├───────┼───────┼───────┼───────┤                           ║%n" +
                        "  ║ │   4   │   5   │   6   │   -   │                           ║%n" +
                        "  ║ ├───────┼───────┼───────┼───────┤                           ║%n" +
                        "  ║ │   1   │   2   │   3   │   ×   │                           ║%n" +
                        "  ║ ├───────┼───────┼───────┼───────┤                           ║%n" +
                        "  ║ │   .   │   0   │   =   │   ÷   │                           ║%n" +
                        "  ║ └───────┴───────┴───────┴───────┘                           ║%n" +
                        "  ╚══════════════════════════════════════════════════════════════╝%n",
                actualNumber
        );
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

        actualNumber = Math.sin(a);
    }
    //Coseno
    public void coseno(double a){

        actualNumber = Math.cos(a);
    }
    //Tangente
    public void tangente(double a){

        actualNumber = Math.tan(a);
    }
    //Serie de fibonacci (Calcula el n-ésimo número de la serie de Fibonacci)
    public int fibonacci(int n) {
        if (actualNumber == 0) {
            System.out.println("error");
        }
        n = (int) actualNumber;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int val = a + b;
            a = b;
            b = val;
        }
        return (n == 0) ? a : b;
    }

    public void restore(){
        actualNumber = 0;
    }


    public double getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(double number){
        this.actualNumber = number;
    }

// 0 -> /5 -> summa -> #1 ->


}
