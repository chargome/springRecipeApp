package gombo.springframework.recipe.controllers;

import gombo.springframework.recipe.models.Category;
import gombo.springframework.recipe.models.UnitOfMeasure;
import gombo.springframework.recipe.repositories.CategoryRepository;
import gombo.springframework.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class IndexController
{
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository)
    {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage()
    {
        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Ounce");

        System.out.println("Cat id: " + category.get().getId());
        System.out.println("UOM id: " + unitOfMeasure.get().getId());


        return "index";
    }
}
