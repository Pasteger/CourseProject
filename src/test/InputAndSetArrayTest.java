package test;

import org.junit.Assert;
import org.junit.Test;
import sample.Controller;

public class InputAndSetArrayTest {
    int[] correctArray = new int[10];
    int[] incorrectArray = new int[5];
    @Test
    public void preArrayIsCorrect() {
        String result = Controller.inputArray("1 2 3 4 5 6 7 8 9 0", correctArray, 1);
        Assert.assertNotEquals("Ввод неверен", result);
    }
    @Test
    public void preArrayIsIncorrect() {
        String result = Controller.inputArray("a s 3 4 5 6 r e w q", correctArray, 1);
        Assert.assertEquals("Ввод неверен", result);
    }
    @Test
    public void arrayIsIncorrect() {
        String result = Controller.inputArray("1 2 3 4 5 6 7 8 9 0", incorrectArray, 1);
        Assert.assertEquals("Ввод неверен", result);
    }
}
