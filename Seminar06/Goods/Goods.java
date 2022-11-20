package Goods;

public class Goods {
    public int count;
    public String name;
    public double price;
    public StringBuilder description;

    @Override
    public String toString() {
        return String.format("id:%d\tназвание товара:%s\tцена:%,.2f\tописание:%s\n", count, name, price, description);
    }

}
