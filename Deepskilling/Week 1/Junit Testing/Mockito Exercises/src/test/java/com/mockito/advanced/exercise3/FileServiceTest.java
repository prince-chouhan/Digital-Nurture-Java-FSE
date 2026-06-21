package com.mockito.advanced.exercise3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Advanced Exercise 3: Mocking File I/O
 */
public class FileServiceTest {

    @Test
    void testServiceWithMockFileIO() {
        FileReader mockFileReader = Mockito.mock(FileReader.class);
        FileWriter mockFileWriter = Mockito.mock(FileWriter.class);

        when(mockFileReader.read()).thenReturn("Mock File Content");

        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();

        assertEquals("Processed Mock File Content", result);
        verify(mockFileReader).read();
        verify(mockFileWriter).write("Processed Mock File Content");
    }

    @Test
    void testFileWriterReceivesProcessedContent() {
        FileReader mockFileReader = Mockito.mock(FileReader.class);
        FileWriter mockFileWriter = Mockito.mock(FileWriter.class);

        when(mockFileReader.read()).thenReturn("Raw Data");

        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        fileService.processFile();

        verify(mockFileWriter).write("Processed Raw Data");
    }
}
