package com.astralplanelabs.eulerproject.problems;

import java.util.Set;
import java.util.HashSet;

/**
 * User: jtempleton
 */
public class Problem26J {

    public static void main(String[] args) {

        int max = 0;
        int maxd = 0;
        for (int d = 2; d < 1000; ++d)
        {
            Set reminders = new HashSet<Integer>();
            int x = 1;
            int len = 0;
            while (x < d)
                x *= 10;

            while (x != 0)
            {
                if (reminders.contains(x))
                    break;

                reminders.add(x);

                while (x < d)
                {
                    x *= 10;
                    len++;
                }
                x = x%d;
            }
            if (x != 0)
            {
                if (len > max)
                {
                    maxd = d;
                    max = len;
                }
            }
        } // for
        System.out.println(maxd);
    } // main

}