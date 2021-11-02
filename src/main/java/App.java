import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //show all heroes and squads
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = Hero.all();
            List<Squad> squads = Squad.all();
            model.put("heroes", heroes);
            model.put("squads",squads);
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newHero",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newSquad",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


        //create a hero
//        post("/hero", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            String heroName = request.queryParams("hero_name");
//            String heroAge = request.queryParams("hero_age");
//            String heroAbility = request.queryParams("hero_ability");
//            String heroWeakness = request.queryParams("hero_weakness");
//            String heroSquad = request.queryParams("hero_squad");
//            Squad newMember = Squad.find(Integer.parseInt(heroSquad));
//            Hero newHero = new Hero(heroName,heroAge,heroAbility,heroWeakness,heroSquad);
//            newMember.addHero(newHero);
//            return new ModelAndView(model, "hero.hbs");
//        }, new HandlebarsTemplateEngine());

        post("/newHero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("hero_name");
            String heroAge = request.queryParams("hero_age");
            String heroAbility = request.queryParams("hero_ability");
            String heroWeakness = request.queryParams("hero_weakness");
            String heroSquad = request.queryParams("hero_squad");
            Hero newHero = new Hero(heroName, heroAge, heroAbility, heroWeakness, heroSquad);
            request.session().attribute("item",newHero);
            model.put("item",request.session().attribute("newHero"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/createSquad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squadName = request.queryParams("squad_name");
            String squadSize = request.queryParams("squad_size");
            String squadCause = request.queryParams("squad_cause");
            Squad newSquad = new Squad(squadName,squadSize,squadCause);
            model.put("item",request.session().attribute("newSquad"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


//



//        // create a squad
//        post("/createSquad", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            String squadName = request.queryParams("squad_name");
//            String squadSize = request.queryParams("squad_size");
//            String squadCause = request.queryParams("squad_cause");
//            model.put("template", " ");
//            return new ModelAndView(model, "squad.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("squads/:id", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            models.Squad squad = models.Squad.find(Integer.parseInt(request.params(":id")));
//            model.put("squad", squad);
//            model.put("heroes-in-squad",squad.getHeroes());
//            return new ModelAndView(model,"squad.hbs");
//        }, new HandlebarsTemplateEngine());

// get id of heroes
//        get("/heroes/:id",(request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            models.Hero hero = models.Hero.findHero(Integer.parseInt(request.params(":id")));
//            models.Squad squad = models.Squad.find(hero.getSquadId());
//            model.put("hero", hero);
//            model.put("squad",squad);
//            return new ModelAndView(model, " ");
//        }, new HandlebarsTemplateEngine());
//
//        get("heroes/new", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            model.put("squads", models.Squad.getSquads());
//            return new ModelAndView(model, " ");
//        }, new HandlebarsTemplateEngine());

//        get("/heroes/form", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            model.put("squads",models.Squad.getSquads());
//            return new ModelAndView(model, "HeroForm.hbs");
//        }, new HandlebarsTemplateEngine());
    }
}
