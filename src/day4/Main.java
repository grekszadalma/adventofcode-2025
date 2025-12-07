package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            File file = new File("src/day4/input.txt");
            Scanner sc = new Scanner(file);

            List<String> lines = new ArrayList<>();
            while(sc.hasNext()) {
                lines.add(sc.nextLine());
            }

            System.out.println(countAdjacentRolls(lines, 2, 2));

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }

    static int countRemovedRolls(List<String> lines) {
        /*if (i == 0) {
            if (j == 0) {

            }
        }*/
        return 0;
    }

    static int countAdjacentRolls(List<String> lines, int i, int j) { //i est la ligne, j est la colonne

        int counter = 0;
        if(lines.get(i).charAt(j) == '@') {
            counter--;
        }

        int n = i - 1;
        while (n <= i + 1) {
            int m = j - 1;
            while (m <= j + 1) {
                System.out.println(lines.get(n).charAt(m));
                if (lines.get(n).charAt(m) == '@') {
                    counter++;
                }
                m++;
            }
            n++;
        }

        return counter;

    }
}
