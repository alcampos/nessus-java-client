package net.continuumsecurity.v6.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by alcampos on 19/10/15.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Port {

	private Map<String, Object> otherProperties = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> get() {
		return otherProperties;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		otherProperties.put(name, value);
	}
}
