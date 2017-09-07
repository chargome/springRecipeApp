package gombo.springframework.recipe.service;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService
{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getAllRecipes()
    {
        log.debug("Recipe service starting");

        Set<Recipe> recipes = new HashSet<>();

        this.recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

        return recipes;
    }

    @Override
    public Recipe getRecipeById(Long id)
    {
        Optional<Recipe> findRecipe = recipeRepository.findById(id);

        if (!findRecipe.isPresent())
        {
            throw new RuntimeException("Recipe Not Found!");
        }

        return findRecipe.get();
    }
}
