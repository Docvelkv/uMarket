package market;

import market.products.food.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart <T extends Food>{

    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;
    private static final Scanner scan = new Scanner(System.in);

    /**
     * Конструктор
     * @param market онлайн магазин
     * @param clazz класс товара
     */
    public Cart(UMarket market, Class<T> clazz) {
        this.market = market;
        this.clazz = clazz;
        foodstuffs = new ArrayList<>();
    }

    /**
     * Получение продовольственных товаров
     * @return Collection<T>
     */
    public Collection<T> getFoodstuffs(){
        return foodstuffs;
    }

    /**
     * Печать продовольственных товаров
     */
    public void printFoodstuffs(){
        AtomicInteger index = new AtomicInteger(1);

        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s, Жиры: %s, Углеводы: %s)\n",
                        index.getAndIncrement(),
                        food.getName(),
                        food.getProteins() ? "Да" : "Нет",
                        food.getFats() ? "Да" : "Нет",
                        food.getCarbohydrates() ? "Да" : "Нет"));
    }

    /**
     * Создание новой корзины
     * @param market Онлайн магазин
     * @param clazz класс товара
     * @param <T> тип товара
     */
    public static <T extends  Food> void CreateCart(UMarket market, Class<T> clazz){
        Cart<T> cart = new Cart<>(market, clazz);
        while(true){
            System.out.println("[0] Завершение формирования корзины + балансировка.");
            System.out.println("Список доступных товаров:");
            market.printProducts(clazz);
            System.out.print("Выберите пункт меню: ");
            if(scan.hasNextInt()){
                int menuItem = scan.nextInt();
                scan.nextLine();
                if(menuItem == 0){
                    cart.cartBalancing();
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodstuffs();
                    return;
                }
                else{
                    T product = market.getProductByIndex(clazz, menuItem);
                    if(product == null){
                        System.out.println("""
                            Некорректный ввод товара.
                            Пожалуйста повторите попытку ввода.
                        """);
                        continue;
                    }
                    cart.getFoodstuffs().add(product);
                    System.out.println("Товар успешно добавлен в корзину.");
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodstuffs();
                    System.out.println("==========");
                }
            }
            else {
                System.out.println("""
                    Некорректный пункт меню.
                    Пожалуйста, повторите попытку ввода.
                    """);
                scan.nextLine();
            }
        }
    }

    /**
     * Балансировка корзины
     */
    public void cartBalancing(){
        final boolean[] nutrients = new boolean[]{false, false, false};

        // Определение, какие питательные вещества уже содержатся в корзине
        foodstuffs.stream()
                .filter(clazz::isInstance)
                .forEach(x -> {
            if(!nutrients[0] && x.getProteins()) nutrients[0] = true;
            if(!nutrients[1] && x.getFats()) nutrients[1] = true;
            if(!nutrients[2] && x.getCarbohydrates()) nutrients[2] = true;
        });

        if(nutrients[0] && nutrients[1] && nutrients[2]){
            System.out.print("""
            Корзина сбалансирована по БЖУ.
            ==========
            """);
            return;
        }

        // Добавление тех питательных веществ, которых в корзине нет (балансировка)
        market.getProducts(clazz).stream()
                .filter(clazz::isInstance)
                .forEach(x -> {
            if(!nutrients[0] && x.getProteins()) {
                nutrients[0] = true;
                foodstuffs.add(x);
            }
            if(!nutrients[1] && x.getFats()) {
                nutrients[1] = true;
                foodstuffs.add(x);
            }
            if(!nutrients[2] && x.getCarbohydrates()) {
                nutrients[2] = true;
                foodstuffs.add(x);
            }
        });

        if(nutrients[0] && nutrients[1] && nutrients[2])
            System.out.print("""
                            Корзина сбалансирована по БЖУ.
                            ==========
                            """);
        else System.out.print("""
                            Невозможно сбалансировать корзину по БЖУ
                            ==========
                            """);
    }
}
