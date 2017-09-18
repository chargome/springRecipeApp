package gombo.springframework.recipe.service;

import gombo.springframework.recipe.models.Recipe;
import gombo.springframework.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService
{
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long l, MultipartFile file)
    {

        try
        {
            Recipe recipe = recipeRepository.findById(l).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int test = file.getBytes().length;

            int i = 0;

            for (byte b: file.getBytes())
            {
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);

        }
        catch (IOException e)
        {
            // todo handle better
            log.error("error ocurred");
            e.printStackTrace();
        }
    }
}
