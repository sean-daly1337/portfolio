/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.reactive.systems.designpatternsandlambdas_1.pojos;

/**
 *
 * @author James
 */
public class Property {
    
    
    String town;
    PropertyType type;
    int numOfBedrooms;
    int metreSq;
    int cost;

    public Property(String town, PropertyType type, int numOfBedrooms, int metreSq, int cost) {
        this.town = town;
        this.type = type;
        this.numOfBedrooms = numOfBedrooms;
        this.metreSq = metreSq;
        this.cost = cost;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public int getAreaM2() {
        return metreSq;
    }

    public void setAreaM2(int metreSq) {
        this.metreSq = metreSq;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Property{" + "town=" + town + ", type=" + type + ", numOfBedrooms=" + numOfBedrooms + ", metres squared=" + metreSq + ", cost=" + cost + '}';
    }

   

}
