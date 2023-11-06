package se.artcomputer.edu.hexacoder.model.money;

import se.artcomputer.edu.hexacoder.model.money.Money;

import java.util.Currency;

public class TestMoneyFactory {

  private static final Currency EUR = Currency.getInstance("EUR");
  private static final Currency USD = Currency.getInstance("USD");

  public static Money euros(int euros, int cents) {
    return Money.of(EUR, euros, cents);
  }

  public static Money usDollars(int dollars, int cents) {
    return Money.of(USD, dollars, cents);
  }
}