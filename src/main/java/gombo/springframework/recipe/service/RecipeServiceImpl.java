package gombo.springframework.recipe.service;

import gombo.springframework.recipe.commands.RecipeCommand;
import gombo.springframework.recipe.converters.RecipeCommandToRecipe;
import gombo.springframework.recipe.converters.RecipeToRecipeCommand;
import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService
{
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand)
    {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
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

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command)
    {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved recipe with id: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }


    @Override
    @Transactional
    public RecipeCommand getRecipeCommandById(Long aLong)
    {
        Optional<Recipe> recipeOptional = recipeRepository.findById(aLong);

        if (!recipeOptional.isPresent())
        {
            throw new RuntimeException("Recipe not found!");
        }

        return recipeToRecipeCommand.convert(recipeOptional.get());
    }

    @Override
    public void deleteById(Long idToDelete)
    {
        recipeRepository.deleteById(idToDelete);
    }
}
