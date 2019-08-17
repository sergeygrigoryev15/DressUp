package Utils;

public enum DbTables {
    ITEMS("Items"),
    OUTFITS("Outfits");
    private String value;

    DbTables(final String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
}
