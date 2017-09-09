package gombo.springframework.recipe.service;

import gombo.springframework.recipe.commands.RecipeCommand;
import gombo.springframework.recipe.models.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService
{
    Set<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
