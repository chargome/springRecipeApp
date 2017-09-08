package gombo.springframework.recipe.controllers;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest
{
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    RecipeController recipeController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        this.recipeController = new RecipeController(recipeService);
    }

    @Test
    public void testgetRecipe() throws Exception
    {
        Recipe recipe  = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        Mockito.when(recipeService.getRecipeById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }

}