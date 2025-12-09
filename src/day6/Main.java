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

            numbers = sortToColumnsNumbers(numbers);
            signs = sortToColumnsChars(signs);
            for (List<Character> signlist : signs) {
                for (Character ch : signlist) {
                    System.out.println(ch);
                }

            }

            long res = sumAllPart1(numbers,signs);
            System.out.println(res);


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

    static long sumAllPart1(List<List<Integer>> numbers, List<List<Character>> signs) {
        long sum = 0;
        int lengthLine = numbers.get(0).size();


        int lengthSigns = signs.size();
        int lengthNumbers = numbers.size();

        int j = 0;
        System.out.println(signs.size());

        for (int i = 0; i < lengthSigns; i++) {
            if (signs.get(i).get(0) == '+') {
                long sumColumn = 0;
                for(Integer k : numbers.get(j)) {
                    sumColumn += k;
                }
                j++;
                sum += sumColumn;
            }
            if (signs.get(i).get(0) == '*') {
                long prodColumn = 1;
                for(Integer k : numbers.get(j)) {
                    prodColumn *= k;
                }
                j++;
                sum += prodColumn;
            }

        }


        return sum;
    }

    static List<List<Integer>> sortToColumnsNumbers(List<List<Integer>> numbers) {
        int n = numbers.size(); // la taille des colonnes
        int m = numbers.get(0).size(); // le nombre des colonnes

        List<List<Integer>> sorted = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> columns = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                columns.add(numbers.get(j).get(i));
            }

            sorted.add(columns);
        }

        return sorted;
    }

    static List<List<Character>> sortToColumnsChars(List<List<Character>> signs) {

        int n = signs.size(); // la taille des colonnes
        int m = signs.get(0).size(); // le nombre des colonnes

        List<List<Character>> sorted = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Character> columns = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                columns.add(signs.get(j).get(i));
            }

            sorted.add(columns);
        }

        return sorted;
    }


}
