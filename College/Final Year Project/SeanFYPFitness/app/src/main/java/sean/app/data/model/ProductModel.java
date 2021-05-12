package sean.app.data.model;

public class ProductModel {

    String nodeAddress;
    String name;
    String desc;
    String sanitisedBy;
    String howOftenCleaned;
    String lastCleanDate;
    String lastCleanTime;
    String imageName;

    public ProductModel() {
    }

    public ProductModel(String nodeAddress, String name, String desc, String sanitisedBy, String howOftenCleaned, String lastCleanDate, String lastCleanTime, String imageName) {
        this.nodeAddress = nodeAddress;
        this.name = name;
        this.desc = desc;
        this.sanitisedBy = sanitisedBy;
        this.howOftenCleaned = howOftenCleaned;
        this.lastCleanDate = lastCleanDate;
        this.lastCleanTime = lastCleanTime;
        this.imageName = imageName;
    }

    public String getNodeAddress() {
        return nodeAddress;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getSanitisedBy() {
        return sanitisedBy;
    }

    public String getHowOftenCleaned() {
        return howOftenCleaned;
    }

    public String getLastCleanDate() {
        return lastCleanDate;
    }

    public String getLastCleanTime() {
        return lastCleanTime;
    }

    public String getImageName() {
        return imageName;
    }
}
