/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * Diana Sosa 241040
 * Biancka Raxón 24960
 * Ivana Figueroa 24785
 * 
 * Clase StackArrayList
 * Implementacion de ArrayList en stack
 * 
 * @param <T> el tipo de elementos que contendra la pila.
 */

import java.util.ArrayList;

public class StackArrayList<T> extends StackAbstract<T>{
    private ArrayList<T> elements;



    public StackArrayList() { //Contructor inicial
        elements = new ArrayList<>();
    }


    @Override
    public void push (T element) {
        elements.add(element);
    
    }



    @Override
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("esta vacia la pila");
        }
        return elements.remove(elements.size() - 1);
    }



    @Override
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("esta vacia la pila");
        }
        return elements.get(elements.size() - 1);

    }




    @Override 
    public int size() {
        return elements.size();
    }
}