public class Team{
    private String name;
    Team(){
        //Do nothing
    }

    Team(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}