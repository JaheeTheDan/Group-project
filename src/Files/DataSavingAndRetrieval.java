package Files;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import Date.Date;

public class DataSavingAndRetrieval {

    protected String filePath;
    protected int numberOfLines = 0;

    // Default constructor
    public DataSavingAndRetrieval() {
        this.filePath = "data.txt";
        try {
            File myObj = new File(filePath);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        setNumberOfLines();
    }

    // Primary constructor
    public DataSavingAndRetrieval(String filePath) {
        this.filePath = filePath;
        try {
            File myObj = new File(filePath);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        setNumberOfLines();
    }

    // Copy constructor
    public DataSavingAndRetrieval(DataSavingAndRetrieval obj) {
        this.filePath = obj.filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * Sets the number of lines in the file specified by the filePath.
     * This method reads the file line by line and increments a counter for each
     * line found.
     * The final count is then assigned to the numberOfLines attribute.
     *
     * @throws Exception If an error occurs while reading the file.
     *                   The error message and stack trace will be printed to the
     *                   console.
     *                   The program will then exit with a status code of 0.
     */
    protected void setNumberOfLines() {
        int totalLines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while (reader.readLine() != null) {
                totalLines++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
        this.numberOfLines = totalLines;
    }

    /**
     * Converts the given object into a string format suitable for saving to a file.
     * This method currently simply converts the object's toString() representation.
     * It also take a String representation of the object as a parameter (which is
     * already a string!) is itself returned.
     * It best recommends to have the String or object toString() method return a
     * one line string for best results.
     *
     * @param obj The object to be converted into a string.
     * @return A string representation of the given object.
     * @exception IllegalArgumentException if the given object have
     *                                     attributes(fields) that is not accessible
     *
     * @author Jaheem Shaw
     */
    protected String stringifyObject(Object obj) {
        return obj.toString();
    }

    /**
     * Parses the given string representation of an object into the actual object.
     * This method currently simply returns the input string as it is, as the
     * parseObject method is not implemented in the base class.
     *
     * @param objectString The string representation of the object to be parsed.
     * @return The parsed object. In this base class, it returns the input string as
     *         it is.
     *
     * @author Jaheem Shaw
     */
    protected Object parseObject(String objectString) {

        return objectString;
    }

    /**
     * Take the object and save the string representation of the object in one to
     * the file
     * specified by the filePath. If the file does not exist, it will be created.
     * If the file already exists, the data will be appended to the end of the file.
     * It best recommends to have the String or object toString() method return a
     * one line string for best results.
     *
     * @param obj An object of data to be saved to the file.
     * @throws Exception If an error occurs while writing to the file.
     * @author Jaheem Shaw
     */
    public void saveData(Object obj) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

            writer.write(stringifyObject(obj));
            writer.newLine();
            writer.close();
            numberOfLines++;

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
    }

    /**
     * Retrieves the data stored at the specified index in the file.
     *
     * This method reads the file line by line, stopping at the line at the
     * specified
     * index.
     * The method then parses the line into an object using the
     * {@link #parseObject(String)} method.
     * If the specified index is out of bounds, an {@link IndexOutOfBoundsException}
     * is thrown.
     *
     * @param index The index of the data to retrieve. The index starts from 0.
     * @return The object stored at the specified index in the file.
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws Exception                 If an error occurs while reading the file.
     *                                   The error message and stack trace will be
     *                                   printed to the
     *                                   console.
     *                                   The program will then exit with a status
     *                                   code of 0.
     */
    public Object retrieveDataInIndex(int index) {
        String line = "";
        try {
            int counter = 0;
            if (index < 0 || index >= numberOfLines) {
                throw new IndexOutOfBoundsException(
                        "Index " + index + " is out of bounds. Total lines: " + numberOfLines);
            }

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null && counter != index) {
                counter++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

        return parseObject(line);
    }

    /**
     * Removes the data stored at the specified index in the file.
     *
     * This method reads the file line by line, skipping the line at the specified
     * index.
     * Hence removing the data at the specified index
     * If the specified index is out of bounds, an {@link IndexOutOfBoundsException}
     * is thrown.
     *
     * @param index The index of the data to remove. The index starts from 0.
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws IOException               If an error occurs while reading or writing
     *                                   to the file.
     * @author Jaheem Shaw
     */
    public void removeDataInIndex(int index) {
        try {
            int counter = 0;

            if (index < 0 || index >= numberOfLines) {
                throw new IndexOutOfBoundsException(
                        "Index " + index + " is out of bounds. Total lines: " + numberOfLines);
            }

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter tempWriter = new BufferedWriter(new FileWriter("tempfile.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                if (counter != index) {
                    tempWriter.write(line + "\n");
                }
                counter++;
            }
            reader.close();
            tempWriter.close();

            File originalFile = new File(filePath);
            File tempFile = new File("tempfile.txt");
            originalFile.delete();
            tempFile.renameTo(originalFile);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
    }

    /**
     * Updates the data stored at the specified index in the file.
     *
     * This method reads the file line by line, replacing the line at the specified
     * index with the string representation of the provided data.
     * If the specified index is out of bounds, an {@link IndexOutOfBoundsException}
     * is thrown.
     * It best recommends to have the String or object toString() method return a
     * one line string for best results.
     *
     * @param index The index of the data to update. The index starts from 0.
     * @param data  The new data to be stored at the specified index.
     *
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws IOException               If an error occurs while reading or writing
     *                                   to the file.
     * @author Jaheem Shaw
     */
    public void updateDataInIndex(int index, Object data) {
        try {
            int counter = 0, totalLines = 0;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while (reader.readLine() != null) {
                totalLines++;
            }
            reader.close();

            if (index < 0 || index >= totalLines) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Total lines: " + totalLines);
            }

            reader = new BufferedReader(new FileReader(filePath));

            BufferedWriter tempWriter = new BufferedWriter(new FileWriter("tempfile.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                if (counter == index) {
                    tempWriter.write(stringifyObject(data));
                } else {
                    tempWriter.write(line);
                }
                tempWriter.newLine();
                counter++;
            }
            reader.close();
            tempWriter.close();

            File originalFile = new File(filePath);
            File tempFile = new File("tempfile.txt");
            originalFile.delete();
            tempFile.renameTo(originalFile);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
    }

    /**
     * Retrieves all the data stored in the file as an array of objects.
     *
     * This method reads the file line by line, parsing each line into an object
     * using the {@link #parseObject(String)} method.
     * The parsed objects are stored in an array, which is then returned.
     *
     * @return An array of objects containing all the data stored in the file.
     *         If the file is empty, an empty array is returned.
     *
     * @throws Exception If an error occurs while reading the file.
     *                   The error message and stack trace will be printed to the
     *                   console.
     *                   The program will then exit with a status code of 0.
     */
    public Object[] getAllData() {
        Object[] data = new Object[numberOfLines];
        int counter = 0;
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                data[counter] = parseObject(line);
                counter++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

        return data;
    }

    public static void main(String[] args) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        DataSavingAndRetrieval data = new DataSavingAndRetrieval("yeana.txt");
        Date date = new Date();
        data.stringifyObject(date);
        System.out.println(data.stringifyObject(date));
        data.saveData(date.toString());

        // data.removeDataInIndex(0);
        // System.out.println(data.retrieveDataInIndex(2));

    }
}
