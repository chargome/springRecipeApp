package gombo.springframework.recipe.service;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;

public class RecipeServiceImplTest
{
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, null, null);
    }

    @Test
    public void getAllRecipes() throws Exception
    {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        Mockito.when(recipeService.getAllRecipes()).thenReturn(recipeData);


        Set<Recipe> recipes = recipeService.getAllRecipes();

        assertEquals(recipes.size(), 1);

        // Verify that the findAll method is only called once
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void getRecipeById()
    {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        Mockito.when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe findRecipe = recipeService.getRecipeById(1L);

        assertNotNull("Recipe returned null", findRecipe);

        Mockito.verify(recipeRepository, Mockito.times(1)).findById(anyLong());
        Mockito.verify(recipeRepository, Mockito.never()).findAll();

    }

}