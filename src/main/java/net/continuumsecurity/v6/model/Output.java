package net.continuumsecurity.v6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by alcampos on 19/10/15.
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class Output {

	private String has_attachment;
	private String custom_description;
	private String plugin_output;
	private String severity;
	private Port ports;

	public void setPorts(Port ports) {
		this.ports = ports;
	}

	public Port getPorts() {
		return ports;
	}

	public void setPlugin_output(String plugin_output) {
		this.plugin_output = plugin_output;
	}

	public void setHas_attachment(String has_attachment) {
		this.has_attachment = has_attachment;
	}

	public void setCustom_description(String custom_description) {
		this.custom_description = custom_description;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getCustom_description() {
		return custom_description;
	}

	public String getHas_attachment() {
		return has_attachment;
	}

	public String getPlugin_output() {
		return plugin_output;
	}

	public String getSeverity() {
		return severity;
	}

}
