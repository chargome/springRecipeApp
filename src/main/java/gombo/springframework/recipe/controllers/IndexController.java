package gombo.springframework.recipe.controllers;

import gombo.springframework.recipe.models.Category;
import gombo.springframework.recipe.models.UnitOfMeasure;
import gombo.springframework.recipe.repositories.CategoryRepository;
import gombo.springframework.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Controller
public class IndexController
{
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage()
    {
        log.debug("requesting index page");
        return "index";
    }
}
