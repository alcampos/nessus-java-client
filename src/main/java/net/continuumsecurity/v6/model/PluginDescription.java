package net.continuumsecurity.v6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by alcampos on 19/10/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PluginDescription {
	private int severity;
	private String pluginname;
	private PluginAttributes pluginattributes;
	private String pluginfamily;
	private String pluginid;

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public void setPluginname(String pluginname) {
		this.pluginname = pluginname;
	}

	public void setPluginattributes(PluginAttributes pluginattributes) {
		this.pluginattributes = pluginattributes;
	}

	public void setPluginfamily(String pluginfamily) {
		this.pluginfamily = pluginfamily;
	}

	public void setPluginid(String pluginid) {
		this.pluginid = pluginid;
	}

	public int getSeverity() {
		return severity;
	}

	public PluginAttributes getPluginattributes() {
		return pluginattributes;
	}

	public String getPluginname() {
		return pluginname;
	}

	public String getPluginfamily() {
		return pluginfamily;
	}

	public String getPluginid() {
		return pluginid;
	}
}
