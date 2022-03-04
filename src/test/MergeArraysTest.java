package test;

import org.junit.Assert;
import org.junit.Test;
import sample.Controller;

public class MergeArraysTest {
    Controller controller = new Controller();
    @Test
    public void arraysAreFill() {
        String result = controller.mergeArrays(true, true);
        Assert.assertNotEquals("Нет массива", result);
    }
    @Test
    public void firstArrayAreFillAndSecondArrayAreEmpty() {
        String result = controller.mergeArrays(true, false);
        Assert.assertEquals("Нет массива", result);
    }
    @Test
    public void firstArrayAreEmptyAndSecondArrayAreFill() {
        String result = controller.mergeArrays(false, true);
        Assert.assertEquals("Нет массива", result);
    }
    @Test
    public void arraysAreEmpty() {
        String result = controller.mergeArrays(false, false);
        Assert.assertEquals("Нет массива", result);
    }
}
