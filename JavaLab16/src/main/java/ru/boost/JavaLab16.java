package ru.boost;

public class JavaLab16 {

    public static float getAverage(float[] array){
        float av = 0;
        for(float value : array){
            av += value;
        }
        return av/array.length;
    }


    public static void main(String[] args) {
        int size = (int)(10+Math.random()*100);
        float[] array = new float[size];
        for(int i=0;i<size;i++){
            array[i] = (float) (100*Math.random());
        }
        System.out.println("Size = "+size+"; Average = "+getAverage(array));


        Average av = new Average();
        for(int i=0;i<size;i++){
            av.add(array[i]);
        }
        System.out.println("Size = "+av.getNumNumber()+"; Average = "+av.getAverage());
    }
}
