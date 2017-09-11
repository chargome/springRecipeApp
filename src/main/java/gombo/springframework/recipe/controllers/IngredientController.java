package gombo.springframework.recipe.controllers;

import gombo.springframework.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientController
{
    private RecipeService recipeService;

    public IngredientController(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }


    @GetMapping
    @RequestMapping("recipe/{id}/ingredients")
    public String getList(@PathVariable String id, Model model)
    {
        log.debug("Getting ingredientlist for recipe with id: " + id);
        model.addAttribute("recipe", recipeService.getRecipeCommandById(Long.valueOf(id)));
        return "recipe/ingredient/list";
    }
}