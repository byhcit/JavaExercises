package site.ObjectOriented;

public class TestStaticBlock {
    public static void main(String[] args) {
        Chinese c1 = new Chinese("张三");
        Chinese c2 = new Chinese("李四");

    }
}

 class Chinese {
    // private static String country = "中国";
    private static String country;
    private String name;
    {
        System.out.println("非静态代码块，country = " + country);
    }
    static {
        country = "中国";
        System.out.println("静态代码块");
    }
    public Chinese(String name) {
        this.name = name;
    }
}
