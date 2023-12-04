package task_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Card {
    private final Set<Integer> winningNumbers;

    private final Set<Integer> yourNumbers;

    public Card(String gameLine) {
        try {
            var parts = gameLine.replaceAll("  ", " ").split("\\|");

            this.winningNumbers = new HashSet<>(Arrays.stream(parts[0].strip().split(" ")).map(Integer::parseInt).toList());
            this.yourNumbers = new HashSet<>(Arrays.stream(parts[1].strip().split(" ")).map(Integer::parseInt).toList());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    private Set<Integer> getWinners() {
        return new HashSet<>(winningNumbers.stream().filter(yourNumbers::contains).toList());
    }

    public Integer getNumberWinners() {
        return getWinners().size();
    }


}
