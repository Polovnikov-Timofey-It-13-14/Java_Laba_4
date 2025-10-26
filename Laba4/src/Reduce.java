@FunctionalInterface
public interface Reduce <T> {
    T reduce(T accumulator, T current);
}