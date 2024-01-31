package market;

import market.products.food.Food;
import market.products.nonFood.Notebook;
import market.products.nonFood.Pen;
import market.products.Product;
import market.products.food.healthyFood.Chicken;
import market.products.food.healthyFood.Fruit;
import market.products.food.healthyFood.OliveOil;
import market.products.food.semiFinished.Cheburek;
import market.products.food.semiFinished.DumplingsBerries;
import market.products.food.semiFinished.DumplingsMeat;
import market.products.food.snack.BalykCheese;
import market.products.food.snack.ChocolateBar;
import market.products.food.snack.Crisps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class UMarket {
    private final Collection<Product> products;

    /**
     * Конструктор
     */
    public UMarket() {
        this.products = new ArrayList<>();
        initializeProducts();
    }

    /**
     * Все товары в онлайн магазине
     */
    private void initializeProducts(){
        products.add(new Pen());
        products.add(new Notebook());

        products.add(new Chicken());
        products.add(new Fruit());
        products.add(new OliveOil());

        products.add(new BalykCheese());
        products.add(new Crisps());
        products.add(new ChocolateBar());

        products.add(new DumplingsBerries());
        products.add(new DumplingsMeat());
        products.add(new Cheburek());
    }

    /**
     * Печать продовольственных товаров
     * @param clazz класс товара
     * @param <T> тип товара
     */
    public <T extends Product> void printProducts(Class<T> clazz){
        int[] index = {1};

        products.stream()
                .filter(clazz::isInstance)
                .forEach(product -> {
                    if(Food.class.isAssignableFrom(product.getClass())){
                        Food foodProduct = (Food) product;
                        System.out.printf("[%d] %s (Белки: %s, Жиры: %s, Углеводы: %s)\n",
                                index[0]++,
                                product.getName(),
                                foodProduct.getProteins() ? "Да" : "Нет",
                                foodProduct.getFats() ? "Да" : "Нет",
                                foodProduct.getCarbohydrates() ? "Да" : "Нет");
                    }
                    else {
                        System.out.printf("[%d] %s\n", index[0]++, product.getName());
                    }
                });
    }

    /**
     * Получение товара по индексу
     * @param clazz класс товара
     * @param index индекс товара
     * @return любой товар из магазина
     * @param <T> тип товара
     */
    public <T extends Product> T getProductByIndex(Class<T> clazz, int index){
        AtomicInteger counter = new AtomicInteger(1);

        return products.stream()
                .filter(clazz::isInstance)
                .filter(product -> index == counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

    /**
     * Получение списка товаров
     * @param clazz класс товара
     * @return Collection<T>
     * @param <T> тип товара
     */
    public <T extends Product> Collection<T> getProducts(Class<T> clazz){
        return products.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .toList();
    }
}