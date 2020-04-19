package de.deliveryhero.mailordercoffeeshop.support;

import java.util.Random;

public class TestData implements MilkTreatment, MilkSelection {
    public MilkTreatment milkTreatmentObject;
    public MilkSelection milkSelectionObject;
    private UserData userData;
    private Integer espressoShotCount;
    private String milkTreatment;
    private String milkType;

    public UserData getUserData() {
        return userData;
    }

    public Integer getEspressoShotCount() {
        return espressoShotCount;
    }


    public String getMilkTreatment() {
        return milkTreatment;
    }

    public TestData() {
        Random rand = new Random();
        this.userData = new UserData();
        this.espressoShotCount = rand.nextInt(3) + 1;
        this.milkType = getRandomMilkType(MilkTreatment.milkTypes);
        this.milkTreatment = getRandomMilkSelection(MilkSelection.milkSelections);
    }

    @Override
    public String getRandomMilkType(String[] milkTypes) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(MilkTreatment.milkTypes.length);
        return MilkTreatment.milkTypes[randomIndex];
    }

    @Override
    public String getRandomMilkSelection(String[] milkSelections) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(MilkSelection.milkSelections.length);
        return MilkSelection.milkSelections[randomIndex];
    }
}
