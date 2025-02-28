public class Main {
    public static void main(String[] args) {
        
        String infix = ReaderDocument.leerExpresion("datos.txt");
        if (infix.isEmpty()) {
            System.out.println("No se encontró ninguna expresión en el archivo.");
            return;
        }

        
        String estructura = UI.seleccionarEstructura();
        StackAbstract<Character> pila = null;
        ListAbstract<String> lista = null;
        String tipoImplementacion = "";

        
        if (estructura.equals("pila")) {
            tipoImplementacion = UI.seleccionarPila();
            if (tipoImplementacion.contains("PilaLista")) {
                String tipoLista = tipoImplementacion.contains("Simple") ? "simple" : "doble";
                lista = FactoryList.getLista(tipoLista);
            } else {
                pila = FactoryPila.getPila(tipoImplementacion.replace("Pila", "").toLowerCase());
            }
        } else {
            tipoImplementacion = UI.seleccionarLista();
            lista = FactoryList.getLista(tipoImplementacion.replace("Lista", "").toLowerCase());
        }

        
        String postfix = Translator.convertir(infix);

        
        int resultado = Calculadora.evaluarPostfix(postfix);

        
        UI.mostrarResultado(infix, postfix, resultado, tipoImplementacion);
    }
}
