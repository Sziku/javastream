package org.example;

@FunctionalInterface
public interface Printable {

    void print(boolean isUpperCase);
    //void other(); hibat add az annotációban

    default void doOtherThing(){
        System.out.println("doing other thing");
    }

}
