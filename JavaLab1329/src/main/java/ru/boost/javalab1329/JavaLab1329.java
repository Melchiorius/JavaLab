/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ru.boost.javalab1329;

/**
 *
 * @author borisost
 */
public class JavaLab1329 {
    
    public static class LettersAndWorlds{
        private int lettersNumber = 0;
        private int wordsNumber = 0;

        public int getLettersNumber() {
            return lettersNumber;
        }

        public void setLettersNumber(int lettersNumber) {
            this.lettersNumber = lettersNumber;
        }

        public int getWordsNumber() {
            return wordsNumber;
        }

        public void setWordsNumber(int wordsNumber) {
            this.wordsNumber = wordsNumber;
        }
        
        public void addWord(){
            wordsNumber++;
        }
        
        public void addLetter(){
            lettersNumber++;
        }
        
    }
    
    public static LettersAndWorlds getNumberOfLettersAndWorlds(String input){
        LettersAndWorlds number = new LettersAndWorlds();
        boolean inWord = false;
        for(char letter : input.toCharArray()){
            if(Character.isLetter(letter)){
                number.addLetter();
                inWord = true;
            }
            else{
                if(inWord){
                    number.addWord();
                }
                inWord = false;
            }
        }
        if(inWord){
            number.addWord();
        }
        return number;
    }
    
    public static void main(String[] args){
        
    }

}
