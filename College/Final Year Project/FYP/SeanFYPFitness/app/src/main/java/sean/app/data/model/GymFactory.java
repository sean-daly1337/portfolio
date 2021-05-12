package sean.app.data.model;

import android.graphics.drawable.Drawable;

public class GymFactory {
    String level, type, detail;
    Drawable drawableId;

    public GymFactory(String level, String type, String detail, Drawable drawableId) {
        this.level = level;
        this.type = type;
        this.detail = detail;
        this.drawableId = drawableId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Drawable getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(Drawable drawableId) {
        this.drawableId = drawableId;
    }
}
