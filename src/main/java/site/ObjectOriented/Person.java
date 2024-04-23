package site.ObjectOriented;

public class Person {
    int age;

    public void eat(){
        System.out.println("人吃饭");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
       person.eat();
        System.out.println( person.getClass());
        System.out.println(person);
    }
}
