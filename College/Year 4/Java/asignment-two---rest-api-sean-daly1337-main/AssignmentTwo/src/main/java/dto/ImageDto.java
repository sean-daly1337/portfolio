package dto;

public class ImageDto {

    private String imageId;
    private Integer width;
    private Integer height;
    private Long size;
    private String fileLink;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    @Override
    public String toString() {
        return "{" +
                "imageId='" + imageId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", size=" + size +
                ", fileLink='" + fileLink + '\'' +
                '}';
    }
}
