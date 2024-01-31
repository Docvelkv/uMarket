package market.products.food.semiFinished;

public class DumplingsBerries implements SemiFinishedFood{

    @Override
    public String getName() {
        return "Вареники с ягодами";
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
