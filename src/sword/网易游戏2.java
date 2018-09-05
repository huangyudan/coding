package sword;

import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

public class 网易游戏2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String problem = in.nextLine();
        String[] a;
        boolean plus = true;
        if (problem.contains("+")){
            a = problem.split("\\+");
        }else{
            plus = false;
            a = problem.split("\\-");
        }
        String first = a[0];
        String[] b = a[1].split("=");
        String second = b[0];
        String result = b[1];
        //12A+BB4=239 AAB-B33=B51
        Set<Character> s = new HashSet();
        for (int i = 0; i < first.length(); i++) {
            Character c = first.charAt(i);
            if (Character.isLetter(c) && !s.contains(c)){
                s.add(c);
            }
        }
        for (int i = 0; i < second.length(); i++) {
            Character c = second.charAt(i);
            if (Character.isLetter(c)&& !s.contains(c)){
                s.add(c);
            }
        }
        for (int i = 0; i < result.length(); i++) {
            Character c = result.charAt(i);
            if (Character.isLetter(c)&& !s.contains(c)){
                s.add(c);
            }
        }
        List<Character> sortedlist = new ArrayList<>();
        sortedlist.addAll(s);
        Collections.sort(sortedlist);
        int size = sortedlist.size();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <size ; i++) {
            builder.append('9');
        }
        StringBuilder first1,second1,result1;
        int maxNumber = parseInt(builder.toString());
        for (int i = 0; i < maxNumber; i++) {
            first1 = new StringBuilder(first);
            second1 = new StringBuilder(second);
            result1 = new StringBuilder(result);
            String num = String.format("%0"+size+"d",i);
            for (int j = 0; j < first1.length() ; j++) {
                char x = first1.charAt(j);
                if (Character.isLetter(x)){
                    int index = sortedlist.indexOf(x);
                    char to_replace  = num.charAt(index);
                    first1.setCharAt(j,to_replace);
                }
            }
            String one = String.valueOf(first1);
            for (int j = 0; j < second1.length(); j++) {
                char x = second1.charAt(j);
                if (Character.isLetter(x)){
                    int index = sortedlist.indexOf(x);
                    char to_replace  = num.charAt(index);
                    second1.setCharAt(j,to_replace);
                }
            }
            String two = String.valueOf(second1);
            for (int j = 0; j < result1.length() ; j++) {
                char x = result1.charAt(j);
                if (Character.isLetter(x)){
                    int index = sortedlist.indexOf(x);
                    char to_replace  = num.charAt(index);
                    result1.setCharAt(j,to_replace);
                }
            }
            String three = result1.toString();//String.valueOf(result1);
            int true_result;
            if (plus){
                true_result = Integer.parseInt(one)+Integer.parseInt(two);
            }else {
                true_result = Integer.parseInt(one)-Integer.parseInt(two);
            }
            if ( true_result == Integer.parseInt(three)){
                for (int x = 0; x < sortedlist.size(); x++) {
                    System.out.println(sortedlist.get(x)+" "+Integer.toString(i).charAt(x));
                }

            }

        }




    }
}
