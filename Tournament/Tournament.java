import java.util.Scanner;

public class Tournament{
    private int round;
    private int numberOfTeams;
    private Team[] drawOrder;
    private int[][] relativeRating;
    
    Tournament(int n){
        this.numberOfTeams = n;
        this.drawOrder = new Team[n];
        this.relativeRating = new int[n][n];
        this.round = 1;
    }

    public void setDrawOrder(Team[] drawOrder){
        this.drawOrder = drawOrder;
    }

    public void setRelativeRating(int[][] relativeRating){
        this.relativeRating = relativeRating;
    }
    
    public Team[] playRound(){
        Team[] nextDrawOrder = new Team[this.numberOfTeams/2];
        int i = 0;
        for(int var = 0; var < this.numberOfTeams - 1;){
            Match m = new Match(this.drawOrder[var],this.drawOrder[var+1]);
            nextDrawOrder[i] = m.getWinner(this.relativeRating);
            i++;
            var += 2;
        } 
        System.out.print("Round " + this.round + " Winners: ");
        for(int var = 0; var < this.numberOfTeams/2; var++){
            System.out.print(nextDrawOrder[var].getName() + " ");
        }
        System.out.println();
        this.round += 1;
        this.drawOrder = nextDrawOrder;
        this.numberOfTeams = this.numberOfTeams/2;
        return nextDrawOrder;
    }

    public void playTournament(){
        while(this.numberOfTeams != 1){
            this.playRound();
        }
    }

    public Team[] getDrawOrder(){
        return this.drawOrder;
    }

    public int[][] getRelativeRating(){
        return this.relativeRating;
    }

    public static void main(String[] args){
        int n, var, var1, var2;

        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        Team[] drawOrder = new Team[n];
        int[][] relativeRating = new int[n][n];

        for(var1 = 0; var1 < n; var1++){
            for(var2 = 0; var2 < n; var2++){
                relativeRating[var1][var2] = Integer.parseInt(s.next());
            }
        }

        for(var = 1; var <= n; var++){
            drawOrder[var-1] = new Team(s.next());
        }

        Tournament T = new Tournament(n);

        T.setDrawOrder(drawOrder);
        T.setRelativeRating(relativeRating);
        T.playTournament();

        s.close();
    }
}