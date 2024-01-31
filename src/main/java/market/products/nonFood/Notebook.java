package market.products.nonFood;

import market.products.Product;

public class Notebook implements Product {

    /**
     * Получение имени товара
     * @return String
     */
    @Override
    public String getName() {
        return "Блокнот";
    }
}
