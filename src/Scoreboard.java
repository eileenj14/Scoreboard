public class Scoreboard
{
    private String teamOne;
    private String teamTwo;
    private int scoreOfTeamOne;
    private int scoreOfTeamTwo;
    private String activeTeam;

    public Scoreboard(String name1, String name2)
    {
        teamOne = name1;
        teamTwo = name2;
        activeTeam = teamOne;
    }

    public void recordPlay(int pointsScored)
    {
        if(pointsScored == 0)
        {
            if(activeTeam.equals(teamOne)) activeTeam = teamTwo;
            else activeTeam = teamOne;
        }
        else
        {
            if(activeTeam.equals(teamOne)) scoreOfTeamOne += pointsScored;
            else scoreOfTeamTwo += pointsScored;
        }
    }

    public String getScore()
    {
        return scoreOfTeamOne + "-" + scoreOfTeamTwo + "-" + activeTeam;
    }
}
