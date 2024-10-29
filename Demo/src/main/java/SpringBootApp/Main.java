package SpringBootApp;

import java.util.HashMap;
import java.util.Map;

// print the duplicated letters with count
public class Main {
    public static void main(String[] args) {

        String s1= "availability";
        findDuplicate(s1);



    }

    public static void findDuplicate(String s2){


     Map<Character,Integer> letterCount= new HashMap<>();
     for(char ch : s2.toCharArray()){
         if(Character.isLetter((ch))){

             letterCount.put(ch,letterCount.getOrDefault(ch,0)+1);
         }
     }
     System.out.println("duplicate letter with count");
     for(Map.Entry<Character,Integer> entry : letterCount.entrySet()){

         if(entry.getValue() >1){

             System.out.println(entry.getKey()+ ": "+entry.getValue());
         }
     }


    }
}