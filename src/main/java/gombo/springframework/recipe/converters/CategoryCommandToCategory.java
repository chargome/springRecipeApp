package gombo.springframework.recipe.converters;

import gombo.springframework.recipe.commands.CategoryCommand;
import gombo.springframework.recipe.models.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>
{
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand)
    {
        return null;
    }
}
