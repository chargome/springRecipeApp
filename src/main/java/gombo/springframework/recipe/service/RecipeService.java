package gombo.springframework.recipe.service;

import gombo.springframework.recipe.models.Recipe;

public interface RecipeService
{
    Iterable<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
}
