public class CompareNumber implements Compare<CompareNumber> {
    private int value;

    public CompareNumber(int value) {
        this.value = value;
    }

    @Override
    public int compare(CompareNumber other) {
        return this.value - other.value;
    }

    public int getValue() {
        return value;
    }
}