public class Box <T> {
    private T item;

    //Конструкторы
    public Box() {
        this.item = null;
    }

    public Box(T something) {
        this.item = something;
    }

    //Помещает объект в коробку
    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка заполнена.");
        }
        this.item = item;
    }

    //Достает объект из коробки
    public T get() {
        T item = this.item;
        this.item = null;
        return item;
    }

    //Просматривает объект без извлечения
    public T take() {
        return this.item;
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
