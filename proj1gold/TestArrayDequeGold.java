/**
 * @author Cagur
 * @version 1.0
 */
import  static org.junit.Assert.*;

import jdk.nashorn.internal.ir.CaseNode;
import org.junit.Test;

import java.util.ArrayList;

public class TestArrayDequeGold {

    @Test
   public void test1(){
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        // 这个抽离出来log的思想是借鉴的，这个idea很好。
        String log = "";
        for(int i=0;i<15000;i++){
            int factor = StdRandom.uniform(20,1000);
            int num = StdRandom.uniform(factor);
            boolean f = StdRandom.bernoulli();
            if(solution.size() == 0){
                if(!f){
                    log = log +  "addFirst(" + num + ")\n";
                    deque.addFirst(num);
                    solution.addFirst(num);
                }else{
                    log = log + "addLast(" + num + ")\n";
                    deque.addLast(num);
                    solution.addLast(num);
                }
            }else{
                int flag = StdRandom.uniform(4);
                if(flag < 2){
                    if(!f){
                        log = log +  "addFirst(" + num + ")\n";
                        deque.addFirst(num);
                        solution.addFirst(num);
                    }else{
                        log = log + "addLast(" + num + ")\n";
                        deque.addLast(num);
                        solution.addLast(num);
                    }
                    continue;
                }
                int x,xx;
                if(!f){
                    log  = log + "removeFirst()\n";
                    x = deque.removeFirst();
                    xx = solution.removeFirst();
                }else {
                    log  = log + "removeLast()\n";
                    x = deque.removeLast();
                    xx = solution.removeLast();
                }
                assertEquals(log,xx,x);
            }

        }
    }
}