package controller;

public enum CardName {
  MAIN_MENU("1"), PAUSE_MENU("2"), TOTAL_PANEL("3"), DEFEAT("4"), VICTORY("5"), LOADING_SCREEN("6");

  private final String name;

  CardName(final String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
  
  
}
