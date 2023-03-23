/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.boost.javalab1329;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author borisost
 */
public class JavaLab1329Tests {
    @Test
    public void test0() {
        String input = "";
        int expectedWordCount = 0;
        int expectedLetterCount = 0;

        JavaLab1329.LettersAndWorlds counter = JavaLab1329.getNumberOfLettersAndWorlds(input);
        
        assertEquals(expectedLetterCount, counter.getLettersNumber());
        assertEquals(expectedWordCount, counter.getWordsNumber());
    }
    
    @Test
    public void test1() {
        String input = "    xxx,    xx x   x";
        int expectedWordCount = 4;
        int expectedLetterCount = 7;

        JavaLab1329.LettersAndWorlds counter = JavaLab1329.getNumberOfLettersAndWorlds(input);
        
        assertEquals(expectedLetterCount, counter.getLettersNumber());
        assertEquals(expectedWordCount, counter.getWordsNumber());
    }
    
    @Test
    public void test2() {
        String input = "xxxxxxx";
        int expectedWordCount = 1;
        int expectedLetterCount = 7;

        JavaLab1329.LettersAndWorlds counter = JavaLab1329.getNumberOfLettersAndWorlds(input);
        
        assertEquals(expectedLetterCount, counter.getLettersNumber());
        assertEquals(expectedWordCount, counter.getWordsNumber());
    }
    
    @Test
    public void test3() {
        String input = "xxxxxxx.    ";
        int expectedWordCount = 1;
        int expectedLetterCount = 7;

        JavaLab1329.LettersAndWorlds counter = JavaLab1329.getNumberOfLettersAndWorlds(input);
        
        assertEquals(expectedLetterCount, counter.getLettersNumber());
        assertEquals(expectedWordCount, counter.getWordsNumber());
    }
    
    @Test
    public void test4() {
        String input = "xxx,xxxx";
        int expectedWordCount = 2;
        int expectedLetterCount = 7;

        JavaLab1329.LettersAndWorlds counter = JavaLab1329.getNumberOfLettersAndWorlds(input);
        
        assertEquals(expectedLetterCount, counter.getLettersNumber());
        assertEquals(expectedWordCount, counter.getWordsNumber());
    }
    
    @Test
    public void test5() {
        String input = "xxx.xxxx";
        int expectedWordCount = 2;
        int expectedLetterCount = 7;

        JavaLab1329.LettersAndWorlds counter = JavaLab1329.getNumberOfLettersAndWorlds(input);
        
        assertEquals(expectedLetterCount, counter.getLettersNumber());
        assertEquals(expectedWordCount, counter.getWordsNumber());
    }
    
    @Test
    public void test6() {
        String input = "........";
        int expectedWordCount = 0;
        int expectedLetterCount = 0;

        JavaLab1329.LettersAndWorlds counter = JavaLab1329.getNumberOfLettersAndWorlds(input);
        
        assertEquals(expectedLetterCount, counter.getLettersNumber());
        assertEquals(expectedWordCount, counter.getWordsNumber());
    }
    
    @Test
    public void test7() {
        String input = "... xxx...  ";
        int expectedWordCount = 1;
        int expectedLetterCount = 3;

        JavaLab1329.LettersAndWorlds counter = JavaLab1329.getNumberOfLettersAndWorlds(input);
        
        assertEquals(expectedLetterCount, counter.getLettersNumber());
        assertEquals(expectedWordCount, counter.getWordsNumber());
    }
}
