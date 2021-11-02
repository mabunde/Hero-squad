package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String heroName;
    private String heroAge;
    private String heroAbility;
    private String heroWeakness;
    private String heroSquad;
    private static ArrayList<Hero> instances = new ArrayList<Hero>();

    public Hero(String hero_name, String hero_age, String ability, String weakness, String hero_squad){
        heroName = hero_name;
        heroAge = hero_age;
        heroAbility = ability;
        heroWeakness = weakness;
        heroSquad = hero_squad;
        instances.add(this);
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroAge() {
        return heroAge;
    }

    public void setHeroAge(String heroAge) {
        this.heroAge = heroAge;
    }

    public String getHeroAbility() {
        return heroAbility;
    }

    public void setHeroAbility(String heroAbility) {
        this.heroAbility = heroAbility;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }

    public void setHeroWeakness(String heroWeakness) {
        this.heroWeakness = heroWeakness;
    }

    public String getHeroSquad() {
        return heroSquad;
    }

    public void setHeroSquad(String heroSquad) {
        this.heroSquad = heroSquad;
    }

    public static List<Hero> all() {
        return instances;
    }

    public static void setInstances(List<Hero> all) {
        Hero.instances = instances;
    }
    public static void clear() {
        instances.clear();
    }

}