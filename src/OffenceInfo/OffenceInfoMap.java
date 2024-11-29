package OffenceInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class OffenceInfoMap<K,V> extends HashMap<String, OffenceInfo>{
    // default constructor
    public OffenceInfoMap(){
        super();
        genrateOffenceInfoMapFromTxtFile("OffenceInfo.txt");
    }

    /**
     * This function reads a text file and generates a map of offence information.
     * The text file should contain lines with comma-separated values representing offence code, description, and fine amount.
     * Each line is parsed and used to create an OffenceInfo object, which is then added to the map with the offence code as the key.
     *
     * @param txtFilePath The path to the text file containing offence information.
     * @throws FileNotFoundException If the specified file does not exist.
     */
    public void genrateOffenceInfoMapFromTxtFile(String txtFilePath){
        
        try{
            File file = new File(txtFilePath);
            if(!file.exists()){
                throw new FileNotFoundException("File not found\nPlease create a \"OffenceInfo.txt\" file with offence information");
            }
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] parts = line.split("," );
                OffenceInfo info = new OffenceInfo(Integer.parseInt(parts[0]), parts[1], Float.parseFloat(parts[2]));
                super.put(parts[0], info);
            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
    }
}


