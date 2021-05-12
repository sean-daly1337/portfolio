package sean.app.data.model;

public class Bookings {
    private String bookingId;
    private String userId;
    private String bookingTime;
    private String bookingDate;

    public Bookings() {
    }

    public Bookings(String bookingId, String userId, String bookingTime, String bookingDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.bookingTime = bookingTime;
        this.bookingDate = bookingDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId='" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                '}';
    }
}
