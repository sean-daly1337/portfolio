/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.reactive.systems.designpatternsandlambdas_1.task3;

import com.lit.reactive.systems.designpatternsandlambdas_1.pojos.Person;
import java.util.function.Function;


/**
 *
 * @author James
 */
public class Task3_3 {

    public static void main(String[] args) {
//    Person(String firstName, String lastName, int age, double height, boolean hasCitizenship)

        Person Tom = new Person("Tom", "Tailor", 21, 197.5, true);
        Person Mary = new Person("Mary", "Maples", 24, 163.0, false);
        Person Pat = new Person("Pat", "Parsons", 23, 170.0, false);
        Person Lisa = new Person("Lisa", "Lehane", 20, 172.0, true);

        //3_3 part a)

        Function<Person, Function<Person, Boolean>> matchTest = person -> person1 -> Math.abs(person.getAge() - person1.getAge())<=2;


        //3_3 part b)

        Function<Person, Boolean> test1 = person -> matchTest.apply(Tom).apply(person);

        //3_3 part c)

        System.out.println(test1.apply(Mary));
        System.out.println(test1.apply(Lisa));
        
        
    }
}
