package gombo.springframework.recipe.models;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    //large binary object
    @Lob
    private String recipeNotes;

    public Notes()
    {
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof Notes;
    }

}
