package gombo.springframework.recipe.service;

import gombo.springframework.recipe.commands.UnitOfMeasureCommand;
import gombo.springframework.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import gombo.springframework.recipe.models.UnitOfMeasure;
import gombo.springframework.recipe.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class UnitOfMeasureServiceImplTest
{
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    UnitOfMeasureService unitOfMeasureService;

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUoms() throws Exception
    {
        // given

        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();

        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        // when
        Mockito.when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        Set<UnitOfMeasureCommand> commands = unitOfMeasureService.listAllUoms();

        // then

        assertEquals(2, commands.size());
        Mockito.verify(unitOfMeasureRepository, Mockito.times(1)).findAll();
    }

}