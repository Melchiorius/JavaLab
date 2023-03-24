package ru.boost;

public class JavaLab23 {

    public static void main(String[] args) {
        Matrix R = new Matrix(3,3).fillRandom(1,10);
        System.out.println("Matrix:\n"+R+"\n");
        double D = R.getDeterminant();
        System.out.println("Determinant: "+D+"\n");
        if(D != 0) {
            System.out.println("Inverse Matrix:\n" + R.getInverseMatrix() + "\n");
            System.out.println("Matrix * Inverse Matrix:\n" + R.getInverseMatrix().multiply(R) + "\n");
            System.out.println("Eigen values:\n" + new Matrix(R.getEigenvalues()) + "\n");
            System.out.println("Eigen Vectors:\n" + R.getEigenVectorsAsMatrix() + "\n");
        }
    }
}
