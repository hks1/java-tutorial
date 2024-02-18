package com.tutorial.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        Assertions.assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5, mock.size());
        Assertions.assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("testString");
        Assertions.assertEquals("testString", mock.get(0));
    }

    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("value1");
        Assertions.assertEquals("value1", mock.get(0));
        Assertions.assertEquals("value1", mock.get(1));
    }

    @Test
    public void verificationBasics(){
        // SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        // verify
        verify(mock, times(2)).get(anyInt());

    }
}
