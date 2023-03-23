package ru.boost;

public class Average {

    private float average;
    private int numNumber;

    public Average() {
        this.average = 0;
        this.numNumber = 0;
    }

    public void add(float value){
        this.average = ((this.average*this.numNumber) + value)/(this.numNumber + 1);
        this.numNumber++;
    }

    public float getAverage() {
        return average;
    }

    public int getNumNumber() {
        return numNumber;
    }

}
