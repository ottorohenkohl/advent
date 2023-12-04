package task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final File file = new File("task_1/task.txt");

    private static final List<AbstractMap.SimpleEntry<Integer, Integer>> cards = new ArrayList<>();

    public static void main(String[] args) {
        try {
            var scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                cards.add(new AbstractMap.SimpleEntry<>(new Card(scanner.nextLine().split(":")[1]).getNumberWinners(), 1));
            }

            for (int i = 0; i < cards.size(); i++) {
                for (int j = 0; j < cards.get(i).getValue(); j++) {
                    for (int k = 1; k <= cards.get(i).getKey(); k++) {
                        cards.get(i + k).setValue(cards.get(i + k).getValue() + 1);
                    }
                }
            }

            System.out.println(cards.stream().map(AbstractMap.SimpleEntry::getValue).reduce(0, Integer::sum));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
