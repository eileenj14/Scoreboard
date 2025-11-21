import java.io.FileNotFoundException;
import java.io.File;
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
        System.out.println(read());
    }

    public static String read() throws FileNotFoundException
    {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] teams = new String[numOfTeams()];
        int[] teamWins = new int[numOfTeams()];
        while(s.hasNextLine())
        {
            Scanner ss = new Scanner(s.nextLine());
        }
        for(int i = 0; i < numOfTeams(); i++)
        {
            System.out.println(teams[i] + " " + teamWins[i]);
        }
        return null;
    }

    public static int numOfTeams() throws FileNotFoundException
    {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] teams = new String[25];
        teams[0] = s.next();
        int numOfTeams = 1;
        while(s.hasNext())
        {
            String team = s.next();
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
        return numOfTeams;
    }
}
