package net.continuumsecurity.v6.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by alcampos on 19/10/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PluginAttributes {
	private String synopsis;
	private String description;
	private RiskInformation risk_information;
	private String plugin_name;
	private List<String> see_also;
	private String fname;
	private PluginInformation plugin_information;
	private String solution;

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RiskInformation getRisk_information() {
		return risk_information;
	}

	public void setRisk_information(RiskInformation riskinformation) {
		this.risk_information = riskinformation;
	}

	public String getPlugin_name() {
		return plugin_name;
	}

	public void setPlugin_name(String plugin_name) {
		this.plugin_name = plugin_name;
	}

	public List<String> getSee_also() {
		return see_also;
	}

	public void setSee_also(List<String> see_also) {
		this.see_also = see_also;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public PluginInformation getPlugin_information() {
		return plugin_information;
	}

	public void setPlugin_information(PluginInformation plugin_information) {
		this.plugin_information = plugin_information;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

}
