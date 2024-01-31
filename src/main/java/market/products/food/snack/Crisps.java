package market.products.food.snack;

public class Crisps implements Snack {

    @Override
    public String getName() {
        return "Чипсы";
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
