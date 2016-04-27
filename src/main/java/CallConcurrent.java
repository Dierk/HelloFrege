import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CallConcurrent {

    private int counter = 0;

    private int doSomething(int i) {
        counter++;      // will have lost updates
        return i * i;
    }
    public static void main(String[] args) throws InterruptedException {
        final CallConcurrent self = new CallConcurrent();
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 49, 10, 3, 4, 7, 3, 49, 10, 3, 4, 7, 3, 4, 10);
        int sum = numbers.parallelStream()
                .mapToInt(self::doSomething)
                .sum();
        System.out.println("counter should be 20: " + self.counter);
    }
}
