package net.continuumsecurity.model;

/**
 * Created by stephen on 23/02/2014.
 */
public class Item {
    int severityLevel;
    int count;

    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
