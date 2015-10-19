package net.continuumsecurity.v6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by alcampos on 19/10/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskInformation {
	private String risk_factor;
	private String cvss_vector;
	private String cvss_base_score;

	public String getRisk_factor() {
		return risk_factor;
	}

	public void setRisk_factor(String risk_factor) {
		this.risk_factor = risk_factor;
	}

	public String getCvss_vector() {
		return cvss_vector;
	}

	public void setCvss_vector(String cvss_vector) {
		this.cvss_vector = cvss_vector;
	}

	public String getCvss_base_score() {
		return cvss_base_score;
	}

	public void setCvss_base_score(String cvss_base_score) {
		this.cvss_base_score = cvss_base_score;
	}

}
