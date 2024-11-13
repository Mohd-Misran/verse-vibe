package edu.isr.versevibe.utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static edu.isr.versevibe.constants.Constants.FILE_NOT_FOUND_MSG;
import static edu.isr.versevibe.constants.Constants.IO_EXCEPTION_MSG;

/**
 * Utility class for handling Input/Output operations. This class provides methods for initializing readers and writers,
 * as well as safely closing them. It also includes error logging.
 */
public class IOUtils {

    /**
     * Initializes a BufferedReader for the given file path.
     *
     * @param filePath the path of the file to be read
     * @return a BufferedReader object for the specified file
     * @throws FileNotFoundException if the file is not found
     */
    public static CSVReader initReader(final String filePath) throws FileNotFoundException {
        try {
            final CSVParser csvParser =
                    new CSVParserBuilder().withSeparator(',').withQuoteChar('"').withEscapeChar('\\').build();
            return new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(csvParser).build();
        } catch (FileNotFoundException exception) {
            final Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, FILE_NOT_FOUND_MSG, exception);
            throw exception;
        }
    }

    /**
     * Closes the given BufferedReader.
     *
     * @param csvReader the BufferedReader to be closed
     * @throws IOException if an I/O error occurs while closing the reader
     */
    public static void closeReader(final CSVReader csvReader) throws IOException {
        try {
            csvReader.close();
        } catch (IOException ioException) {
            final Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, IO_EXCEPTION_MSG, ioException);
            throw ioException;
        }
    }
}
