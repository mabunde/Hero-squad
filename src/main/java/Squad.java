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

    public Squad (String squad_name, String squad_size, String squad_cause){
        squadName = squad_name;
        maxSize = Integer.parseInt(squad_size);
        squadCause = squad_cause;
        instances.add(this);
        mId = instances.size();
        heroes = new ArrayList<Hero>();
        currentSize = 0;
    }
    public static List<Squad> all() {
        return instances;
    }
}
