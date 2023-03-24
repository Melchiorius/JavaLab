package ru.boost;

import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;

import java.text.DecimalFormat;

public class Matrix {
    private final static DecimalFormat df = new DecimalFormat("#.######");
    private int n;
    private int m;

    double[][] values;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        values = new double[n][m];
    }

    public Matrix(double values[][]) {
        this.n = values.length;
        this.m = values[0].length;
        this.values = values;
    }

    public Matrix(double values[]) {
        this.n = 1;
        this.m = values.length;
        this.values = new double[1][m];
        this.values[0] = values;
    }

    public String toString(){
        String text = "";
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.m;j++){
                String value = df.format(this.values[i][j]);
                if(value.equals("-0")){ value = "0"; }
                text += value + "\t";
            }
            text = text.substring(0,text.length()-1);
            text += "\n";
        }
        text = text.substring(0,text.length()-1);
        return text;
    }

    public Matrix fillRandom(int min, int max){
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.m;j++){
                this.values[i][j] = (int)(min+Math.random()*(max-min));
            }
        }
        return this;
    }

    public Matrix fillSingle(){
        for(int i=0;i<this.n;i++){
            this.values[i][i] = 1;
        }
        return this;
    }

    public boolean setValue(int n,int m, double value){
        if(this.n <= n || this.m <= m){
            return false;
        }
        values[n][m] = value;
        return true;
    }

    public boolean setLine(int n, double[] values){
        if(this.n <= n || values.length != this.m){
            return false;
        }
        this.values[n] = values.clone();
        return true;
    }

    public boolean setColumn(int m, double[] values){
        if(this.m <= m || values.length != this.n){
            return false;
        }
        for(int i=0;i<n;i++){
            this.values[i][m] = values[i];
        }
        return true;
    }

    private double crossProduct(double[] V1,double[] V2){
        double product = 0;
        for(int i=0;i<V1.length;i++){
            product+=V1[i]*V2[i];
        }
        return product;
    }

    public double getValue(int n,int m){
        if(this.n <= n || this.m <= m){
            return 0;
        }
        return values[n][m];
    }

    public double[] getLine(int n){
        if(this.n <= n){
            return null;
        }
        return values[n].clone();
    }

    public double[] getColumn(int m){
        if(this.m <= m){
            return null;
        }
        double[] column = new double[this.n];
        for(int i=0;i<this.n;i++){
            column[i] = values[i][m];
        }
        return column;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public Matrix add(Matrix other){
        if(getN() != other.getN() || getM() != other.getM()){
            return null;
        }
        Matrix result = new Matrix(getN(),getM());
        for(int i=0;i<getN();i++){
            for(int j=0;j<getM();j++){
                result.setValue(i,j,getValue(i,j)+other.getValue(i,j));
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other){
        if(getM() != other.getN()){
            return null;
        }
        Matrix result = new Matrix(getN(),other.getM());
        for(int i=0;i<result.getN();i++){
            for(int j=0;j<result.getM();j++){
                result.setValue(i,j,crossProduct(getLine(i),other.getColumn(j)));
            }
        }
        return result;
    }

    public Matrix multiply(double mod){
        Matrix result = new Matrix(this.n,this.m);
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.m;j++){
                result.setValue(i,j,mod*getValue(i,j));
            }
        }
        return result;
    }

    public Matrix transpose(){
        Matrix transpose = new Matrix(m,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                transpose.setValue(j,i,getValue(i,j));
            }
        }
        return transpose;
    }

    private Matrix getMatrixOfAlgebraicAdditions(){
        Matrix matrix = new Matrix(this.n,this.m);
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.m;j++){
                int mod = (i%2==0?1:-1)*((j)%2==0?1:-1);
                matrix.setValue(i,j,mod*getMinorMatrix(i,j).getDeterminant());
            }
        }
        return matrix;
    }

    private Matrix getMinorMatrix(int n,int m){
        Matrix minor = new Matrix(this.n-1,this.m-1);
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.m;j++){
                if(i==n || j==m){
                    continue;
                }
                minor.setValue(i<n?i:i-1,j<m?j:j-1,getValue(i,j));
            }
        }

        return minor;
    }

    private double getDiagonalPowerSum(boolean opposit){
        double sum = 0;
        for(int j=0;j<this.m;j++){
            double value = 1;
            for(int i=0;i<this.n;i++){
                int indexJ = j+i;
                if(opposit){ indexJ = (this.m-1) - indexJ; }
                if(indexJ>=this.m){ indexJ -= this.m; }
                if(indexJ<0){ indexJ += this.m; }
                double V = getValue(i,indexJ);
                value *= V;
            }
            sum += value;
        }

        return sum;
    }

    public double getDeterminant(){
        if(n!=m){
            return 0;
        }
        if(n == 2){
            return getValue(0,0)*getValue(1,1) - getValue(0,1)*getValue(1,0);
        }
        return getDiagonalPowerSum(false) - getDiagonalPowerSum(true);
    }

    public Matrix getInverseMatrix(){
        double D = getDeterminant();
        if(D == 0){ return null; }
        return getMatrixOfAlgebraicAdditions().transpose().multiply(1/D);
    }

    public double[] getEigenvalues(){
        return new EigenDecomposition(MatrixUtils.createRealMatrix(values)).getRealEigenvalues();
    }

    public double[][] getRealEigenVectors(){
        return new EigenDecomposition(MatrixUtils.createRealMatrix(values)).getV().getData();
    }

    public Matrix getEigenVectorsAsMatrix(){
        return new Matrix(new EigenDecomposition(MatrixUtils.createRealMatrix(values)).getV().getData());
    }
}
