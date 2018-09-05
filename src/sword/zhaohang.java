package sword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class zhaohang {

    static class node{
        int val;
        node next;
        node(int v,node n){
            val = v;
            next = n;
        }
    }


    public static ArrayList safe(int nodes_num,int edges_num,HashMap<Integer,Integer> edge){
        ArrayList res = new ArrayList();
        ArrayList<node> nodeLinkedList = new ArrayList<>();
        for (int i = 0;i<nodes_num;i++){

            node a = new node(i,null);
            while (edge.containsKey(i)){

            }
            int b=-999;
            for (int j = 0; j < edges_num ; j++) {
//                int[] e = edge.get(j);
//                if (e[0] == i) b = e[1];
            }
            if (b!=-999){
                a.next = new node(b,null);
            }
        }
return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes_num = in.nextInt();
        int edges_num = in.nextInt();
        HashMap<Integer,Integer> edge = new HashMap<>();
        for (int i = 0; i < edges_num; i++) {
            String e = in.next();
            String[] ee = e.split(",");
            edge.put(Integer.parseInt(ee[0]), Integer.parseInt(ee[1]));
        }
    }


}
