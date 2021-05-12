package dto;

public class StylesDto {

    private String p_Style;

    public String getP_Style() {
        return p_Style;
    }

    public void setP_Style(String p_Style) {
        this.p_Style = p_Style;
    }

    @Override
    public String toString() {
        return "StylesRequestModel{" +
                "p_Style='" + p_Style + '\'' +
                '}';
    }
}
