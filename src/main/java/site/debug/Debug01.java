package site.debug;

import java.util.HashMap;

public class Debug01 {
    public static void main(String[] args){
        Son instance = new Son();
        instance.test();

        Father instance1 = new Son();
        instance1.test();

        Consumer con = new ConsumerImpl();
        con.accept("byhcit");

        HashMap<String,Integer> map = new HashMap<>();
        map.put("Tom",12);
        map.put("Jerry",11);
        map.put("Tony",11);
    }
}

class Father {
    public void test() {
        System.out.println("Father:test");
    }
}

class Son extends Father {
    @Override
    public void test() {
        System.out.println("Son:test");
    }
}

interface Consumer {
    void accept(String str);
}

class ConsumerImpl implements Consumer {
    @Override
    public void accept(String str) {
        System.out.println("ConsumerImpl:" + str);
    }
}
