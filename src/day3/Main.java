package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // une liste de long
        // premierement, je cherche le max
        // je note son indice et je cherche le second max apres le premier max a partir de l'indice
        // je calcule la somme

        int sum = 0;

        try {
            File file = new File("src/day3/input.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                sum += calculateVoltage(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println(sum);
    }

    static int calculateVoltagePart2(String line) {
        int maxIndice = 0;
        int maxNumber = 0;

        List<MaxValue> maxValues = new ArrayList<>(12);
        Set<Integer> savedIndices = new HashSet<>();

        while (maxValues.size() < 12) {

            for (int i = 0; i < line.length(); i++) {
                int number = Integer.parseInt(Character.toString(line.charAt(i)));
                if(!savedIndices.contains(i) && number >= maxNumber) {
                    maxNumber = number;
                    maxIndice = i;
                }
            }
            savedIndices.add(maxIndice);
            maxValues.add(new MaxValue(maxNumber,maxIndice));
        }
        maxValues.sort(Comparator.comparingInt(MaxValue::getPosition));

        return 0;
    }

    static int calculateVoltage(String line) {
        int maxIndice = 0;
        int maxNumber = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length() - 1; i++) {
            int number = Integer.parseInt(Character.toString(line.charAt(i)));
            if (number > maxNumber) {
                maxNumber = number;
                maxIndice = i;
            }
        }
        sb.append(String.valueOf(maxNumber));

        maxNumber = 0;
        for (int i = maxIndice + 1; i < line.length(); i++) {
            int number = Integer.parseInt(Character.toString(line.charAt(i)));
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        sb.append(String.valueOf(maxNumber));

        return Integer.parseInt(sb.toString());
    }

    static class MaxValue {

        public int value;
        public int position;

        public MaxValue(int value, int position) {
            this.value = value;
            this.position = position;
        }

        public int getValue() { return value; }
        public int getPosition() { return position; }
    }
}
