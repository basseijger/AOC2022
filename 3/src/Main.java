import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Character> letters = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Character> badgeLetters = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/items.csv"));

        while(sc.hasNext()) {
            String line = sc.nextLine();
            int halfIndex = line.length() / 2;
            String[] parts = new String[]{line.substring(0,halfIndex),line.substring(halfIndex)};
            for (char p : parts[1].toCharArray()) {
                if(parts[0].contains(String.valueOf(p))) {
                    letters.add(p);
                    break;
                }
            }
            lines.add(line);
        }
        for (int i = 0; i < lines.size(); i+=3) {
            for (char c : lines.get(i).toCharArray()) {
                if(lines.get(i+1).contains(String.valueOf(c)) && lines.get(i+2).contains(String.valueOf(c))) {
                    badgeLetters.add(c);
                    break;
                }
            }
        }
        System.out.println("PART 1: " + letters.stream().mapToInt(Main::getCharValue).sum());
        System.out.println("PART 2: " + badgeLetters.stream().mapToInt(Main::getCharValue).sum());
    }
    public static int getCharValue(char c) {
        if(Character.isLowerCase(c)) {
            return (int)c - 96;
        }
        else {
            return (int)c - 38;
        }
    }
}
