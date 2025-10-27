public class Box <T> {
    private T item;
    
    //Конструкторы
    public Box() {
        this.item = null;
    }

    public Box(T something) {
        this.item = something;
    }

    //Метод для складывания предметов в коробку
    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена. Нельзя разместить новый объект.");
        }
        this.item = item;
    }

    //Метод для получения предмета из коробки
    public T get() {
        T item = this.item;
        this.item = null;
        return item;
    }

    //Проверка на пустоту
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
