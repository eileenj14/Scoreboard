public class Scoreboard
{
    private String nameOfTeamOne;
    private String nameofTeamTwo;
    private int scoreOfTeamOne;
    private int scoreOfTeamTwo;
    private String activeTeam;

    public Scoreboard(String name1, String name2)
    {
        nameOfTeamOne = name1;
        nameofTeamTwo = name2;
        activeTeam = nameOfTeamOne;
    }

    public void recordPlay(int pointsScored)
    {
        if(pointsScored == 0)
        {
            if(activeTeam.equals(nameOfTeamOne)) activeTeam = nameofTeamTwo;
            else activeTeam = nameOfTeamOne;
        }
        else
        {
            if(activeTeam.equals(nameOfTeamOne)) scoreOfTeamOne += pointsScored;
            else scoreOfTeamTwo += pointsScored;
        }
    }

    public String getScore()
    {
        return scoreOfTeamOne + "-" + scoreOfTeamTwo + "-" + activeTeam;
    }
}
