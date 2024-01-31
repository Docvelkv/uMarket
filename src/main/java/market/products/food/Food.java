package market.products.food;

import market.products.Product;

public interface Food extends Product {

    /**
     * Являются ли белки основой продукта
     * @return true/false
     */
    boolean getProteins();

    /**
     * Являются ли жиры основой продукта
     * @return true/false
     */
    boolean getFats();

    /**
     * Являются ли углеводы основой продукта
     * @return true/false
     */
    boolean getCarbohydrates();
}
