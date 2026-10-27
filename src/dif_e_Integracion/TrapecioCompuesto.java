package dif_e_Integracion;

public class TrapecioCompuesto {

    // Métricas de la última ejecución (para el reporte comparativo)
    public static int iteraciones = 0;
    public static int nFinal = 0;

    /** Función a integrar: f(x) = e^(-x^2) */
    public static double funcion(double x) {
        return Math.exp(-x * x);
    }

    /** Ancho de cada subintervalo: h = (b - a) / n */
    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    /** Regla del Trapecio Compuesto con n subintervalos. */
    private static double calcularTrapecio(double a, double b, int n) {
        double h = calcularH(a, b, n);
        double suma = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            suma += funcion(xk);
        }

        return (h / 2) * (funcion(a) + 2 * suma + funcion(b));
    }

    /** Duplica n hasta que |I_nueva - I_anterior| <= tolerancia. */
    public static double integrarConTolerancia(double a, double b,
                                               double tolerancia) {
        int n = 2;
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = 999.0;
        iteraciones = 1; // evaluación inicial con n = 2

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            iteraciones++;
            double integralNueva = calcularTrapecio(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }

        nFinal = n;
        return integralAnterior;
    }
}
