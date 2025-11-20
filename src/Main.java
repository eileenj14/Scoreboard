import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
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
        teams();
    }

    public static void teams() throws FileNotFoundException
    {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String[] teams = new String[1];
        teams[0] = s.next();
        while(s.hasNext())
        {
            String team = s.next();
            for(int i = 0; i < teams.length; i++)
            {
                if(team == teams[i]) break;
                if((i + 1) == teams.length)
                {
                    int newSize = teams.length + 1;
                    teams = Arrays.copyOf(teams, newSize);
                    teams[teams.length - 1] = team;
                }
            }
        }
        for(int i = 0; i < teams.length; i++)
        {
            System.out.println(i + " " + teams[i]);
        }
    }
}
