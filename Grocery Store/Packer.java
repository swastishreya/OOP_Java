public class Packer{
    private static final float PERISHABLE = 5;
    private static final float NONPERISHABLE = 2;
    private static final float PERISHABLE_LIMIT = 5;
    private static final float NONPERISHABLE_LIMIT = 4;
    private float shippingCost;

    Packer(){
        this.shippingCost = 0;
    }

    public float getCost(float totalWeight, float totalVolume){
        if(totalWeight > 5){
            this.shippingCost += (totalWeight - PERISHABLE_LIMIT)*PERISHABLE;
        }
        if(totalVolume > 4){
            this.shippingCost += (totalVolume - NONPERISHABLE_LIMIT)*NONPERISHABLE;
        }
        return this.shippingCost;
    }
}