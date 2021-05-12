package sean.app.data.model;

public class MembershipPlan {

    private String membershipId;
    private String name;
    private String desc;
    private String duration;
    private double price;

    public MembershipPlan() {
    }

    public MembershipPlan(String membershipId, String name, String desc, String duration, double price) {
        this.membershipId = membershipId;
        this.name = name;
        this.desc = desc;
        this.duration = duration;
        this.price = price;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MembershipPlan{" +
                "membershipId='" + membershipId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                '}';
    }
}
