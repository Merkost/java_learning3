import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int SIZE = 10;
    public static void main(String[] args) {
        //Задание 1
        Integer[] int_arr = new Integer[] {9,4,2,6,5,4,7,6,3,10};
        moveElements(int_arr, 3, 4);
        System.out.println(Arrays.toString(int_arr));

        //Задание 2
        toArrayList(int_arr);

        //Задание 3
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();
        Orange o4 = new Orange();
        Box<Orange> orange_box = new Box();
        Box<Orange> orange_box2 = new Box();
        Box<Apple> apple_box = new Box();
        orange_box.add(o1,o2);
        //orange_box.add(o3);
        apple_box.add(a1, a2, a3);
        System.out.println(orange_box.getWeight());
        System.out.println(apple_box.getWeight());
        System.out.println(apple_box.compare(orange_box));
        Box<Apple> new_apple_box = new Box();
        transfer(new_apple_box, apple_box);
        System.out.println(apple_box.fruits);
    }

    public static <T> void moveElements(T arr[], int i, int j){
        T temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static <T> void toArrayList(T massive[]){
        ArrayList<T> list = new ArrayList<>(Arrays.asList(massive));
        System.out.println(list);
    }
    public static <T extends Fruit> void transfer(Box<T> new_box, Box<T> old_box){
        for (T o : old_box.fruits) {
            new_box.add(o);
        }
        old_box.fruits.clear();

    }
}
