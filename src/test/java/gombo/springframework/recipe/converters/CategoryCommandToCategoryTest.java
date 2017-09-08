package gombo.springframework.recipe.converters;

import gombo.springframework.recipe.commands.CategoryCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest
{
    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception
    {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject()
    {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject()
    {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert()
    {

    }


}