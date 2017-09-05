package gombo.springframework.recipe.controllers;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class RecipeController
{
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipes")
    public String getRecipes(Model model)
    {
        log.debug("requesting recipes page");

        Iterable<Recipe> allRecipes = recipeService.getAllRecipes();

        model.addAttribute("allRecipes", allRecipes);

        return "allRecipes";
    }
}
