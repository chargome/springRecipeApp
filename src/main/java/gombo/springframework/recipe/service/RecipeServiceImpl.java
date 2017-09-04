package gombo.springframework.recipe.service;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.repositories.RecipeRepository;

import java.util.Set;

public class RecipeServiceImpl implements RecipeService
{
    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getAllRecipes()
    {
        return (Set<Recipe>) recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id)
    {
        return recipeRepository.findById(id).get();
    }
}
