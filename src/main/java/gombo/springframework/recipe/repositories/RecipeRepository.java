package gombo.springframework.recipe.repositories;

import gombo.springframework.recipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long>
{

}
