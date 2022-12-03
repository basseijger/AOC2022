import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> elveNumbers = new ArrayList<>();
        Scanner sc = new Scanner(new File("calories.csv"));
        int currentNumber = 0;
        while(sc.hasNext()) {
            String next = sc.nextLine();
            if(!Objects.equals(next, "")) {;
                currentNumber += Integer.parseInt(next);
            }
            else {
                elveNumbers.add(currentNumber);
                currentNumber = 0;
            }
        }
        elveNumbers.sort(Integer::compareTo);
        System.out.println(elveNumbers.get(elveNumbers.size()-1) + elveNumbers.get(elveNumbers.size()-2) + elveNumbers.get(elveNumbers.size() -3));
    }
}
