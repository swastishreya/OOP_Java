public class Request{
    public static final int DEPOSIT_TIME = 5;
    public static final int WITHDRAWAL_TIME = 10;
    public static final int QUERY_TIME = 2;
    private int requestId;
    private Character requestType;
    private int time;
    private int balance;

    Request(){
        this.balance = 0;
        this.time = 0;
    }

    public void setRequestId(int reqId){
        this.requestId = reqId;
    }

    public void setRequestType(Character reqType){
        this.requestType = reqType;
    }

    public void setBalance(int bal){
        if(this.requestType == 'W'){
            this.balance -= bal;
        }
        else if(this.requestType == 'D'){
            this.balance += bal;
        }
    }

    public int getRequestId(){
        return this.requestId;
    }

    public Character getRequestType(){
        return this.requestType;
    }

    public int getTime(){
        return this.time;
    }

    public int getTime(int time){
        if(requestType == 'W'){
            this.time = time + WITHDRAWAL_TIME;
        }
        else if(requestType == 'D'){
            this.time = time + DEPOSIT_TIME;
        }
        else if(requestType == 'Q'){
            this.time = time + QUERY_TIME;
        }
        return this.time;
    }

    public int getBalance(){
        return this.balance;
    }
}