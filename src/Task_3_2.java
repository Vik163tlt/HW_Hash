import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Task_3_2 {
    private int number1;
    private int number2;

    public Task_3_2(int firstNumber, int secondNumber) {
        this.number1 = firstNumber;
        this.number2 = secondNumber;
    }

    public static Task_3_2 getTasks(List<Integer> list) {
        Random random = new Random();
        int firstNumber = random.nextInt(list.size())+2;
        int secondNumber = random.nextInt(list.size())+2;
        Task_3_2 task = new Task_3_2(firstNumber, secondNumber);
        return task;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task_3_2 task = (Task_3_2) o;
        return number1 == task.number1 && number2 == task.number2 || number2 == task.number1 && number1 == task.number2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number1, number2);
    }

    @Override
    public String toString() {
        return number1 + "*" + number2 + "=?";

    }
}

