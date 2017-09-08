package gombo.springframework.recipe.converters;

import gombo.springframework.recipe.commands.IngredientCommand;
import gombo.springframework.recipe.models.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient>
{
    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand)
    {
        return null;
    }
}
