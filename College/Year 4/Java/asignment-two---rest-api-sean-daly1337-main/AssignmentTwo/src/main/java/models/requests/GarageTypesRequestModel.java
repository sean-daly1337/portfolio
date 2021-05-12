package models.requests;

public class GarageTypesRequestModel {

    private String g_Type;

    public String getG_Type() {
        return g_Type;
    }

    public void setG_Type(String g_Type) {
        this.g_Type = g_Type;
    }

    @Override
    public String toString() {
        return "GarageTypesDto{" +
                "g_Type='" + g_Type + '\'' +
                '}';
    }
}
