package gombo.springframework.recipe.controllers;

import gombo.springframework.recipe.commands.IngredientCommand;
import gombo.springframework.recipe.commands.RecipeCommand;
import gombo.springframework.recipe.models.Ingredient;
import gombo.springframework.recipe.service.IngredientService;
import gombo.springframework.recipe.service.RecipeService;
import gombo.springframework.recipe.service.UnitOfMeasureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IngredientControllerTest
{
    @Mock
    RecipeService recipeService;

    @Mock
    IngredientService ingredientService;

    @Mock
    UnitOfMeasureService unitOfMeasureService;

    IngredientController ingredientController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        ingredientController = new IngredientController(recipeService, ingredientService, unitOfMeasureService);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }


    @Test
    public void testGetList() throws Exception
    {
        //given
        RecipeCommand command = new RecipeCommand();
        Mockito.when(recipeService.getRecipeCommandById(anyLong())).thenReturn(command);

        //when
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));

        //then
        Mockito.verify(recipeService, Mockito.times(1)).getRecipeCommandById(anyLong());
    }

    @Test
    public void testShowIngredient() throws Exception
    {
        //given
        IngredientCommand ingredientCommand = new IngredientCommand();

        //when
        Mockito.when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).
                thenReturn(ingredientCommand);

        //then
        mockMvc.perform(get("/recipe/1/ingredient/2/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/show"))
                .andExpect(model().attributeExists("ingredient"));
    }

    @Test
    public void testUpdateIngredientForm() throws Exception
    {
        // given
        IngredientCommand ingredientCommand = new IngredientCommand();

        // when
        Mockito.when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);
        Mockito.when(unitOfMeasureService.listAllUoms()).thenReturn(new HashSet<>());

        // then
        mockMvc.perform(get("/recipe/1/ingredient/2/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/ingredientform"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uomList"));
    }

    @Test
    public void testNewIngredientForm() throws Exception
    {
        // given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        // when
        Mockito.when(recipeService.getRecipeCommandById(anyLong())).thenReturn(recipeCommand);
        Mockito.when(unitOfMeasureService.listAllUoms()).thenReturn(new HashSet<>());

        // then
        mockMvc.perform(get("/recipe/1/ingredient/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/ingredientform"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uomList"));

        Mockito.verify(recipeService, Mockito.times(1)).getRecipeCommandById(anyLong());
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);

        //when
        Mockito.when(ingredientService.saveIngredientCommand(any())).thenReturn(command);

        //then
        mockMvc.perform(post("/recipe/2/ingredient")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("description", "some string")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/ingredient/3/show"));

    }

    @Test
    public void testDeleteIngredient() throws Exception
    {
        // given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);

        // when
        mockMvc.perform(get("/recipe/2/ingredient/3/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:recipe/2/ingredients"));

        // then
        Mockito.verify(ingredientService, Mockito.times(1)).deleteById(anyLong(), anyLong());

    }

}