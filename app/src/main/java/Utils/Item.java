package Utils;

import java.util.HashMap;
import java.util.Map;

public class Item {

    private int id = 0;
    private String name;
    private int position = -1;
    private ItemTypes type = ItemTypes.UNDEFINED;

    public Item(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("ID = %d NAME = %s", id, name);
    }

    public Map<String, String> toDict() {
        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        if (id != 0) {
            data.put("id", String.format("%d", id));
        }
        return data;
    }
}
