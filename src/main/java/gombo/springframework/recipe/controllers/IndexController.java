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
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage()
    {
        return "index";
    }
}
