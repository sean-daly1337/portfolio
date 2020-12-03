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
public class Task3_2 {
    
    ////3_2 part a)

    Function<Person, String> reduce = Person::getLastName;

    //3_2 part b)

    Function<Person, Person> correct = person -> {
        if (person.getAge() < 2)
        person.setAge(3);
        return person;
    };


    //3_2 part c)

    Function<Person, String> canVote = person -> {
        
        String result;
        
        if (person.getAge()<18) 
           result = ("person "+person.getFirstName()+" cannot vote");
        
        else result =("person "+person.getFirstName()+" can vote");
        
        return result;
    };

    //3_2 part d)

    Function<String, Boolean> canVoteBool = s -> s.contains("can");

            
}
