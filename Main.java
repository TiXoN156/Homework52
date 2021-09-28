package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "C://string.txt";
        String readFile = readFileToString(fileName);
        String[] arrayOfStrings = splitStringToArrayOfStrings(readFile);
        SplittedParameters[] arrayOfObjects = new SplittedParameters[arrayOfStrings.length];
        splitIntoObjects(arrayOfStrings, arrayOfObjects);

        printObjects(arrayOfObjects);

    }

    private static void printObjects(SplittedParameters[] arrayOfObjects) {
        for (int i = 0; i < arrayOfObjects.length; i++) {
            System.out.println(String.format("Имя: %s, значение: %s", arrayOfObjects[i].getName(),
                    arrayOfObjects[i].getValue()));
        }
    }

    private static void splitIntoObjects(String[] arrayOfStrings, SplittedParameters[] arrayResult) {
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = new SplittedParameters(splitStringToName(arrayOfStrings[i]),
                    splitStringToValue(arrayOfStrings[i]));
        }
    }

    private static String[] splitStringToArrayOfStrings(String contentRaw) {
        String contentClear = contentRaw.replaceAll("[{}]", "");
        String[] arrayRaw = contentClear.split(",\\n");
        return arrayRaw;
    }

    public static String readFileToString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static String splitStringToName(String string) {
        String[] array = string.split(": ");
        String temp = array[0].trim();
        String name = temp.replaceAll("\"", "");
        return name;
    }

    public static String splitStringToValue(String string) {
        String[] array = string.split(": ");
        String temp = array[1].trim();
        String value = temp.replaceAll("\"", "");
        return value;
    }
}
