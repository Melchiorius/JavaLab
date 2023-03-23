package ru.boost;

public class Element<T> {
    private T value;
    private Element previous;
    private int number;

    public Element(T value){
        this.value = value;
        this.previous = null;
        this.number = 0;
    }

    public Element(T value, Element previous){
        this.value = value;
        this.previous = previous;
        number = previous==null?0:previous.getNumber()+1;
    }

    public int getNumber(){
        return number;
    }


    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;

    }

    public Element getPreviousElement(){
        return previous;
    }

    public void setPreviousElement(Element previous){
        this.previous = previous;
        number = previous==null?0:previous.getNumber()+1;
    }
}
