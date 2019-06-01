/*
 * //
 */
package model;

//import java.util.ArrayList;

/**
 *
 * @author david
 * @param <E>
 */

public class MojStack<E extends Object> {
    //private ArrayList<E> list;
    private MojStackElem<E> zadnjiElement;
    
    private class MojStackElem<E>{
        E e;
        MojStackElem<E> predhodni;
        
        public MojStackElem(E e, MojStackElem<E> predhodni) {
            this.e = e;
            this.predhodni = predhodni;
        }
    }

    public MojStack() {
        //this.list = new ArrayList<E>();
        zadnjiElement = null;
    }

    public E add(E e) { //dodaje na kraj liste
        /*this.list.add(e); //dodaje list
        return e;*/
        zadnjiElement = new MojStackElem<E>(e,zadnjiElement);
        return e;
    }

    public E pop() { //mice zadnji
        /*if(list.isEmpty()){
            return null;
        }
        return list.remove(list.size()-1);*/
        if(isEmpty())
            return null;
        E ee = zadnjiElement.e;
        zadnjiElement = zadnjiElement.predhodni;
        return ee;
        
    }

    public E peek() { //dohvaca zadnji
        /*if(list.size() == 0){
            return null;
        }
        return list.get(list.size()-1);*/
        if(isEmpty())
            return null;
        return zadnjiElement.e;
        
    }

    public boolean isEmpty() { //provjera dali ima neceg na stogu
        return zadnjiElement == null; //vraca 1 ili 0
    }
}
