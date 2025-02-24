/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * Diana Sosa 241040
 * Biancka Raxón 24960
 * Ivana Figueroa 24785
 * 
 * Clase StackVector
 * Implementacion de vector en stack
 * 
 * @param <T> el tipo de elementos que contendra la pila.
 */
 

 import java.util.Vector;

 public class StackVector<T> extends StackAbstract<T>{
     private Vector<T> elements;
 
     public StackVector() {//Contructir inicial
         elements = new Vector<>();
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
 
   
 
 
     