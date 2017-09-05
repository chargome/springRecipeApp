package gombo.springframework.recipe.service;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService
{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> getAllRecipes()
    {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id)
    {
        return recipeRepository.findById(id).get();
    }
}
