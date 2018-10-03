import java.util.ArrayList;

public class Store{
    private ArrayList<Item> availableItems;
    private Cart currentCart;
    private Biller biller;

    Store(){
        this.availableItems = new ArrayList<Item>();
        this.currentCart = new Cart();
        this.biller = new Biller();
    }

    public Item getType(String item){
        for(int var = 0; var < this.availableItems.size(); var++){
            Item i = this.availableItems.get(var);
            if(i.getName().equals(item)){
                return i;
            }
        }
        return null;
    }

    public void addItems(Item i){
        this.availableItems.add(i);
    }

    public void setCart(Cart c){
        this.currentCart = c;
    }

    public void generateBill(){
        this.biller.getBill(this.currentCart);
    }
}