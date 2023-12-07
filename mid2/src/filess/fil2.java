package filess;


import java.util.Queue;
import java.util.Stack;

public class fil2 extends fil1{
    public fil2(){

    }
    public void method1(){
        System.out.println();
    }

    public static void reverseK(MyStack<String> sta, int num){
        int i = sta.getSize() - num;
        if(i>sta.getSize()){
            throw new IllegalArgumentException();
        }
        MyQueue<String> q = new MyQueue<String>();
        for (int j = 0; j < i; j++) {
            String temp = sta.pop();
            q.enqueue(temp);
        }

        for (int j = 0; j < i; j++) {
            String s = q.dequeue();
            sta.push(s);
        }
    }
}
