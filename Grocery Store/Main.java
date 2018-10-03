import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] req;
        String query;
        query = s.nextLine();
        req = query.split(" ");
        Store S = new Store();
        while(!req[0].equals("End")){
            if(req.length == 2){
                Perishable p = new Perishable(req[0]);
                p.setPerUnitPrice(Float.parseFloat(req[1]));
                p.setType("Perishable");
                S.addItems(p);
            }
            else if(req.length == 3){
                NonPerishable p = new NonPerishable(req[0]);
                p.setPerUnitPrice(Float.parseFloat(req[1]));
                p.setVolume(Float.parseFloat(req[2]));
                p.setType("NonPerishable");
                S.addItems(p);
            }
            query = s.nextLine();
            req = query.split(" ");
        }
        query = s.nextLine();
        req = query.split(" ");
        Cart C = new Cart();
        while(!req[0].equals("Checkout")){
            Item itemType = S.getType(req[0]);
            if(itemType.getType().equals("Perishable")){
                Perishable it = (Perishable) itemType;
                Perishable p = new Perishable(req[0]);
                p.setPerUnitPrice(it.getPerUnitPrice());
                p.setAmount(Float.parseFloat(req[1]));
                p.setType("Perishable");
                p.setWeight(Float.parseFloat(req[1]));
                C.addItem(p);
            }
            else if(itemType.getType().equals("NonPerishable")){
                NonPerishable it = (NonPerishable) itemType;
                NonPerishable p = new NonPerishable(req[0]);
                p.setPerUnitPrice(it.getPerUnitPrice());
                p.setVolume(it.getVolume());
                p.setAmount(Float.parseFloat(req[1]));
                p.setType("NonPerishable");
                C.addItem(p);
            }
            query = s.nextLine();
            req = query.split(" ");
        }
        S.setCart(C);
        S.generateBill();
        s.close();
    }
}