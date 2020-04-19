package de.deliveryhero.mailordercoffeeshop.support;

public interface MilkSelection {
//    String NOMILK = "No milk";
    String SOY = "Soy";
    String LOWFAT = "Low fat";
    String HALFHALF = "Half & half";
    String CREAM = "Cream";
    String CUSTOM = "Custom %";
    String[] milkSelections = {SOY, LOWFAT, HALFHALF, CREAM};

    public String getRandomMilkTreatment(String[] milkSelections);
}
