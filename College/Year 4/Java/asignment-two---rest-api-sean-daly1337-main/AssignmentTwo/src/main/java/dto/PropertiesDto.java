package dto;

public class PropertiesDto {

    private String street;
    private String city;
    private Integer listing_Num;
    private Integer style_Id;
    private Integer type_Id;
    private Integer bedrooms;
    private Float bathrooms;
    private Integer squarefeet;
    private String ber_Rating;
    private String description;
    private String lotsize;
    private Short garagesize;
    private Integer garage_Id;
    private Integer agent_Id;
    private String photo;
    private Double price;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getListing_Num() {
        return listing_Num;
    }

    public void setListing_Num(Integer listing_Num) {
        this.listing_Num = listing_Num;
    }

    public Integer getStyle_Id() {
        return style_Id;
    }

    public void setStyle_Id(Integer style_Id) {
        this.style_Id = style_Id;
    }

    public Integer getType_Id() {
        return type_Id;
    }

    public void setType_Id(Integer type_Id) {
        this.type_Id = type_Id;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Float getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Float bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getSquarefeet() {
        return squarefeet;
    }

    public void setSquarefeet(Integer squarefeet) {
        this.squarefeet = squarefeet;
    }

    public String getBer_Rating() {
        return ber_Rating;
    }

    public void setBer_Rating(String ber_Rating) {
        this.ber_Rating = ber_Rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLotsize() {
        return lotsize;
    }

    public void setLotsize(String lotsize) {
        this.lotsize = lotsize;
    }

    public Short getGaragesize() {
        return garagesize;
    }

    public void setGaragesize(Short garagesize) {
        this.garagesize = garagesize;
    }

    public Integer getGarage_Id() {
        return garage_Id;
    }

    public void setGarage_Id(Integer garage_Id) {
        this.garage_Id = garage_Id;
    }

    public Integer getAgent_Id() {
        return agent_Id;
    }

    public void setAgent_Id(Integer agent_Id) {
        this.agent_Id = agent_Id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PropertiesDto{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", listing_Num=" + listing_Num +
                ", style_Id=" + style_Id +
                ", type_Id=" + type_Id +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", squarefeet=" + squarefeet +
                ", ber_Rating='" + ber_Rating + '\'' +
                ", description='" + description + '\'' +
                ", lotsize='" + lotsize + '\'' +
                ", garagesize=" + garagesize +
                ", garage_Id=" + garage_Id +
                ", agent_Id=" + agent_Id +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                '}';
    }
}
