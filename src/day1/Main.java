package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> inputs = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("src/day1/input.txt"));
            while (sc.hasNextLine()) {
                inputs.add(sc.nextLine());
            }
            sc.close();

            int countExactZeros = 0;
            int countClickZeros = 0;
            int position = 50;

            for (String input : inputs) {
                char direction = input.charAt(0);
                int rotation = Integer.parseInt(input.substring(1));
                countClickZeros += rotation / 100;
                rotation = rotation % 100;

                if (direction == 'L') {
                    //0-1
                    if (position == 0) {
                        countClickZeros--;
                    }
                    position = position - rotation;
                    if (position < 0) {
                        countClickZeros++;
                        position = 100 + position;
                    }
                    if (position == 0) {
                        countExactZeros++;
                    }
                    //System.out.println(position + " : click zeros : "+countClickZeros+" exactzeros : "+countExactZeros);
                } else {
                    //50 + 68 = 118
                    if (position == 100) {
                        countClickZeros--;
                    }
                    position = position + rotation;
                    if (position > 100) {
                        countClickZeros++;
                        position = position - 100;
                    }
                    if (position == 100) {
                        countExactZeros++;
                    }
                    //System.out.println(position + " : click zeros : "+countClickZeros+" exactzeros : "+countExactZeros);

                }

            }

            System.out.println(countExactZeros + countClickZeros);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
