package memento;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private double totalValue;

    private Item currentItem;
    private List<Item> memento = new ArrayList<>();

    public Item getCurrentItem() {
        return this.currentItem;
    }

    public void setCurrentItem(Item item) {
        this.currentItem = item;
        this.memento.add(item);
    }

    public void restoreItem(int index) {
        if (index < 0 || index > this.memento.size() - 1) {
            throw new IllegalArgumentException("Invalid index");
        }
        this.currentItem = this.memento.get(index);
    }

    public List<Item> getItems() {
        return this.memento;
    }

}
