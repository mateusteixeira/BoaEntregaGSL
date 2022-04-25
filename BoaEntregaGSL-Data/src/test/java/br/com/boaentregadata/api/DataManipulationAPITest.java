package br.com.boaentregadata.api;

import br.com.boaentregadata.service.DataManipulationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class DataManipulationAPITest {

    @Mock
    private DataManipulationService dataManipulationService;

    @InjectMocks
    private DataManipulationAPI dataManipulationAPI;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_call_service() {
        dataManipulationAPI.getDataManipulationMethods();
        verify(dataManipulationService).getDataManipulation();
    }

}