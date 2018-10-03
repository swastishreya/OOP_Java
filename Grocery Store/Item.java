public class Item{
    private String name;
    private float pricePerUnit;
    private String type;
    private float amount;

    Item(String name){
        this.name = name;
        this.type = "";
    }

    public void setAmount(float amount){
        this.amount = amount;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setPerUnitPrice(float price){
        this.pricePerUnit = price;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public float getPerUnitPrice(){
        return this.pricePerUnit;
    }

    public float getAmount(){
        return this.amount;
    }
}