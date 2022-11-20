package Goods;

public class CreateGoods {
    Goods temp;

    public CreateGoods() {
        temp = new Goods();
        temp.count = 0;
        temp.description = new StringBuilder("-");
        temp.name = "-";
        temp.price = 0.0;

    }

    public CreateGoods setCount (int count) {
        temp.count = count;
        return this;
    }
    
    public CreateGoods setDescription(String userDescription) {
        temp.description.replace(0,1,userDescription);
        return this;
    }

    public CreateGoods setName (String name) {
        temp.name = name;
        return this;
    }

    public CreateGoods setPrice (double price) {
        temp.price = price;
        return this;
    }

    public Goods Create() {
        return temp;
    }

    
    
    



    
        
    
}
