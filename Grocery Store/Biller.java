public class Biller{
    private float totalAmount;
    private Cart currenCart;
    private Packer packer;
    private float shippingCost;

    Biller(){
        this.totalAmount = 0;
        this.currenCart = new Cart();
        this.packer = new Packer();
    }
    public void getBill(Cart c){
        this.currenCart = c;
        for(Item i: this.currenCart.getItemsList()){
            float cost = i.getAmount()*i.getPerUnitPrice();
            this.totalAmount += cost;
            System.out.println(String.format("%s %.1f %.1f",i.getName(), i.getAmount(), cost));
        }

        this.shippingCost = packer.getCost(this.currenCart.getTotalWeight(), this.currenCart.getTotalVolume());
        System.out.println(String.format("%s %.1f","Shipping ",this.shippingCost));
        this.totalAmount += this.shippingCost;
        System.out.println(String.format("%s %.1f","Total ",this.totalAmount));
    }
}
