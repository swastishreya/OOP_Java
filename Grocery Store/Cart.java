import java.util.ArrayList;

public class Cart{
    private ArrayList<Item> itemList;
    private float totalWeight;
    private float totalVolume;

    Cart(){
        this.itemList = new ArrayList<Item>();
        this.totalVolume = 0;
        this.totalWeight = 0;
    }

    public void addItem(Item i){
        this.itemList.add(i);
    }

    public void checkout(Store s){
        s.generateBill();
    }

    public ArrayList<Item> getItemsList(){
        return this.itemList;
    }

    public float getTotalWeight(){
        for(int var = 0; var < this.itemList.size(); var++){
            Item i = this.itemList.get(var);
            if(i.getType().equals("Perishable")){
                Perishable p = (Perishable) i;
                this.totalWeight += p.getWeight();
            }
        }

        return this.totalWeight;
    }

    public float getTotalVolume(){
        for(int var = 0; var < this.itemList.size(); var++){
            Item i = this.itemList.get(var);
            if(i.getType().equals("NonPerishable")){
                NonPerishable np = (NonPerishable) i;
                this.totalVolume += np.getAmount()*np.getVolume();
            }
        }

        return this.totalVolume;
    }
}