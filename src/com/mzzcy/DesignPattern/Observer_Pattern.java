package com.mzzcy.DesignPattern;

import java.util.Vector;

/**
 * Created by mzzcy on 2015/9/25.
 */

abstract class Subject{
    private Vector<Observer> observers = new Vector<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

abstract class Observer
{
    abstract void update();
}

class ConcreteSubject extends Subject{
    private String subjectState;

    public void set(String values){
        subjectState = values;
    }

    public String get(){
        return subjectState;
    }
}

class ConcreteObserver extends Observer{
    private String observerState;
    private Subject subject;

    ConcreteObserver(Subject subject){
        this.subject = subject;
    }

    @Override
    void update(){
        this.observerState = ((ConcreteSubject)subject).get();
        System.out.printf("Observer's state is %s\n",this.observerState);
    }
}

public class Observer_Pattern {

    public static void main(String[] args){

        Subject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver(subject));
        subject.attach(new ConcreteObserver(subject));

        ((ConcreteSubject)subject).set("State1");
        subject.notifyObserver();
    }

}
