package models.requests;

public class PropertyTypesRequestModel {

    private String p_Type;

    public String getP_Type() {
        return p_Type;
    }

    public void setP_Type(String p_Type) {
        this.p_Type = p_Type;
    }

    @Override
    public String toString() {
        return "PropertyTypesRequestModel{" +
                "p_Type='" + p_Type + '\'' +
                '}';
    }
}
