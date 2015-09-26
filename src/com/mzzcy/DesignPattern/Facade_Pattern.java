package com.mzzcy.DesignPattern;

/**
 * Created by mzzcy on 2015/9/26.
 */

class SubSystemA{
    public void subMethodA(){
        System.out.println("func methodA!");
    }
}

class SubSystemB{
    public void subMethodB(){
        System.out.println("func MethodB!");
    }
}

class SubSystemC{
    public void subMethodC(){
        System.out.println("func MethodC!");
    }
}

class SubSystemD{
    public void subMethodD(){
        System.out.println("func MethodD!");
    }
}

class Facade{
    SubSystemA subSystemA;
    SubSystemB subSystemB;
    SubSystemC subSystemC;
    SubSystemD subSystemD;

    public Facade(){
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
        subSystemC = new SubSystemC();
        subSystemD = new SubSystemD();
    }

    public void methodA(){
        subSystemA.subMethodA();
        subSystemB.subMethodB();
    }

    public void methodB(){
        subSystemC.subMethodC();
        subSystemD.subMethodD();
    }
}

public class Facade_Pattern {

    public static void main(String args[]){

        Facade facade = new Facade();

        facade.methodA();
        facade.methodB();

    }
}
