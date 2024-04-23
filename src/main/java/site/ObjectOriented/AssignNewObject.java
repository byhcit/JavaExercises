package site.ObjectOriented;

public class AssignNewObject {
    public void swap(MyData my){
//        my = new MyData();
        int temp = my.x;
        my.x = my.y;
        my.y = temp;

    }

    public static void main(String[] args) {
        AssignNewObject tools = new AssignNewObject();

        MyData data = new MyData();
        data.x = 1;
        data.y = 2;
        System.out.println("交换之前：x = " + data.x +",y = " + data.
                y);//
        //调用完之后，x 与 y 的值交换？
        tools.swap(data);
        System.out.println("交换之后：x = " + data.x +",y = " + data.
                y);//
    }

}

class MyData{
    int x ;
    int y;
}
