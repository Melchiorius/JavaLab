package ru.boost;

public class JavaLab15 {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        for(int i = 0;i<((int)(5+Math.random()*10));i++){
            list.addElement((int)(Math.random()*1000));
        }
        System.out.println("List size = "+list.getSize());
        System.out.println("List elements: ");
        Element element = list.getLastElement();
        while(element != null){
            System.out.print(element.getValue()+" ");
            element = element.getPreviousElement();
        }
        System.out.print("\b\n");
    }
}
