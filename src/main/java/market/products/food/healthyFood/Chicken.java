package market.products.food.healthyFood;

public class Chicken implements HealthyFood{

    @Override
    public String getName() {
        return "Курица";
    }

    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }
}
