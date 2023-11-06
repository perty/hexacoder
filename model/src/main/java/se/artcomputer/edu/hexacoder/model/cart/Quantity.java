package se.artcomputer.edu.hexacoder.model.cart;

public record Quantity(int value) {
    public Quantity {
        if (value < 1) {
            throw new IllegalArgumentException("Value must be positive integer: '" + value + "'.");
        }
    }

    public Quantity add(Quantity augend) {
        return new Quantity(value + augend.value);
    }
}
