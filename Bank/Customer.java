import java.util.ArrayList;

public class Customer{
    private int customerId = -1;
    private Request request;
    private int balance;
    private ArrayList<Request> requestStack;

    public void setId(int id){
        if(this.customerId == -1){
            this.customerId = id;
            this.balance = 0;
            this.requestStack = new ArrayList<Request>();
        }
    }

    public void setPresentRequest(int reqId, Character reqType){
        this.request = new Request();
        this.request.setRequestId(reqId);
        this.request.setRequestType(reqType);
    }

    public void setBalance(int bal){
        if(this.request.getRequestType() == 'D'){
            this.request.setBalance(bal);
            this.balance += bal;
            this.requestStack.add(0,this.request);
        }
        else if(this.request.getRequestType() == 'W'){
            if(bal > this.balance){
                this.request.setBalance(0);
            }
            else{
                this.request.setBalance(bal);
                this.balance -= bal;
                this.requestStack.add(0,this.request);
            }
        }
        else{
            this.requestStack.add(0,this.request);
        }
    }

    public Request getRequest(){
        return this.request;
    }

    public int getId(){
        return this.customerId;
    }

    public int getBalance(){
        return this.balance;
    }

}