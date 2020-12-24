package leetcode.no138;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    private static class Student implements Comparable<Student>{
        private int rating;
        private int pos;
        public  Student(int rating,int pos){
            this.rating = rating;
            this.pos = pos;
        }
        @Override
        public int compareTo(Student o) {
            if(this.rating < o.rating){
                return -1;
            }else if(this.rating > o.rating){
                return 1;
            }else{
                return 0;
            }
        }
    }
    public int candy(int[] ratings) {
        /*PriorityQueue<Student> pq = new PriorityQueue<>();
        for(int i = 0; i < ratings.length; i ++){
            pq.add(new Student(ratings[i],i));
        }
        int[] candies = new int[ratings.length];
        int sum = 0;
        while(!pq.isEmpty()){
            Student s = pq.poll();
            int candy = 1;
            if(s.pos - 1 >= 0 && ratings[s.pos - 1] < ratings[s.pos]){
                candy = Math.max(candy,candies[s.pos - 1] + 1);
            }
            if(s.pos + 1 < ratings.length && ratings[s.pos + 1] < ratings[s.pos]){
                candy = Math.max(candy,candies[s.pos + 1] + 1);
            }
            candies[s.pos] = candy;
            sum += candy;
        }
        return sum;*/
        /*Student[] students = new Student[ratings.length];
        for(int i = 0; i < ratings.length; i ++){
            students[i] = new Student(ratings[i],i);
        }
        Arrays.sort(students);
        int sum = 0;
        int[] candies = new int[ratings.length];
        for(Student s : students){
            int candy = 1;
            if(s.pos - 1 >= 0 && ratings[s.pos - 1] < ratings[s.pos]){
                candy = Math.max(candy,candies[s.pos - 1] + 1);
            }
            if(s.pos + 1 < ratings.length && ratings[s.pos + 1] < ratings[s.pos]){
                candy = Math.max(candy,candies[s.pos + 1] + 1);
            }
            candies[s.pos] = candy;
            sum += candy;
        }
        return sum;*/
        int[] left = new int[ratings.length];
        for(int i = 0; i < ratings.length; i ++){
            if(i > 0 && ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }else{
                left[i] = 1;
            }
        }
        int right = 0;
        int sum = 0;
        for(int i = ratings.length - 1; i >= 0; i --){
            if(i < ratings.length - 1 && ratings[i] > ratings[i + 1]){
                right ++;
            }else{
                right = 1;
            }
            sum += Math.max(left[i],right);
        }
        return sum;
    }
}
