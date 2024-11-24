package Files;

import java.io.IOException;

import Officer.ParentOfficer;

public class ParentOfficerDataSavingAndRetrieval extends DataSavingAndRetrieval{

    public ParentOfficerDataSavingAndRetrieval() {
        super("parent_officers.txt");
    }


    public void saveData(ParentOfficer obj) {
        String line = "";
        line += obj.getFname();
        line += ",";
        line += obj.getLname();
        super.saveData(line);
    }
    
    // @Override 
    public ParentOfficer retrieveDataInIndex(int index) {
        String txtData = super.retrieveDataInIndex(index);

        String[] dataParts = txtData.split(",");

        ParentOfficer obj = new ParentOfficer(dataParts[0], dataParts[1]);

        return obj;
    }
    public void updateDataInIndex(int index, ParentOfficer obj) {}




    public static void main(String[] args){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        ParentOfficerDataSavingAndRetrieval data = new ParentOfficerDataSavingAndRetrieval();
        
        ParentOfficer po = new ParentOfficer("John", "Doe");
        // data.saveData(po);
   
        ParentOfficer po2 = data.retrieveDataInIndex(0);
        System.out.println(po2);
    }
}
