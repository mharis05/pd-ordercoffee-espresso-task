package de.deliveryhero.mailordercoffeeshop.support;

public interface MilkTreatment {
    String STEAMED = "Steamed";
    String SOY = "Foamed";
    String WHIPPED = "Whipped";
    String SCALDED = "Scalded";
    String[] milkTypes = {STEAMED, SOY, WHIPPED, SCALDED};

    public String getRandomMilkType(String[] milkTypes);
}
