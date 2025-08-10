import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class CalculadoraGUI extends JFrame {
    private final JTextField display = new JTextField();
    private final Calculadora calc = new Calculadora();
    private final DecimalFormat df = new DecimalFormat("#.##########");
    private String pendingOp = null;

    public CalculadoraGUI() {
        setTitle("Calculadora Pro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(30, 30, 30));

        // ==== DISPLAY ====
        display.setFont(new Font("Monospaced", Font.BOLD, 28));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.GREEN);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        // ==== PANEL BOTONES ====
        JPanel panelBasico = new JPanel(new GridLayout(4, 4, 8, 8));
        panelBasico.setBackground(new Color(30, 30, 30));
        panelBasico.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] botonesBasicos = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0",".","=","+"
        };

        for (String b : botonesBasicos) {
            JButton btn = crearBoton(b, esNumero(b) ? new Color(60, 63, 65) : new Color(255, 140, 0), Color.WHITE);
            panelBasico.add(btn);
        }

        add(panelBasico, BorderLayout.CENTER);

        // ==== PANEL INFERIOR ====
        JPanel panelSur = new JPanel(new BorderLayout(10, 10));
        panelSur.setBackground(new Color(30, 30, 30));

        JButton btnAvanzado = crearBoton("Funciones Avanzadas", new Color(70, 130, 180), Color.WHITE);
        btnAvanzado.setFont(new Font("Arial", Font.BOLD, 14));
        btnAvanzado.addActionListener(e -> mostrarOperacionesAvanzadas());
        panelSur.add(btnAvanzado, BorderLayout.CENTER);

        JButton btnClear = crearBoton("C", new Color(220, 20, 60), Color.WHITE);
        btnClear.setFont(new Font("Arial", Font.BOLD, 14));
        btnClear.addActionListener(e -> {
            display.setText("");
            calc.setActualNumber(0.0);
            pendingOp = null;
        });
        panelSur.add(btnClear, BorderLayout.EAST);

        add(panelSur, BorderLayout.SOUTH);
    }

    private JButton crearBoton(String texto, Color fondo, Color letra) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        btn.setBackground(fondo);
        btn.setForeground(letra);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

        btn.addActionListener(e -> manejarEntrada(texto));
        return btn;
    }

    private boolean esNumero(String t) {
        return t.matches("[0-9\\.]");
    }

    private void manejarEntrada(String entrada) {
        try {
            if (esNumero(entrada)) {
                display.setText(display.getText() + entrada);
                return;
            }
            if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("/")) {
                if (!display.getText().isBlank()) {
                    calc.setActualNumber(Double.parseDouble(display.getText()));
                }
                pendingOp = entrada;
                display.setText("");
                return;
            }
            if (entrada.equals("=")) {
                if (pendingOp != null && !display.getText().isBlank()) {
                    double segundo = Double.parseDouble(display.getText());
                    switch (pendingOp) {
                        case "+": calc.suma(segundo); break;
                        case "-": calc.resta(segundo); break;
                        case "*": calc.multiplicacion(segundo); break;
                        case "/": calc.division(segundo); break;
                    }
                    display.setText(df.format(calc.getActualNumber()));
                    pendingOp = null;
                }
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    private void mostrarOperacionesAvanzadas() {
        String[] opciones = {
                "MCM", "MCD", "Fibonacci", "Seno", "Coseno", "Tangente",
                "Factorial", "Potencia", "Raiz", "IVA"
        };
        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione operación:",
                "Funciones Avanzadas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion != null) {
            try {
                if (!display.getText().isBlank()) {
                    calc.setActualNumber(Double.parseDouble(display.getText()));
                }

                if (seleccion.equals("Seno")) calc.seno(calc.getActualNumber());
                else if (seleccion.equals("Coseno")) calc.coseno(calc.getActualNumber());
                else if (seleccion.equals("Tangente")) calc.tangente(calc.getActualNumber());
                else if (seleccion.equals("Factorial")) calc.factorial(calc.getActualNumber());
                else if (seleccion.equals("Fibonacci")) calc.fibonacci(calc.getActualNumber());
                else {
                    String input = JOptionPane.showInputDialog(this, "Ingrese segundo valor:");
                    if (input != null) {
                        double segundo = Double.parseDouble(input);
                        switch (seleccion) {
                            case "MCM": calc.mcm(segundo); break;
                            case "MCD": calc.mcd(calc.getActualNumber(), segundo, false); break;
                            case "Potencia": calc.potencia(segundo); break;
                            case "Raiz": calc.raiz(segundo); break;
                            case "IVA": calc.iva(segundo); break;
                        }
                    }
                }
                display.setText(df.format(calc.getActualNumber()));
            } catch (Exception e) {
                display.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraGUI().setVisible(true));
    }
}
