package ru.boost;

public class JavaLab1830 {

    public static boolean isBracketsAreCorrect(String input){
        int number = 0;
        for(char letter : input.toCharArray()){
            if(letter == '('){
                number++;
            }
            else if(letter == ')'){
                number--;
                if(number < 0){
                    return false;
                }
            }
        }
        return number == 0;
    }

    public static void main(String[] args) {

    }
}
