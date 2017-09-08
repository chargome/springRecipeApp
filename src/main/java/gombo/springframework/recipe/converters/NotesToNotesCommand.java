package gombo.springframework.recipe.converters;

import gombo.springframework.recipe.commands.NotesCommand;
import gombo.springframework.recipe.models.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>
{
    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes notes)
    {
        return null;
    }
}
