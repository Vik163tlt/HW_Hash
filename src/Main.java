import java.util.*;

public class Main {
    private static final Set<Product> products = new HashSet<>();

    static Set<Passport> passports = new HashSet<>();

    public static void main(String[] args) {

        //task Products

        Product pasta = new Product("Макароны", 68.50f, 2);
        Product milk = new Product("Молоко", 79.99f, 0);
        Product bananas = new Product("Бананы", 60.00f, 2);
        Product bread = new Product("Хлеб", 37.00f, 1);
        Product eggs = new Product("Яйца", 180.99f, 20);
        Product butter = new Product("Сливочное Масло", 180.00f, 1);

        //task Recipe

        HashMap<Product,Integer> sandwich = new HashMap<>();
        sandwich.put(bread, 2);
        sandwich.put(butter,1);

        HashMap<Product,Integer> omelet = new HashMap<>();
        omelet.put(milk,1);
        omelet.put(eggs,2);

        HashMap<Product,Integer> milkshake = new HashMap<>();
        milkshake.put(milk,1);
        milkshake.put(bananas,2);

        System.out.printf("Стоимость продуктов по рецепту = %.2f\n",Recipe.getTotalCost(sandwich));
        System.out.printf("Стоимость продуктов по рецепту = %.2f\n",Recipe.getTotalCost(omelet));
        System.out.printf("Стоимость продуктов по рецепту = %.2f\n",Recipe.getTotalCost(milkshake));

        //task Passport

        Passport ivan = new Passport("7737363833",
                "Иван",
                "Иванов",
                "Иванович",
                "07.09.1987");
        Passport sergey = new Passport("7736492021",
                "Сергей",
                "Сидоров",
                "Викторович",
                "20.11.1975");
        Passport anastasia = new Passport("7703855363",
                "Анастасия",
                "Петрова",
                "Александровна",
                "09.01.1998");
        Passport zinaida = new Passport("7716348434",
                "Зинаида",
                "Воронцова",
                "Семеновна",
                "11.11.1991");
        Passport vladimir = new Passport("5036749472",
                "Владимир",
                "Зюзин",
                "Яковлевич",
                "22.02.1992");


        passports.add(ivan);
        passports.add(sergey);
        passports.add(anastasia);
        passports.add(zinaida);

        System.out.println(passports);

        System.out.println(findPassport("5036749472"));
        addPassport(vladimir, passports);
        System.out.println(passports);


        //task 2_2 

        HashSet<Integer> randomNumbers = new HashSet<>(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randomNumbers.add(random.nextInt(1001));
        }
        System.out.println(randomNumbers);

        removeNonEvenNumbers(randomNumbers);

        System.out.println(randomNumbers);


        //task 3_2

        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);

        Set<Task_3_2> tasks = new HashSet<>(15);
        tasks.add(Task_3_2.getTasks(numbers));
        while (tasks.size() < 15) {
            if (!tasks.contains(Task_3_2.getTasks(numbers))) {
                tasks.add(Task_3_2.getTasks(numbers));
            }
        }

        System.out.println(tasks);
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (products.contains(product)) {
            throw new RuntimeException("Такой продукт уже есть в списке!");
        } else if (product.getName() == null || product.getPrice() <= 0 || product.getQuantity() <= 0) {
            throw new RuntimeException("Заполните карточку товара полностью!");
        } else {
            products.add(product);
        }
    }
    public void checkProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.setChecked();
                break;
            }
        }
    }
    public static void removeProduct(Product product) {
        products.remove(product);
    }
    public static Passport findPassport(String number) {
        for (Passport passport : passports) {
            if (number.equals(passport.getNumber())) {
                return passport;
            }
        }
        return null;
    }

    public static void addPassport(Passport passport, Set<Passport> set){
        Iterator<Passport> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNumber().equals(passport.getNumber())){
                iterator.remove();
            }
        }
        set.add(passport);

    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список продуктов:").append('\n');
        for (Product product : products) {
            stringBuilder.append(product).append('\n');
        }
        return stringBuilder.toString();
    }


    public static HashSet<Integer> removeNonEvenNumbers(HashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer text = iterator.next();
            if (text % 2 != 0) iterator.remove();
        }
        return set;
    }

    public int getRandomNumber() {
        int i = 2 + (int) (Math.random() * 10);
        return i;
    }

}
