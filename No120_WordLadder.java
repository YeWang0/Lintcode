/**
 * Created by yvan on 1/18/17.
 */
import java.util.*;

public class No120_WordLadder {
    public boolean isladder(String a, String b){
        int la=a.length();

        if(la!=b.length()){
            return false;
        }else{
            int count=0;
            for(int i=0;i<la;i++){
                if(a.charAt(i)!=b.charAt(i))count++;
                if(count>1)return false;
            }
        }
        return true;
    }
    public int ladderLength(String start, String end, Set<String> dict) {
        if(!dict.contains(end))dict.add(end);
        HashSet<String> set = new HashSet<>();
        set.add(start);
        int depth=1;
        while(!set.contains(end)){
            HashSet<String> temp = new HashSet<>();
            for(String x:set){
                for(String s:dict){
                    if(isladder(x,s)){
                        temp.add(s);
                    }
                }
                dict.removeAll(temp);
            }
            set.addAll(temp);
            // dict.removeAll(temp);
            depth++;
        }
        return depth;
        // return search(set, start_index, end_index, map)+1;

    }
//    public boolean isladder(String a, String b){
//        int la=a.length();
//
//        if(la!=b.length()){
//            return false;
//        }else{
//            int count=0;
//            for(int i=0;i<la;i++){
//                if(a.charAt(i)!=b.charAt(i))count++;
//                if(count>1)return false;
//            }
//        }
//        return true;
//    }
//    public int search (HashSet<Integer> set,int start_index,int end_index, boolean[][] map){
//        if(start_index==end_index)return 0;
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<map.length;i++){
//            if(i!=start_index && !set.contains(i) && map[start_index][i]==true ){
//                set.add(i);
//                int n=search(set,i,end_index,map);
//                if(n<min&&n+1<min)min=n+1;
//                set.remove(i);
//            }
//        }
//        return min;
//    }
//
//    public int ladderLength(String start, String end, Set<String> dict) {
//        // write your code here
//        if (!dict.contains(start))dict.add(start);
//        if (!dict.contains(end)) dict.add(end);
//        int n = dict.size();
//        // System.out.println(n);
//        boolean[][] map = new boolean[n][n];
//        int start_index = 0;
//        int end_index = 0;
//        ArrayList<String> dictionary = new ArrayList<>(dict);
//        for (int i = 0; i < n; i++) {
//            if (dictionary.get(i).equals(start)) {
//                start_index = i;
//            }
//            if (dictionary.get(i).equals(end)) {
//                end_index = i;
//            }
//        }
//        // System.out.println(start_index+":"+end_index);
//        for (int i = 0; i < n; i++)
//            for (int j = 0; j < n; j++) {
//                if (isladder(dictionary.get(i), dictionary.get(j))) {
//                    map[i][j] = true;
//                    map[j][i] = true;
//                }
//            }
//        // for (int i = 0; i < n; i++)
//        //     for (int j = 0; j < n; j++) {
//        //     System.out.println(map[i][j]);
//
//        //     }
//
//        HashSet<Integer> set = new HashSet<>();
//        set.add(start_index);
//        return search(set, start_index, end_index, map);
//    }
}
