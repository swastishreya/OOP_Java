import java.util.ArrayList;

public class Cashier{
    private int time;
    private ArrayList<Request> requestStack;
    private int transaction;
    private int numberOfRequests;
    private int cashierId;

    Cashier(int id){
        this.cashierId = id;
        this.requestStack = new ArrayList<Request>();
        this.numberOfRequests = 0;
        this.transaction = 0;
        this.time = 0;
    }

    public void pushRequest(Request req){
        this.requestStack.add(req);
        this.numberOfRequests += 1;
    }

    public void updateTime(int time){
        this.time = time;
    }

    public void processRequest(){
        int reqProc = 0;
        System.out.println("Cashier " + this.cashierId);
        while(reqProc < this.numberOfRequests){
            Request req = this.requestStack.get(0);
            System.out.println("Request " + req.getRequestId() + " " + req.getTime(this.time));
            reqProc += 1;
            this.updateTime(req.getTime());
            this.requestStack.remove(0);
            this.transaction += req.getBalance();
        }
        System.out.println("Total " + this.transaction);        
    }
}