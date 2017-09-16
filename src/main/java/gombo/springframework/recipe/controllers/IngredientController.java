package gombo.springframework.recipe.controllers;

import gombo.springframework.recipe.commands.IngredientCommand;
import gombo.springframework.recipe.commands.RecipeCommand;
import gombo.springframework.recipe.commands.UnitOfMeasureCommand;
import gombo.springframework.recipe.service.IngredientService;
import gombo.springframework.recipe.service.RecipeService;
import gombo.springframework.recipe.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController
{
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService)
    {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }


    @GetMapping("recipe/{id}/ingredients")
    public String getList(@PathVariable String id, Model model)
    {
        log.debug("Getting ingredientlist for recipe with id: " + id);
        model.addAttribute("recipe", recipeService.getRecipeCommandById(Long.valueOf(id)));
        return "recipe/ingredient/list";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String getShow(@PathVariable String recipeId ,@PathVariable String id, Model model)
    {
        model.addAttribute("ingredient", ingredientService.
                findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model)
    {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId),
                Long.valueOf(ingredientId)));

        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());

        return "recipe/ingredient/ingredientform";
    }

    @GetMapping("recipe/{recipeId}/ingredient/new")
    public String newRecipe(@PathVariable String recipeId, Model model)
    {
        RecipeCommand recipe = recipeService.getRecipeCommandById(Long.valueOf(recipeId));
        // todo: raise exception if recipe is null

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));

        model.addAttribute("ingredient", ingredientCommand);

        ingredientCommand.setUom(new UnitOfMeasureCommand());

        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());

        return "recipe/ingredient/ingredientform";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{ingredientId}/delete")
    public String deleteIngredient(@PathVariable String recipeId, @PathVariable String ingredientId)
    {
        ingredientService.deleteById(Long.valueOf(recipeId), Long.valueOf(ingredientId));

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }


    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command)
    {
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("Saving ingredient with id: " + command.getId());
        log.debug("From recipe with id: " + command.getRecipeId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
}
