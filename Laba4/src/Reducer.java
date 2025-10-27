import java.util.List;

public class Reducer {
    //Метод для сокращения
    public static <T> T reduce(List<T> list, Reduce<T> reducer, T initialValue) {
        T result = initialValue;
        for (T item : list) {
            result = reducer.reduce(result, item);
        }
        return result;
    }
}
