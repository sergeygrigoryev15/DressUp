package Utils;

public enum ItemTypes {
    UNDEFINED(-1),
    CATEGORY(0),
    SUB_CATEGORY(1),
    ITEM(2);
    int number;

    ItemTypes(final int number) {
        this.number = number;
    }

    public int getValue() {
        return this.number;
    }
}
