package sean.app.data.model;


public class DeliverySlotModel {
    String id, range;
    Boolean isSelected;
    Boolean isDisable;

    public DeliverySlotModel(String id, String range, Boolean isSelected, Boolean isDisable) {
        this.id = id;
        this.range = range;
        this.isSelected = isSelected;
        this.isDisable = isDisable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Boolean getDisable() {
        return isDisable;
    }

    public void setDisable(Boolean disable) {
        isDisable = disable;
    }
}
