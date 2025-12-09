package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
            //System.out.println(countFresh(freshIntervals, ingredients));

            System.out.println(countAllFresh(freshIntervals));

            

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

    static long countAllFresh(List<long[]> freshIntervals) {

        Set<Long> ingredients = new HashSet<>();
        List<long[]> mergedIntervals = mergeIntervals(freshIntervals);

        long counter = 0;
        for (long[] interval : mergedIntervals) {
            counter += interval[1] - interval[0] + 1;
        }

        return counter;

    }

    static List<long[]> mergeIntervals(List<long[]> freshIntervals) {

        freshIntervals.sort((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        long[] prev = freshIntervals.get(0);
        List<long[]> mergedIntervals = new ArrayList<>();

        for (long[] interval : freshIntervals) {

            if (interval[0] <= prev[1]) {
                prev = new long[] {
                        prev[0],
                        Math.max(prev[1], interval[1])
                };
            } else {
                mergedIntervals.add(prev);
                prev = interval;
            }
        }

        mergedIntervals.add(prev);

        return mergedIntervals;
    }
}
