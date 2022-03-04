package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Controller {
    String preArray1;
    String preArray2;
    static int[] firstArray = new int[10];
    static int[] secondArray = new int[10];
    static ArrayList<Integer> commonArray = new ArrayList<>();
    static boolean firstArrayFill = false;
    static boolean secondArrayFill = false;
    @FXML private Button buttonBubbleSort;
    @FXML private Button buttonForMergeArrays;
    @FXML private Button buttonInsertionSort;
    @FXML private Button buttonEnter1;
    @FXML private Button buttonEnter2;
    @FXML private Label labelForArray1;
    @FXML private Label labelForArray2;
    @FXML private Label labelMergedArray;
    @FXML private TextField textFieldForArray1;
    @FXML private TextField textFieldForArray2;

    @FXML
    void initialize() {

        labelForArray1.setText("Введите массив");
        labelForArray2.setText("Введите массив");

        buttonEnter1.setOnAction(actionEvent -> {
            preArray1 = textFieldForArray1.getText();
            String result = inputArray(preArray1, firstArray, 1);
            labelForArray1.setText(result);
        });

        buttonEnter2.setOnAction(actionEvent -> {
            preArray2 = textFieldForArray2.getText();
            String result = inputArray(preArray2, secondArray, 2);
            labelForArray2.setText(result);
        });

        buttonBubbleSort.setOnAction(actionEvent -> {
            bubbleSort(firstArray);
            if(firstArrayFill){
                String result = Arrays.toString(firstArray);
                result = result.substring(1, result.length()-1).replaceAll(",", "");
                labelForArray1.setText(result);
            }
        });

        buttonInsertionSort.setOnAction(actionEvent -> {
            insertionSort(secondArray);
            if(secondArrayFill){
                String result = Arrays.toString(secondArray);
                result = result.substring(1, result.length()-1).replaceAll(",", "");
                labelForArray2.setText(result);
            }
        });

        buttonForMergeArrays.setOnAction(actionEvent -> {
            String result = mergeArrays(firstArrayFill, secondArrayFill);
            result = result.replaceAll(",", "");
            labelMergedArray.setText(result);
        });
    }

    public static String inputArray(String preArray, int[] array, int arrayID){
        boolean complete = setArray(preArray, array);
        if(!complete){
            return "Ввод неверен";
        }
        switch (arrayID) {
            case 1 -> firstArrayFill = true;
            case 2 -> secondArrayFill = true;
        }
        String result = Arrays.toString(array);
        return result.substring(1, result.length()-1).replaceAll(",", "");
    }

    public static boolean setArray(String preArray, int[] array) {
        if (preArray.length() == 19){
            try {
                String[] stringArray = preArray.split(" ");
                for(int id = 0; id < 10; id++) {
                    array[id] = parseInt(stringArray[id]);
                }
                return true;
            }
            catch (Exception exception){
                return false;
            }
        }
        return false;
    }

    public void bubbleSort(int[] array) {
        int length = array.length;
        int swap;
        boolean sorted;
        for (int index = 0; index < length; index++) {
            sorted = true;
            for (int value = 1; value < (length - index); value++) {
                if (array[value - 1] > array[value]) {
                    swap = array[value - 1];
                    array[value - 1] = array[value];
                    array[value] = swap;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    public void insertionSort(int[] array) {
        int length = array.length;
        for (int index = 1; index < length; index++) {
            int key = array[index];
            int value;
            for (value = index-1; value >= 0 && key < array[value]; value--){
                array[value+1] = array[value];
            }
            array[value+1] = key;
        }
    }

    public String mergeArrays(boolean firstArrayFill, boolean secondArrayFill){
        if (firstArrayFill & secondArrayFill){
            commonArray.clear();
            int length = 10;
            for (
        int index = 0;
        index < length;
        index++){
                if(!commonArray.contains(firstArray[index])) {
                    commonArray.add(firstArray[index]);
                }
                if(!commonArray.contains(secondArray[index])){
                    commonArray.add(secondArray[index]); }
            }
            String result = Arrays.toString(new ArrayList[]{commonArray});
            return result.substring(2, result.length()-2);
        }
        else {
            return "Нет массива";
        }
    }
}
