package com.mzzcy.DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzzcy on 2015/9/25.
 */
abstract class Componate{

    protected String name;

    Componate(String name){
        this.name = name;
    }

    abstract void add(Componate c);
    abstract void remove(Componate c);
    abstract void display(String s);
}

class Leaf extends Componate{

    Leaf(String name){
        super(name);
    }

    @Override
    void add(Componate c) {
        System.out.println("CAN'T add");
    }

    @Override
    void remove(Componate c) {
        System.out.append("CAN'T remove");
    }

    @Override
    void display(String s) {
        System.out.println(s + name);
    }
}

class Composite extends Componate{
    List<Componate> compList= new ArrayList<>();

    Composite(String name){
        super(name);
    }

    @Override
    void add(Componate c) {
        compList.add(c);
    }

    @Override
    void remove(Componate c) {
        compList.remove(c);
    }

    @Override
    void display(String s) {
        System.out.println( s + name);
        for(Componate c:compList){
            c.display("--"  + s );
        }
    }
}

public class Composite_Pattern{

    public static void main(String args[]){

        Componate root = new Composite("root");
        root.add(new Leaf("Leaf-A"));
        root.add(new Leaf("Leaf-B"));

        Componate branch1 = new Composite("Branch-1");
        branch1.add(new Leaf("Leaf-C"));

        Componate branch2 = new Composite("Branch-2");
        branch2.add(new Leaf("Leaf-D"));
        branch2.add(new Leaf("Leaf-E"));

        branch1.add(branch2);
        root.add(branch1);

        root.display("-");

    }



}





















