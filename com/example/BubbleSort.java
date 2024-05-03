package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Change me.
 *
 * @author Christopher Di Bert
 * @version 1.0
 * @since 2024-05-03
 */

// BubbleSort class
public final class BubbleSort {

  /** Private constructor to prevent instantiation. */
  private BubbleSort() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    File readFile =
        new File(
            "/home/vscode/ICS4U/Unit4/Unit4-01/Unit4-01-Java-BubbleSort/com/example/input.txt");
    try {
      FileWriter fileWriter =
          new FileWriter(
              "/home/vscode/ICS4U/Unit4/Unit4-01/Unit4-01-Java-BubbleSort/com/example/output.txt");
      BufferedWriter writer = new BufferedWriter(fileWriter);
      Scanner sc = new Scanner(readFile);
      while (sc.hasNextLine()) {
        // Gets input lines.
        String inputElements = sc.nextLine();
        try {
          // Sets line to an array delimited by spaces.
          String[] lineArr = inputElements.split(" ");
          // Casts from string to int stream.
          IntStream ints = Arrays.stream(lineArr).mapToInt(Integer::parseInt);
          // Converts int stream to int array.
          int[] intArr = ints.toArray();
          // Writes the sorted array to the output file.
          writer.write(Arrays.toString(BubbleSorter(intArr)));
          // Exception thrown if the user didn't enter valid input.
        } catch (Exception e) {
          writer.write("Can only enter space-separated integers!");
        }
        writer.newLine();
      }
      writer.close();
      sc.close();
    } catch (Exception e) {
      System.out.println("Invalid path");
    }
  }

  /**
   * Bubble sort function.
   *
   * @param arr
   * @return
   */
  private static int[] BubbleSorter(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        /*
         * Swap the numbers in the array if the the first
         * element is less than the next.
         */
        if (arr[i] < arr[j]) {
          int tempNum = arr[j];
          arr[j] = arr[i];
          arr[i] = tempNum;
        }
      }
    }
    return arr;
  }
}
