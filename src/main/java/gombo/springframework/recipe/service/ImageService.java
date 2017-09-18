package gombo.springframework.recipe.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService
{
    void saveImageFile(Long l, MultipartFile file);
}
