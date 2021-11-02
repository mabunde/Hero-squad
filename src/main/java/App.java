import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = Hero.all();
            List<Squad> squads = Squad.all();
            model.put("heroes", heroes);
            model.put("squads",squads);
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());

        post("/newHero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("hero_name");
            String heroAge = request.queryParams("hero_age");
            String heroAbility = request.queryParams("hero_ability");
            String heroWeakness = request.queryParams("hero_weakness");
            String heroSquad = request.queryParams("hero_squad");
            Squad newMember = Squad.find(Integer.parseInt(heroSquad));
            Hero newHero = new Hero(heroName,heroAge,heroAbility,heroWeakness,heroSquad);
            newMember.addHero(newHero);
            model.put("newMember", newMember);
            model.put("template", "hero.hbs");
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
