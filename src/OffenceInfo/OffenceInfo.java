package OffenceInfo;

public class OffenceInfo {
    private int code;
    private String description;
    private float fines;

    public OffenceInfo(int code, String description, float fines) {
        this.code = code;
        this.description = description;
        this.fines = fines;
    }

    // Getters and setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getFines() {
        return fines;
    }

    public void setFines(float fines) {
        this.fines = fines;
    }

    @Override
    public String toString() {
        return "Code: "+ code + ", Description: " + description + ", Fines: " + fines;
    }
}
