public class FindMax {
    //Метод для поиска максимума
    public static double findMax(Box<? extends Number>[] boxes) {
        if (boxes == null || boxes.length == 0) {
            throw new IllegalArgumentException("Массив коробок не может быть пустым");
        }

        double max = Double.NEGATIVE_INFINITY;
        boolean found = false;

        for (Box<? extends Number> box : boxes) {
            if (box == null || box.isEmpty()) {
                continue;
            }

            Number number = box.take();
            if (number != null) {
                double value = number.doubleValue();
                if (value > max) {
                    max = value;
                    found = true;
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Ни одна коробка не содержит чисел");
        }

        return max;
    }
}
