package gombo.springframework.recipe.controllers;

import gombo.springframework.recipe.commands.RecipeCommand;
import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/recipe/{id}/show")
    public String getRecipe(@PathVariable String id, Model model)
    {

        model.addAttribute("recipe", recipeService.getRecipeById(Long.valueOf(id)));

        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model)
    {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";

    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command)
    {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @PostMapping
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model)
    {
        RecipeCommand command = recipeService.getRecipeCommandById(Long.valueOf(id));
        model.addAttribute("recipe", command);

        return "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id, Model model)
    {
        log.debug("Deleting recipe with id: " + id);
        recipeService.deleteById(Long.valueOf(id));

        return "redirect:/";
    }


}
