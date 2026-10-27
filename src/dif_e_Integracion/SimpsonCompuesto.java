package dif_e_Integracion;

public class SimpsonCompuesto {

    // Métricas de la última ejecución (para el reporte comparativo)
    public static int iteraciones = 0;
    public static int nFinal = 0;

    private static double calcularSimpson(double a, double b, int n) {
        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            // Simpson 1/3: los nodos de índice impar llevan coeficiente 4
            // y los de índice par llevan coeficiente 2.
            if (k % 2 != 0) {
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        double sumaTotal = TrapecioCompuesto.funcion(a) + 4 * sumaImpares
                + 2 * sumaPares + TrapecioCompuesto.funcion(b);

        return (h / 3) * sumaTotal;
    }

    public static double integrarConTolerancia(double a, double b,
                                               double tolerancia) {
        int n = 2;
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;
        iteraciones = 1; // evaluación inicial con n = 2

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            iteraciones++;
            double integralNueva = calcularSimpson(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }

        nFinal = n;
        return integralAnterior;
    }
}
