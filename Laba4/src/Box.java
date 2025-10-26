public class Box <T> {
    private T item;

    public Box() {
        this.item = null;
    }

    public Box(T something) {
        this.item = something;
    }

    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена. Нельзя разместить новый объект.");
        }
        this.item = item;
    }

    public T get() {
        T item = this.item;
        this.item = null;
        return item;
    }

    public boolean isEmpty () {
        return this.item == null;
    }

    @Override
    public String toString() {
        if (item == null) {
            return "Внутри: пусто";
        }

        return "Внутри: " + item;
    }
}
