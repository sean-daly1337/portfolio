/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.reactive.systems.designpatternsandlambdas_1.task1;
 
import java.util.Iterator; 


/**
 *
 * @author James
 */
public class Task1 {
    
    private static class FactorialWalkThrough implements Iterator<Integer> {
        private int end;
        private int index = 0;
        private int current = 1;
        
    public FactorialWalkThrough(int end) { this.end = end; }
        @Override public boolean hasNext() { return index < end; }
        @Override public Integer next() {
            
        if (index < end) 
        {
        if (index != 0) current *= index; index++;
        } 
        return current; }
        }
    
    public static void main(String[] args) {
        Iterator<Integer> iterator = new FactorialWalkThrough(10);
            while (iterator.hasNext()) System.out.println(iterator.next());
    }
}


