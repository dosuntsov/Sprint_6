package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Predator predator;
    private IKittens kittens;
    public Lion(Feline feline){
        this.predator = feline;
    }
    public Lion(IKittens kittens){
        this.kittens = kittens;
    }

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }
    public int getKittens() {
        return kittens.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
