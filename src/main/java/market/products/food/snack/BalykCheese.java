package market.products.food.snack;

public class BalykCheese implements Snack {

    @Override
    public String getName() {
        return "Сыр (Балык)";
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
