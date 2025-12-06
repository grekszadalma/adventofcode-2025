package day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IdValidator {

    private long start;
    private long end;

    private long sumInvalidIds;
    private long sumInvalidIdsPart2;

    public IdValidator(String start, String end) {
        this.start = Long.parseLong(start);
        this.end = Long.parseLong(end);

        calculateSumInvalidIds();
        calculateSumInvalidIdsPart2();
    }

    private void calculateSumInvalidIds() {
        long sum = 0;

        int subStringLength = String.valueOf(end).length() / 2;

        for (long id = start; id <= end; id++) {
            String idString = String.valueOf(id);
            if (idString.length() % 2 == 0) {
                String firstHalf = idString.substring(0,subStringLength);
                String secondHalf = idString.substring(subStringLength);
                if (firstHalf.equals(secondHalf)) {
                    sum += id;
                }
            }
        }

        sumInvalidIds = sum;
    }

    private void calculateSumInvalidIdsPart2() {
        long sum = 0;
        for (long id = start; id <= end; id++) {
            if (isInvalidId(id)) {
                sum += id;
            }
        }
        sumInvalidIdsPart2 = sum;
    }



    private boolean isInvalidId(long id) {
        String idString = String.valueOf(id);
        int idhalfLength = idString.length() / 2;

        for (int p = 1; p <= idhalfLength; p++) {
            if (idString.length() % p != 0) continue;

            String pattern = idString.substring(0,p);

            StringBuilder sb = new StringBuilder();
            int repeat = idString.length() / p;
            for (int i = 0; i < repeat; i++) {
                sb.append(pattern);
            }

            if(sb.toString().equals(idString)) {
                return true;
            }
        }
        return false;
    }



    public long getSumInvalidIds() {

        return sumInvalidIds;
    }

    public long getSumInvalidIdsPart2() {

        return sumInvalidIdsPart2;
    }
}
