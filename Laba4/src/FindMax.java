public class FindMax {
    public static double findMax(Box<? extends Number>[] boxes) {
        if (boxes == null || boxes.length == 0) {
            throw new IllegalArgumentException("Массив коробок не может быть пустым");
        }

        double max = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < boxes.length; i++) {
            Box<? extends Number> box = boxes[i];
            if (box == null || box.isEmpty()) {
                throw new IllegalArgumentException("Коробка " + i + " пустая");
            }

            Number number = box.get();
            double value = number.doubleValue();

            putBack(box, number);

            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Number> void putBack(Box<T> box, Number number) {
        box.put((T) number);
    }
}