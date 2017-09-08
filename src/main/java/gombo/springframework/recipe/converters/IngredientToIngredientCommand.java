package gombo.springframework.recipe.converters;

import gombo.springframework.recipe.commands.IngredientCommand;
import gombo.springframework.recipe.models.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand>
{
    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient)
    {
        return null;
    }
}
