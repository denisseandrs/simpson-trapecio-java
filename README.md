# Simpson Compuesto . Trapecio Compuesto

**Materia:** Métodos Numéricos — Unidad 4
**Docente:** Víctor Hugo Vásquez Herrera
**Alumna:** Denisse Itzel Andres Garrido

## Compilar y ejecutar desde la terminal

1. Clona el repositorio y entra a la carpeta:
   ```bash
   git clone <https://github.com/denisseandrs/simpson-trapecio-java>
   cd <simpson-trapecio-java>
   ```
2. Compila (los .class se generan en la carpeta out):
   ```bash
   mkdir out
   javac -d out src/dif_e_Integracion/*.java
   ```
   En Windows (CMD/PowerShell): `mkdir out` y
   `javac -d out src\dif_e_Integracion\*.java`
3. Ejecuta:
   ```bash
   java -cp out dif_e_Integracion.Main
   ```
## Parámetros de prueba

Se pueden cambiar en Main.java y en TrapecioCompuesto.funcion:

| Parámetro   | Valor              |
|-------------|--------------------|
| Función     | f(x) = e^(-x²)     |
| Intervalo   | [0, 1]             |
| Tolerancia  | 1e-6               |
| n inicial   | 2 (se duplica)     |

## Ejemplo de salida en consola

```
Integral de f(x) = e^(-x^2) en [0.0, 1.0]
Tolerancia: 1.0E-6
------------------------------------------------
TRAPECIO COMPUESTO
  Resultado    : 0.7468238989
  Iteraciones  : 9
  Subintervalos: 512

SIMPSON 1/3 COMPUESTO
  Resultado    : 0.7468241406
  Iteraciones  : 5
  Subintervalos: 32
```
