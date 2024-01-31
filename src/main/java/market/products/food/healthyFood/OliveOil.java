package market.products.food.healthyFood;

public class OliveOil implements HealthyFood{

    @Override
    public String getName() {
        return "Оливковое масло";
    }

    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }
}
