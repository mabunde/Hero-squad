import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private int maxSize;
    private String squadCause;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int mId;
    private List<Hero> heroes;
    private int currentSize;

    public Squad (String squad_name, int squad_size, String squad_cause){
        squadName = squad_name;
        maxSize = squad_size;
        squadCause = squad_cause;
        instances.add(this);
        mId = instances.size();
        heroes = new ArrayList<Hero>();
        currentSize = 0;
    }
    public static List<Squad> all() {

        return instances;
    }
    public static Squad find(int id) {
        return instances.get(id - 1);
    }
    public static void clear() {
        instances.clear();
    }
    public List<Hero> getHeroes() {
        return heroes;
    }
    public void addHero(Hero newHero){
        heroes.add(newHero);
        currentSize++;
    }
}
