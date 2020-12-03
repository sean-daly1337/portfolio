/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.reactive.systems.designpatternsandlambdas_1.task3;

import com.lit.reactive.systems.designpatternsandlambdas_1.pojos.Property;
import com.lit.reactive.systems.designpatternsandlambdas_1.pojos.PropertyType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *
 * @author James
 */
public class Task3_1 {
    
    
    public static void main(String[] args){
        
        List<Property>properties = new ArrayList<>();
        
//      Property(String town, PropertyType type, int numOfBedrooms, double metreSq, double cost)
        properties.add(new Property("Limerick",PropertyType.SEMI_DETACHED, 4, 150, 250000));
        properties.add(new Property("Tipperary",PropertyType.DETACHED, 5, 200, 200000));
        properties.add(new Property("Clare",PropertyType.TERRACE, 3, 125, 150000));
        properties.add(new Property("Galway",PropertyType.DETACHED, 6, 220, 350000));
        properties.add(new Property("Limerick",PropertyType.APARTMENT, 2, 100, 225000));
        
    
        
        //3_1 part a)

        System.out.println("Arrange the list of properties from largest area to smallest area");
        properties.sort(Comparator.comparing(Property::getAreaM2));
        properties.forEach(System.out::println);

        //3_1 part b)

        System.out.println("\nArrange the list of properties from cheapest to dearest");
        properties.sort(Comparator.comparing(Property::getCost));
        properties.forEach(System.out::println);

        //3_1 part c)

        System.out.println("\nArrange the list of properties with the Detached properties listed first");
        properties.sort(Comparator.comparing(Property::getType));
        properties.forEach(System.out::println);

        //3_1 part d)

        System.out.println("\nArrange the list of properties with the houses in Limerick listed last");
        properties.sort(Comparator.comparing((s) -> {
            if (s.getTown().equals("Limerick"))
                return 1;
            
            else 
                return 0;
        }));
        properties.forEach(System.out::println);

        //3_1 part e)

        System.out.println("\nArrange the list of properties with the town names in alphabetical order");
        properties.sort(Comparator.comparing(Property::getTown));
        properties.forEach(System.out::println);
        
    }
}
