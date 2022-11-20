package Goods;

public class app {
    public static void main(String[] args) {
        Goods good1 = new CreateGoods()
            .setCount(1)
            .setName ("Молоко")
            .setPrice(50.00)
            .setDescription("Коровье")
            .Create();
        System.out.print(good1);
        Goods good2 = new CreateGoods()
            .setCount(2)
            .setName ("Хлеб")
            .setPrice(30.00)
            .setDescription("Бородинский")
            .Create();
        System.out.print(good2);
        Goods good3 = new CreateGoods()
            .setCount(3)
            .setName ("Масло")
            .setPrice(100.00)
            .setDescription("Сливочное")
            .Create();
        System.out.print(good3);

    }
}
