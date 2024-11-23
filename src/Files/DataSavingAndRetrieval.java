package Files;

import java.io.*;

public class DataSavingAndRetrieval {

    private String filePath;

    public DataSavingAndRetrieval() {
        this.filePath = "data.txt";
    }

    public DataSavingAndRetrieval(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    /**
     * Saves the given object's string representation to the file specified by filePath.
     * If the file does not exist, it will be created. If the file already exists, the new data will be appended.
     *
     * @param obj The object to be saved. Its string representation will be written to the file.
     * @throws IOException If an error occurs while writing to the file.
     * @author Jaheem Shaw
     */
    public void saveData(Object obj) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

            writer.write(obj.toString());
            writer.newLine();
            writer.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    /**
     * Retrieves the data stored at the specified index in the file.
     * If the specified index is out of bounds, an {@link IndexOutOfBoundsException} is thrown.
     *
     * @param index The index of the data to retrieve. The index starts from 0.
     * @return The String form of the data stored at the specified index.
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws IOException If an error occurs while reading or writing to the file.
     * @author Jaheem Shaw
     */
    public String retrieveDataInIndex(int index) {
        String line = "";
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
            while ((line = reader.readLine()) != null && counter != index) {
                counter++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }

        return line;
    }


    /**
     * Removes the data stored at the specified index in the file.
     *
     * This method reads the file line by line, skipping the line at the specified index.
     * Hence removing the data at the specified index 
     * If the specified index is out of bounds, an {@link IndexOutOfBoundsException} is thrown.
     *
     * @param index The index of the data to remove. The index starts from 0.
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws IOException If an error occurs while reading or writing to the file.
     * @author Jaheem Shaw
     */
    public void removeDataInIndex(int index) {
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

            try (BufferedWriter tempWriter = new BufferedWriter(new FileWriter("tempfile.txt", true))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (counter != index) {
                        tempWriter.write(line);
                    }
                    tempWriter.newLine();
                    counter++;
                }
                reader.close();
                tempWriter.close();
            }

            File originalFile = new File(filePath);
            File tempFile = new File("tempfile.txt");
            originalFile.delete();
            tempFile.renameTo(originalFile);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
    }


    /**
     * Updates the data stored at the specified index in the file with the given object's string representation.
     * If the specified index is out of bounds, an {@link IndexOutOfBoundsException} is thrown.
     *
     * This method reads the file line by line, replacing the line at the specified index with the given object's string representation.
     *
     * @param index The index of the data to update. The index starts from 0.
     * @param obj The object whose string representation will replace the data at the specified index.
     * @throws IndexOutOfBoundsException If the specified index is out of bounds.
     * @throws IOException If an error occurs while reading or writing to the file.
     * @author Jaheem Shaw
     */
    public void updateDataInIndex(int index, Object obj) {
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

            try (BufferedWriter tempWriter = new BufferedWriter(new FileWriter("tempfile.txt", true))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (counter == index) {
                        tempWriter.write(obj.toString());
                    } else {
                        tempWriter.write(line);
                    }
                    tempWriter.newLine();
                    counter++;
                }
                reader.close();
                tempWriter.close();
            }

            File originalFile = new File(filePath);
            File tempFile = new File("tempfile.txt");
            originalFile.delete();
            tempFile.renameTo(originalFile);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
    }


    public static void main(String[] args) {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        DataSavingAndRetrieval data = new DataSavingAndRetrieval();


    }
}
