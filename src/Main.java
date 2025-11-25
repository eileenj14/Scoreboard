import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scoreboard game = new Scoreboard("Red", "Blue");
        System.out.println(game.getScore());
        game.recordPlay(1);
        System.out.println(game.getScore());
        game.recordPlay(0);
        System.out.println(game.getScore());
        System.out.println(game.getScore());
        game.recordPlay(3);
        System.out.println(game.getScore());
        game.recordPlay(1);
        game.recordPlay(0);
        System.out.println(game.getScore());
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        System.out.println(game.getScore());
        Scoreboard match = new Scoreboard("Lions", "Tigers");
        System.out.println(match.getScore());
        System.out.println(game.getScore());
        System.out.println();
        read();
    }

    public static void read() throws FileNotFoundException
    {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] tempTeamsArray = getListOfTeams();
        List<String> teams = Arrays.asList(tempTeamsArray);
        int[] teamWins = new int[getNumOfTeams()];
        while(s.hasNextLine())
        {
            Scanner ss = new Scanner(s.nextLine());
            Scoreboard game = new Scoreboard(ss.next(), ss.next());
            while(ss.hasNextInt())
            {
                game.recordPlay(ss.nextInt());
            }
            if(game.getNameOfWinningTeam() != null)
            {
                int index = teams.indexOf(game.getNameOfWinningTeam());
                teamWins[index] = teamWins[index] + 1;
            }
        }
        for(int i = 0; i < getNumOfTeams(); i++)
        {
            System.out.println(teams.get(i) + " " + teamWins[i]);
        }
    }

    public static String[] getListOfTeams() throws FileNotFoundException
    {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] teams = new String[getNumOfTeams()];
        teams[0] = s.next();
        int numOfTeams = 1;
        while(s.hasNext())
        {
            String team = s.next();
            if(team.length() > 1)
            {
                for(int i = 0; i < numOfTeams; i++)
                {
                    if(team.equals(teams[i])) break;
                    if(i + 1 == numOfTeams)
                    {
                        teams[numOfTeams] = team;
                        numOfTeams++;
                    }
                }
            }
        }
        return teams;
    }

    public static int getNumOfTeams() throws FileNotFoundException
    {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] teams = new String[10];
        teams[0] = s.next();
        int numOfTeams = 1;
        while(s.hasNext())
        {
            String team = s.next();
            if(team.length() > 1)
            {
                for(int i = 0; i < numOfTeams; i++)
                {
                    if(team.equals(teams[i])) break;
                    if(i + 1 == numOfTeams)
                    {
                        teams[numOfTeams] = team;
                        numOfTeams++;
                    }
                }
            }
        }
        return numOfTeams;
    }
}
