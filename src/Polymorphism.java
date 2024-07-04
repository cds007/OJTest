public class Polymorphism {
    public void t1(){
        System.out.println("nihao");
    }
    //多态不能调用“只在子类存在但在父类不存在”的方法；
    public static void main(String[] args) {
        Polymorphism t = new Polymorphism2();
        t.t1();
    }
}

/**
 * 多态的英文是 “Polymorphism”。在计算机科学中，多态是指允许对象采用多种形式的能力。
 * 这是面向对象编程中的一个核心概念，指的是同一操作作用于不同的对象时可以有不同的解释，
 * 并产生不同的执行结果。多态通常通过继承和接口实现。
 */

class Polymorphism2 extends Polymorphism{
    public void t2(){
        System.out.println("who");
    }
}
