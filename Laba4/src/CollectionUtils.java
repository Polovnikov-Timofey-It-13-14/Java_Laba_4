import java.util.*;

public class CollectionUtils {
    public static <T, P> P collect(
            List<T> list,
            Collector<P, T> collector,
            Accumulator<P, T> accumulator) {

        P result = collector.createCollection();
        for (T item : list) {
            accumulator.accumulate(result, item);
        }
        return result;
    }
}