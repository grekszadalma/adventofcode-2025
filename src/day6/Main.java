package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> numbers = new ArrayList<>();
        List<List<Character>> signs = new ArrayList<>();

        try {
            File file = new File("src/day6/input.txt");
            Scanner sc = new Scanner(file);

            while(sc.hasNext()) {
                String line = sc.nextLine();
                boolean isLineSign = isSign(line.charAt(0));
                if (isLineSign) {
                    String[] strSigns = line.split(" ");

                    List<Character> signsLine = new ArrayList<>();
                    for (String sign : strSigns) {
                        if (!sign.isEmpty()) {
                            String ch = sign.trim();
                            signsLine.add(ch.charAt(0));
                        }

                    }
                    signs.add(signsLine);

                } else {
                    String[] strNumbers = line.split(" ");

                    List<Integer> numbersLine = new ArrayList<>();
                    for (String number : strNumbers) {
                        //System.out.println(number);
                        if (!number.isEmpty()) {
                            int num = Integer.parseInt(number.trim());
                            numbersLine.add(num);
                        }

                    }
                    numbers.add(numbersLine);
                }

            }



        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }

    static boolean isSign(char ch) {
        if (ch == '+' || ch == '*') {
            return true;
        }

        return false;
    }

    static long sumAll(List<List<Integer>> numbers, List<List<Character>> signs) {
        long sum = 0;

        int lengthLine = numbers.get(0).size();
        if (lengthLine != signs.size()) {
            System.out.println("Invalid");
            return 0;
        }

        int lengthNums = numbers.size();

        int i = 0;


        while(i < lengthLine) {
            int j = 0;
            if (signs.get(i) == '*')

        }


        return sum;
    }

    static List<List<Integer>> sortToColumns(List<List<Integer>> numbers) {
        int n = numbers.size();
        int m = numbers.get(0).size();

        List<List<Integer>> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> column = new ArrayList<>(n);

            for (int j = 0; j < m; j++) {

            }
        }


    }


}
