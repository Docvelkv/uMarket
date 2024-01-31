package market.products.food.semiFinished;

public class DumplingsMeat implements SemiFinishedFood{

    @Override
    public String getName() {
        return "Пельмени";
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
