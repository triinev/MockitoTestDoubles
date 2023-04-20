import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MathApplicationTester {

    private MathApplication mathApplication;
    private CalculatorService calcService;

    @Test
    public void testAddAndSubtract(){

        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);

        when(calcService.add(15.0, 8.0)).thenReturn(23.0);
        when(calcService.subtract(15.0,8.0)).thenReturn(7.0);

        Assertions.assertEquals(mathApplication.add(15.0, 8.0), 23.0, 0);
        Assertions.assertEquals(mathApplication.subtract(15.0, 8.0), 7.0, 0);

        verify(calcService).add(15.0,8.0);
        verify(calcService).subtract(15.0, 8.0);

    }

}