package net.continuumsecurity.v6.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by alcampos on 19/10/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PluginOutput {
	private InfoV6 info;
	private List<Output> outputs;

	public InfoV6 getInfo() {
		return info;
	}

	public void setInfo(InfoV6 info) {
		this.info = info;
	}

	public List<Output> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<Output> outputs) {
		this.outputs = outputs;
	}
}
