package gombo.springframework.recipe.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService
{

    @Override
    public void saveImageFile(long l, Object any)
    {
        log.debug("received a file");
    }
}
