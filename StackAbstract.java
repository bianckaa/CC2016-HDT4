/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * Diana Sosa 241040
 * Biancka Raxón 24960
 * Ivana Figueroa 24785
 * 
 * Clase Abstract Stack:
 * funciones en comun con las implementaciones de stack
 * 
 * @param <T> el tipo de elementos que contendra la pila.
 */
 

public abstract class StackAbstract<T> implements IStack<T> {

    @Override 
    public boolean isEmpty(){
        return size() == 0;
    }

  
}