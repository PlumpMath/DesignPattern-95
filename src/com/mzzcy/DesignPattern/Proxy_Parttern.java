package com.mzzcy.DesignPattern;

/**
 * Created by mzzcy on 2015/9/26.
 */
abstract class AbsSubject{
    abstract  public void request();
}

class RealSubject extends  AbsSubject{

    @Override
    public void request() {
        System.out.println("This is real request()");
    }
}

class Proxy extends AbsSubject{
    AbsSubject realSubject;

    @Override
    public void request() {
        if(realSubject==null)
            realSubject = new RealSubject();
        realSubject.request();
    }
}

public class Proxy_Parttern {

    public static void main(String args[]){

        Proxy proxy = new Proxy();
        proxy.request();

    }
}
