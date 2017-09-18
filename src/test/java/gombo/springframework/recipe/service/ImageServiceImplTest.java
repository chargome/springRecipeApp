package gombo.springframework.recipe.service;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;

public class ImageServiceImplTest
{
    @Mock
    RecipeRepository recipeRepository;

    ImageService imageService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        imageService = new ImageServiceImpl(recipeRepository);
    }

    @Test
    public void saveImageFile() throws Exception
    {
        //given
        Long id = 1L;
        MultipartFile multipartFile = new MockMultipartFile("imagefile", "testing.txt",
                "text/plain", "Spring Framework Guru".getBytes());

        Recipe recipe = new Recipe();
        recipe.setId(id);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        Mockito.when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);

        // when
        imageService.saveImageFile(id, multipartFile);

        // then
        Mockito.verify(recipeRepository, Mockito.times(1)).save(argumentCaptor.capture());
        Recipe savedRecipe = argumentCaptor.getValue();
        assertEquals(multipartFile.getBytes().length, savedRecipe.getImage().length);
    }

}