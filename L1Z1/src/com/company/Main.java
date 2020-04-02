package com.company;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }

    public static void main(String[] args) throws Exception {

        HashMap<Character, Integer> letterMap = new HashMap<>();
        File file = new File("C:\\Users\\fedo\\Documents\\plik.txt");
        Scanner sc = new Scanner(file, "utf-8");
        double numOfLetters = 0;
        double entropy = 0;

        while (sc.hasNext()) {
            char[] text = sc.nextLine().toLowerCase().toCharArray();

            for (Character c : text) {
                if (!Character.isLetter(c)) {
                    continue;
                }
                if (letterMap.containsKey(c)) {
                    letterMap.put(c, letterMap.get(c) + 1);
                    numOfLetters++;
                } else {
                    letterMap.put(c, 1);
                    numOfLetters++;
                }
            }
        }

        for (HashMap.Entry<Character, Integer> key : letterMap.entrySet()) {
            System.out.println(key.getKey() + ": " + key.getValue());
            double prop = key.getValue() / numOfLetters;
            entropy -= (prop * customLog(2, prop));
        }
        System.out.println("Entropia pliku: " + entropy);
    }

}
