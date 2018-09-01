package interview;

import java.util.*;

public class bittiger_02_给一个字典组成字符串的所有可能 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new LinkedList<>();
        List<String> one_answer_before = new LinkedList<>();
        DFS(s, wordDict, result,one_answer_before);
        return result;

//        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }


    public static void DFS(String input,List<String> dict , List<String> result , List<String> answer){
        if (input.length()==0) {
            result.add(answer.toString());
        }
        for (int i = 1; i <= input.length(); i++) {
            String keyword = input.substring(0,i);
            if (dict.contains(keyword)){
                answer.add(keyword);
                DFS(input.substring(i),dict,result,answer);
                answer.remove(answer.size()-1);
            }

        }
    }

    // DFS function returns an array including all substrings derived from s.
//    public static List<String>  DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
//        if (map.containsKey(s))
//            return map.get(s);
//
//        LinkedList<String>res = new LinkedList<String>();
//        if (s.length() == 0) {
//            res.add("");
//            return res;
//        }
//        for (String word : wordDict) {
//            if (s.startsWith(word)) {
//                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
//                for (String sub : sublist)
//                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
//            }
//        }
//        map.put(s, res);
//        return res;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dict_line = sc.nextLine();
        List<String> dict = Arrays.asList(dict_line.split(","));
        String input = sc.nextLine();
        List<String> result = wordBreak(input,dict);
        for (String s : result){
            System.out.println(s);
        }
    }
}
