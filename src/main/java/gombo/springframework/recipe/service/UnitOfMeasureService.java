package gombo.springframework.recipe.service;

import gombo.springframework.recipe.commands.UnitOfMeasureCommand;
import gombo.springframework.recipe.models.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService
{
    Set<UnitOfMeasureCommand> listAllUoms();
}
