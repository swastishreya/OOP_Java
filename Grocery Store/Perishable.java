public class Perishable extends Item{
    private float weight;
    Perishable(String name){
        super(name);
        this.weight = 0;
    }

    public void setWeight(float w){
        this.weight = w;
    }

    public float getWeight(){
        return this.weight;
    }
}