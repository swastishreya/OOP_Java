import java.util.ArrayList;
import java.util.Scanner;

public class Teller{
    private static int request = 0;
    private int numberOfCashiers;
    private Cashier[] cashierQueue;
    private int numberOfCustomers;
    private ArrayList<Request> requestQueue;
    private ArrayList<Customer> totalCustomers;

    Teller(){
        this.numberOfCashiers = 0;
        this.numberOfCustomers = 0;
        this.requestQueue = new ArrayList<Request>();
        this.totalCustomers = new ArrayList<Customer>();
    }

    public void reset(){
        this.numberOfCashiers = 0;
        this.numberOfCustomers = 0;
        this.requestQueue = new ArrayList<Request>();
    }

    public Customer getCustomer(int id){
        for(int i = 0; i < this.totalCustomers.size(); i++){
            if(this.totalCustomers.get(i).getId() == id){
                return this.totalCustomers.get(i);
            }
        }
        return null;
    }

    public void addCustomer(Customer c){
        this.totalCustomers.add(c);
    }

    public void addRequest(Request r){
        this.requestQueue.add(r);
        this.numberOfCustomers += 1;
    }

    public int generateRequestId(){
        Teller.request += 1;
        return Teller.request;
    }

    public void printBalanceOfCustomers(){
        for(int i = 0; i < this.totalCustomers.size(); i++){
            System.out.println(this.totalCustomers.get(i).getId() + " " + this.totalCustomers.get(i).getBalance());
            
        }
    }

    public void deployCashiers(){
        this.numberOfCashiers = this.numberOfCustomers/3;
        if(this.numberOfCustomers%3 != 0){
            this.numberOfCashiers += 1;
        }
        this.cashierQueue = new Cashier[this.numberOfCashiers];
        for(int var = 0; var < this.numberOfCashiers; var++){
            this.cashierQueue[var] = new Cashier(var+1);
        }

        for(int var = 0; var < this.numberOfCustomers; var++){
            Request r = this.requestQueue.get(0);
            this.cashierQueue[var%this.numberOfCashiers].pushRequest(r);
            this.requestQueue.remove(0);
        }

        for(int var = 0; var < this.numberOfCashiers; var++){
            this.cashierQueue[var].processRequest();
        }
    }

    public static void main(String[] args){
        String[] req;
        Scanner s = new Scanner(System.in);
        String query;
        query = s.nextLine();
        req = query.split(" ");
        Teller T = new Teller();
        while(req[0].charAt(0) != 'E'){
            if(req[0].charAt(0) == 'B'){
                T.deployCashiers();
                T.reset();
            }
            else{
                int bal = 0;
                int id = Integer.parseInt(req[1]);
                if(req[0].charAt(0) == 'D' || req[0].charAt(0) == 'W'){
                    bal = Integer.parseInt(req[2]);
                }
                Customer c = new Customer();
                if(T.getCustomer(id) != null){
                    c = T.getCustomer(id);
                    c.setPresentRequest(T.generateRequestId(), req[0].charAt(0));
                    c.setBalance(bal);
                    T.addRequest(c.getRequest());
                }
                else{
                    c.setId(id);
                    c.setPresentRequest(T.generateRequestId(), req[0].charAt(0));
                    c.setBalance(bal);
                    T.addCustomer(c);
                    T.addRequest(c.getRequest());
                }
            }
            query = s.nextLine();
            req = query.split(" ");
        }
        T.deployCashiers();
        T.printBalanceOfCustomers();
        s.close();
    }
}