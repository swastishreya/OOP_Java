public class Match{
    private Team winner, team_1, team_2;
    Match(){
        //Do nothing
    }

    Match(Team x, Team y){
        this.team_1 = x;
        this.team_2 = y;
    }

    public void setTeams(Team x, Team y){
        this.team_1 = x;
        this.team_2 = y;
    }
    
    public Team getWinner(int[][] relativeRating){
        int team1 = Integer.parseInt(team_1.getName());
        int team2 = Integer.parseInt(team_2.getName());
        if(relativeRating[team1][team2] == -1){
            winner = team_1;
        }
        else if(relativeRating[team1][team2] == 1){
            winner = team_2;
        }
        else{
            System.out.println("Invalid match!!");
        }

        return winner;
    }
}