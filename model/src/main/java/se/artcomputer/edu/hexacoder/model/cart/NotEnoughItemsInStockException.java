package se.artcomputer.edu.hexacoder.model.cart;

public class NotEnoughItemsInStockException extends Exception {
    private final int itemsInStock;

    public NotEnoughItemsInStockException(String message, int itemsInStock) {
        super(message);
        this.itemsInStock = itemsInStock;
    }

    public int itemsInStock() {
        return itemsInStock;
    }
}
