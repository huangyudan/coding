package sword;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Two {

    public static void help(int input, Vector<Vector<Integer>> result, Vector<Integer> temp, int ls, int lm) {
        if (ls == input) {
            result.add(temp);
            return ;
        }
        else if (ls > input) {
            return;
        }
        int tm = lm, ts = ls;
        lm = ls;
        ls *= 2;
        temp.add(1);
        help(input, result, temp, ls, lm);
        temp.remove(temp.size()-1);
        ls = tm;
        ls = ts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "a";
        String m = "a";
        int input, output = 0;
        input = in.nextInt();
        int ls = 1, lm = 1;
        Vector<Vector<Integer>> result = new Vector<>();
        Vector<Integer> temp = new Vector<>();
        help(input, result, temp, ls, lm);
        Collections.sort(result, new Comparator<Vector<Integer>>() {
            @Override
            public int compare(Vector<Integer> o1, Vector<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        if (result.size() > 0) {
            output = result.elementAt(0).size();
        }
        System.out.println(output);
    }
}
