package stanford.minihackathon3_rest_api.model;

import jakarta.persistence.Entity;

public class Rating {
    private String source;
    private String value;

    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public Rating() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
