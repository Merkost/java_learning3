import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<T>();
    }

    public void add(T ...a) {
        for (T t : a) {
            fruits.add(t);
        }
    }

    public float getWeight(){
        float weight = 0f;
        for (int i = 0; i < this.fruits.size(); i++) {
            weight+= fruits.get(i).weight;
        }
        return weight;
    }

    public Boolean compare(Box o) {
        System.out.println(this.getWeight());
        System.out.println(o.getWeight());
        return Math.abs(this.getWeight() - o.getWeight()) < 0.00001;
    }


}
