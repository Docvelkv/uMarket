package market.products.food.semiFinished;

public class Cheburek implements SemiFinishedFood{

    @Override
    public String getName() {
        return "Чебурек";
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
