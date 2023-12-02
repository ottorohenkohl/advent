package task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private static final File file = new File("task_2/task.txt");
    
    public static void main(String[] args) {
        try {
            var scanner = new Scanner(file);
            var games = new ArrayList<Game>();
            
            while (scanner.hasNextLine()) {
                games.add(new Game(scanner.nextLine()));
            }
            
            System.out.println(games.stream().map(Game::powerMinimum).reduce(0, Integer::sum));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
