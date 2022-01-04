import com.engeto.ukol11.DatabaseMethod;
import com.engeto.ukol11.Item;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        DatabaseMethod methods = new DatabaseMethod();
        methods.loadAllDB();
        methods.loadItemById(2);
        methods.loadAllAvailableItems();
        Item televize = new Item(6, "6666", "6000", "Televize", "s pořádnou uhlopříčkou", 8, BigDecimal.valueOf(12599.99));
        methods.saveItem(televize);
        methods.updatePrice(6, BigDecimal.valueOf(10599.99));
        methods.loadAllDB();

    }
}
