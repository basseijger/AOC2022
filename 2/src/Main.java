import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int totalPoints = 0;
        int totalPoints2 = 0;

        Scanner sc = new Scanner(new File("src/rps.csv"));
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            String yours = split[1];
            String ending = split[1];
            String theirs = split[0];
            totalPoints += calculatePoints(yours, theirs);
            totalPoints2 += calculatePoints2(ending,theirs);
        }
        System.out.println("Part 1: " + totalPoints);
        System.out.println("Part 2: " + totalPoints2);
    }

    public static int calculatePoints(String yours, String theirs) {
        int points = 0;
        yours = yours.replace("X", "rock");
        yours = yours.replace("Y", "paper");
        yours = yours.replace("Z", "scissors");

        theirs = theirs.replace("A", "rock");
        theirs = theirs.replace("B", "paper");
        theirs = theirs.replace("C", "scissors");

        if(yours.equals(theirs)) {
            points = 3;
        }
        else if (yours.equals("rock") && theirs.equals("scissors") || yours.equals("paper") && theirs.equals("rock") || yours.equals("scissors") && theirs.equals("paper")) {
            points = 6;
        }

        switch (yours) {
            case "rock" -> points += 1;
            case "paper" -> points += 2;
            case "scissors" -> points += 3;
        }

        return points;
    }

    public static int calculatePoints2(String ending, String theirs) {
        ending = ending.replace("X", "lose");
        ending = ending.replace("Y", "draw");
        ending = ending.replace("Z", "win");

        theirs = theirs.replace("A", "rock");
        theirs = theirs.replace("B", "paper");
        theirs = theirs.replace("C", "scissors");

        String yours = "";

        if(ending.equals("draw")) {
            yours = theirs;
        }
        else if(ending.equals("win")) {
            yours = switch (theirs) {
                case "rock" -> "paper";
                case "paper" -> "scissors";
                case "scissors" -> "rock";
                default -> yours;
            };
        }
        else {
            yours = switch (theirs) {
                case "rock" -> "scissors";
                case "paper" -> "rock";
                case "scissors" -> "paper";
                default -> yours;
            };
        }
        return calculatePoints(yours,theirs);
    }
}
