import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Recipe {
    private static Map<Product, Integer> products;
    private String name;

    public Recipe(HashMap<Product, Integer> products, String name) {
        for (Integer quantity : products.values()) {
            if (quantity <= 0) {
                quantity = 1;
            }
        }
        Recipe.products = products;
        this.name = name;
    }

    public static Map<Product, Integer> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public static double getTotalCost(HashMap<Product,Integer> map) {
        double totalCost = 0;
        for (Map.Entry<Product,Integer> entry :map.entrySet()){
            totalCost += entry.getKey().getPrice() * entry.getValue();
        }
        return totalCost;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return name.equals(recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, name);
    }
}

