package ru.boost;

public class List<T> {
    private Element<T> lastElement = null;

    public void addElement(int value){
        lastElement = new Element(value,lastElement);
    }

    public void addElement(Element newElement){
        newElement.setPreviousElement(lastElement);
        lastElement = newElement;
    }

    public int getSize(){
        return lastElement.getNumber()+1;
    }

    public Element remove(){
        Element removedElement = lastElement;
        if(lastElement != null) {
            lastElement = lastElement.getPreviousElement();
        }
        removedElement.setPreviousElement(null);
        return removedElement;
    }

    public Element getLastElement(){
        return lastElement;
    }

    public T getLastValue(){
        return lastElement.getValue();
    }
}
