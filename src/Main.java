/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 4
 * 
 * Clase Main
 * Punto de entrada principal para la aplicación de la calculadora.
 * Lee una expresión desde un archivo de texto, convierte la expresión infix a postfix,
 * y evalúa el resultado utilizando diferentes implementaciones de estructuras de datos (Pilas o Listas).
 * 
 * @version 1.0
 */

 public class Main {
    
    /**
     * Método principal que ejecuta la aplicación.
     * 
     * Lee una expresión desde un archivo de texto, selecciona la estructura de datos (Pila o Lista)
     * y su implementación específica (Array, Vector, Lista Simple o Lista Doble).
     * Convierte la expresión infix a postfix, la evalúa y muestra el resultado.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        
        // Lee la expresión infix desde el archivo de texto.
        String infix = ReaderDocument.leerExpresion("datos.txt");
        if (infix.isEmpty()) {
            System.out.println("No se encontró ninguna expresión en el archivo.");
            return;
        }

        // Selecciona la estructura de datos (Pila o Lista).
        String estructura = UI.seleccionarEstructura();
        StackAbstract<Character> pila = null;
        ListAbstract<String> lista = null;
        String tipoImplementacion = "";

        // Si se selecciona una Pila, se elige la implementación específica.
        if (estructura.equals("pila")) {
            tipoImplementacion = UI.seleccionarPila();
            if (tipoImplementacion.contains("PilaLista")) {
                // Si es una Pila basada en Lista, selecciona el tipo de Lista (simple o doble).
                String tipoLista = tipoImplementacion.contains("Simple") ? "simple" : "doble";
                lista = FactoryList.getLista(tipoLista);
            } else {
                // Si es una Pila tradicional (Array, Vector), se obtiene la implementación correspondiente.
                pila = FactoryPila.getPila(tipoImplementacion.replace("Pila", "").toLowerCase());
            }
        } else {
            // Si se selecciona una Lista, se obtiene la implementación específica de Lista.
            tipoImplementacion = UI.seleccionarLista();
            lista = FactoryList.getLista(tipoImplementacion.replace("Lista", "").toLowerCase());
        }

        // Convierte la expresión infix a postfix.
        String postfix = Translator.convertir(infix);

        // Evalúa la expresión postfix y obtiene el resultado.
        int resultado = Calculadora.evaluarPostfix(postfix);

        // Muestra el resultado de la conversión y evaluación.
        UI.mostrarResultado(infix, postfix, resultado, tipoImplementacion);
    }
}
