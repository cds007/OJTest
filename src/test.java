public class test {
    public void t1(){
        System.out.println("nihao");
    }
    //多态不能调用“只在子类存在但在父类不存在”的方法；
    public static void main(String[] args) {
        test t = new test2();
        t.t1();
    }
}

class test2 extends test{
    public void t2(){
        System.out.println("who");
    }
}
