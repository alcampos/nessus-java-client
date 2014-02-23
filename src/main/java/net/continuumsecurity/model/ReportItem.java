package net.continuumsecurity.model;

/**
 * Created by stephen on 23/02/2014.
 */
public class ReportItem {
    String port;
    int severity;
    int pluginID;
    String pluginName;
    Data data;
    String description;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getPluginID() {
        return pluginID;
    }

    public void setPluginID(int pluginID) {
        this.pluginID = pluginID;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
