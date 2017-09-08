package gombo.springframework.recipe.commands;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.models.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand
{
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure uom;
}
