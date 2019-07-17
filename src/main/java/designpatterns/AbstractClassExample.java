package designpatterns;

public abstract class AbstractClassExample {

    public static SingletonPattern getSingletonPattern(){
        return new SingletonPattern(); 
    }
    
    public abstract void display();
}
