package gombo.springframework.recipe.service;

import gombo.springframework.recipe.models.Recipe;

import java.util.Set;

public interface RecipeService
{
    Set<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
}
