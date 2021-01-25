package util;

import java.lang.reflect.Array;

public class Converter {
    public int[] convertToIntArray(String str){
        str = str.substring(1,str.length() - 1);
        String[] ele = str.split(",") ;
        Object arr = Array.newInstance(int.class,ele.length);
        for(int i = 0; i < ele.length; i ++){
            Array.set(arr,i,Integer.valueOf(ele[i]));
        }
        return (int[])(arr);
    }

    public static void main(String[] args) {
        String s = "\n";
        System.out.println(s.length());
    }
}
