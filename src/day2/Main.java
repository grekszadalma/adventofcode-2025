package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<IdValidator> idValidators = new ArrayList<>();

        long sumInvalidIds = 0;
        long secondSumInvalidIds = 0;

        try {
            File file = new File("src/day2/input2.txt");
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            sc.close();

            String[] ranges = line.split(",");

            for (String range : ranges) {
                String[] parts = range.split("-");
                String start = parts[0];
                String end = parts[1];
                idValidators.add(new IdValidator(start, end));
            }

            for (IdValidator idv : idValidators) {
                sumInvalidIds += idv.getSumInvalidIds();
                secondSumInvalidIds += idv.getSumInvalidIdsPart2();
            }

            System.out.println(sumInvalidIds);
            System.out.println(secondSumInvalidIds);

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }
    }
}
