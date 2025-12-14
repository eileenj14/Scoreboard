import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> teams = new ArrayList<>(Arrays.asList("Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"));
        List<Integer> teamWins = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
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
                teamWins.set(index, teamWins.get(index) + 1);
            }
        }
        String teamWithMostWins = teams.getFirst();
        String teamWithLeastWins = teams.getFirst();
        int mostWins = teamWins.getFirst();
        int leastWins = teamWins.getFirst();
        for(int i = 1; i < 7; i++)
        {
            if(teamWins.get(i) > mostWins)
            {
                teamWithMostWins = teams.get(i);
                mostWins = teamWins.get(i);
            }
            if(teamWins.get(i) < leastWins)
            {
                teamWithLeastWins = teams.get(i);
                leastWins = teamWins.get(i);
            }
        }
        System.out.println(teamWithMostWins + " won the most games at " + mostWins + " wins.");
        System.out.println(teamWithLeastWins + " won the least games at " + leastWins + " wins.");
    }
}
