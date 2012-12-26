package com.astralplanelabs.eulerproject.problems;

import java.util.List;
import java.util.ArrayList;
/**
 * User: jtempleton
 */
public class Problem43J {

    protected List<Integer> primes = new ArrayList();

    public Problem43J() {
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
    }

    protected boolean isPanDigital(final Long p) {
        String numString = p + "";
        if (numString.length() != 10) return false;

        for (int i = 0; i < 10; i++) {  //i <- (new Range(0, 10, 1))) {
            if (!numString.contains("" + i))
                return false;
        }
        return true;
    }

    protected boolean groupBy3s(final Long p) {
        String numString = p + "";
        for (int i = 1; i < 8; i++) {   //i <- (new Range(1, 9, 1))) {
            String sub = numString.substring(i, i+3);
            //System.out.println("1: " + sub);
            Integer subInt = Integer.parseInt(sub);
            //System.out.println("2: " + subInt);
            if ((subInt%(primes.get(i-1))) != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Sub-String Divisibility");
        Problem43J k = new Problem43J();

        List<Long> results = new ArrayList();
        //val range = Range.Long(1000000000l, 9999999999l, 1l)
        //val range = Range.Double(1000000000d, 9999999999d, 1)

        for (Long i = 1000000000L; i < 9999999999L; i++) {
            if (k.isPanDigital(i) && k.groupBy3s(i)) {
                results.add(i);
            }
        }
        if (results.size() > 0) {
            System.out.println("Found " + results.size() + " Pan-Digital Items");
            long sum = 0;
            for (Long l : results) {
                sum += l;
            }
            System.out.println(sum);
        } else {
            System.out.println("No Pan-Digital Vals Found");
        }

    }
}
