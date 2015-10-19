package net.continuumsecurity.v6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by alcampos on 19/10/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoV6 {
	private PluginDescription plugindescription;

	public PluginDescription getPlugindescription() {
		return plugindescription;
	}

	public void setPlugindescription(PluginDescription plugindescription) {
		this.plugindescription = plugindescription;
	}

}