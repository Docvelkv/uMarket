package market.products.food.healthyFood;

public class Fruit implements HealthyFood{

    @Override
    public String getName() {
        return "Фрукты";
    }

    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }
}
