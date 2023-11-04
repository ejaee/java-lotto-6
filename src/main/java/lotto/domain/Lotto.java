package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Lotto implements Iterable<Integer> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateLotto(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateLotto(List<Integer> numbers) {
        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        int count = 0;

        for (Integer number : otherLotto) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto otherLotto = (Lotto) o;
        return Objects.equals(numbers, otherLotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
