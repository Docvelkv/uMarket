package market.products.food.snack;

public class ChocolateBar implements Snack {

    @Override
    public String getName() {
        return "Шоколадный батончик";
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
