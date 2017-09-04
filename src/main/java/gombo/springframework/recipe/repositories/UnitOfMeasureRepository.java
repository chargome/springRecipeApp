package gombo.springframework.recipe.repositories;

import gombo.springframework.recipe.models.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>
{
    Optional<UnitOfMeasure> findByDescription(String description);
}
