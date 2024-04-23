package site.ObjectOriented;

public class CloneTest {
    public static void main(String[] args) {
        Animal a1 = new Animal("花花");
        try {
            Animal a2 = (Animal) a1.clone();
            System.out.println("原始对象：" + a1);
            a2.setName("毛毛");
            System.out.println("clone 之后的对象：" + a2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Object obj = new Animal("1");
        System.out.println("obj.getClass() = " + obj.getClass());
        System.out.println("AA".hashCode());//2080
        System.out.println("AA".hashCode());//2080
    }
}

class Animal implements Cloneable{
    private String name;
    public Animal() {
        super();
    }
    public Animal(String name) {
        super();
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal [name=" + name + "]";
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
// TODO Auto-generated method stub
        return super.clone();
    }
}

