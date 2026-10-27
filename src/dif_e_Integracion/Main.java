package dif_e_Integracion;

public class Main {

    public static void main(String[] args) {
        double a = 0.0;
        double b = 1.0;
        double tolerancia = 1e-6;

        System.out.println("Integral de f(x) = e^(-x^2) en [" + a + ", " + b + "]");
        System.out.println("Tolerancia: " + tolerancia);
        System.out.println("------------------------------------------------");

        double trapecio = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.println("TRAPECIO COMPUESTO");
        System.out.printf("  Resultado    : %.10f%n", trapecio);
        System.out.println("  Iteraciones  : " + TrapecioCompuesto.iteraciones);
        System.out.println("  Subintervalos: " + TrapecioCompuesto.nFinal);
        System.out.println();

        double simpson = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.println("SIMPSON 1/3 COMPUESTO");
        System.out.printf("  Resultado    : %.10f%n", simpson);
        System.out.println("  Iteraciones  : " + SimpsonCompuesto.iteraciones);
        System.out.println("  Subintervalos: " + SimpsonCompuesto.nFinal);
    }
}
