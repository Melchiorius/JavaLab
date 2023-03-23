package ru.boost;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JavaLab1830Test {

    @Test
    public void test0() {
        String input = "()()()";
        boolean expectedAnswer = true;
        assertEquals(expectedAnswer, JavaLab1830.isBracketsAreCorrect(input));
    }

    @Test
    public void test1() {
        String input = "()(())";
        boolean expectedAnswer = true;
        assertEquals(expectedAnswer, JavaLab1830.isBracketsAreCorrect(input));
    }

    @Test
    public void test2() {
        String input = ")(";
        boolean expectedAnswer = false;
        assertEquals(expectedAnswer, JavaLab1830.isBracketsAreCorrect(input));
    }

    @Test
    public void test3() {
        String input = "(()())";
        boolean expectedAnswer = true;
        assertEquals(expectedAnswer, JavaLab1830.isBracketsAreCorrect(input));
    }

    @Test
    public void test4() {
        String input = "";
        boolean expectedAnswer = true;
        assertEquals(expectedAnswer, JavaLab1830.isBracketsAreCorrect(input));
    }

    @Test
    public void test5() {
        String input = "((())";
        boolean expectedAnswer = false;
        assertEquals(expectedAnswer, JavaLab1830.isBracketsAreCorrect(input));
    }

    @Test
    public void test6() {
        String input = "(()))";
        boolean expectedAnswer = false;
        assertEquals(expectedAnswer, JavaLab1830.isBracketsAreCorrect(input));
    }

    @Test
    public void test7() {
        String input = "( () )) (( () )";
        boolean expectedAnswer = false;
        assertEquals(expectedAnswer, JavaLab1830.isBracketsAreCorrect(input));
    }
}
