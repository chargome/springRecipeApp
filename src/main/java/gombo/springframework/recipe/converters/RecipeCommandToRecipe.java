package gombo.springframework.recipe.converters;

import gombo.springframework.recipe.commands.RecipeCommand;
import gombo.springframework.recipe.models.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe>
{
    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand)
    {
        return null;
    }
}
