package memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void shouldAddItemsToCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCurrentItem(new Item("PS5", 4000));
        shoppingCart.setCurrentItem(new Item("Joystick", 300));
        shoppingCart.setCurrentItem(new Item("Keyboard", 60));
        assertEquals(3, shoppingCart.getItems().size());
    }

    @Test
    void shouldReturnToInitialItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCurrentItem(new Item("PS5", 4000));
        shoppingCart.setCurrentItem(new Item("Joystick", 300));
        shoppingCart.setCurrentItem(new Item("Keyboard", 60));

        shoppingCart.restoreItem(0);
        assertEquals("PS5", shoppingCart.getCurrentItem().getName());
    }

    @Test
    void shouldReturnToPreviousItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCurrentItem(new Item("PS5", 4000));
        shoppingCart.setCurrentItem(new Item("Joystick", 300));
        shoppingCart.setCurrentItem(new Item("Keyboard", 60));
        shoppingCart.setCurrentItem(new Item("Smartphone", 1400));

        shoppingCart.restoreItem(2);
        assertEquals("Keyboard", shoppingCart.getCurrentItem().getName());
    }

    @Test
    void shouldThrowExceptionForInvalidIndex() {
        try {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.restoreItem(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index", e.getMessage());
        }
    }

}
