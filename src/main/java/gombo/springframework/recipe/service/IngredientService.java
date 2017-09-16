package gombo.springframework.recipe.service;

import gombo.springframework.recipe.commands.IngredientCommand;

public interface IngredientService
{
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);
    void deleteById(Long recipeId, Long ingredientId);
}
