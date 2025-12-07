package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            File file = new File("src/day5/input.txt");
            Scanner sc = new Scanner(file);
            List<long[]> freshIntervals = new ArrayList<>();
            List<Long> ingredients = new ArrayList<>();
            boolean split = false;

            while(sc.hasNext()) {
                String line = sc.nextLine();
                if (line.isEmpty()) {
                    split = true;
                    continue;
                }
                if (split) {
                    long ingredient = Long.parseLong(line);
                    ingredients.add(ingredient);
                } else {
                    String[] strInterval = line.split("-");
                    long[] interval = new long[2];
                    interval[0] = Long.parseLong(strInterval[0]);
                    interval[1] = Long.parseLong(strInterval[1]);
                    freshIntervals.add(interval);
                }
            }
            System.out.println(countFresh(freshIntervals, ingredients));
            

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    static int countFresh(List<long[]> freshIntervals, List<Long> ingredients) {

        int counter = 0;

        for (Long ingredient : ingredients) {
            boolean found = false;
            for (long[] interval : freshIntervals) {
                if (ingredient >= interval[0] && ingredient <= interval[1]) {
                    found = true;
                    counter++;
                }
                if(found) {
                    break;
                }
            }
        }

        return counter;
    }
}
