package net.continuumsecurity.v6;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.WebTarget;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.continuumsecurity.ReportClient;
import net.continuumsecurity.v5.model.Issue;
import net.continuumsecurity.v6.model.HostV6;
import net.continuumsecurity.v6.model.Plugin;
import net.continuumsecurity.v6.model.PluginOutput;
import net.continuumsecurity.v6.model.ReportV6;
import net.continuumsecurity.v6.model.Vulnerability;

/**
 * Created by stephen on 08/02/15.
 */
public class ReportClientV6 extends SessionClientV6 implements ReportClient {
	public ReportClientV6(String nessusUrl, boolean acceptAllHostNames) {
		super(nessusUrl, acceptAllHostNames);
	}

	public List<HostV6> getAllHosts(String scanId) {
		WebTarget reportTarget = target.path("scans").path(scanId);
		ReportV6 report = getRequest(reportTarget, ReportV6.class);
		return report.getHosts();
	}

	public List<Vulnerability> getVulnerabilities(String scanId, int hostId) {
		WebTarget reportTarget = target.path("scans").path(scanId).path("hosts").path(Integer.toString(hostId));
		HostV6 hostDetails = getRequest(reportTarget, HostV6.class);
		return hostDetails.getVulnerabilities();
	}

	public Plugin getPlugin(int pluginId) {
		WebTarget reportTarget = target.path("plugins").path("plugin").path(Integer.toString(pluginId));
		return getRequest(reportTarget, Plugin.class);
	}

	public HostV6 getHostDetails(int scanId, int hostId) {
		WebTarget reportTarget = target.path("scans").path(Integer.toString(scanId)).path("hosts")
				.path(Integer.toString(hostId));
		return getRequest(reportTarget, HostV6.class);
	}

	public Map<Integer, Issue> getAllIssuesSortedByPluginId(String scanId) {
		Map<Integer, Issue> issues = new HashMap<Integer, Issue>();
		for (HostV6 host : getAllHosts(scanId)) {
			List<Vulnerability> vulnerabilities = getVulnerabilities(scanId, host.getHostId());
			host.setVulnerabilities(vulnerabilities);
			for (Vulnerability vuln : vulnerabilities) {
				Issue issue = issues.get(vuln.getPluginId());
				if (issue == null) {
					// PluginOutput pluginOutput = getPluginInfoV6(scanId,
					// host.getHostId(), vuln.getPluginId());
					// PluginAttributes pluginAttributes =
					// pluginOutput.getInfo().getPlugindescription()
					// .getPluginattributes();
					// issue = vuln.toIssue(nessusUrl, scanId);
					// issue.setSolution(pluginAttributes.getSolution());
					// issue.setSynopsis(pluginAttributes.getSynopsis());
					// issue.setDescription(pluginAttributes.getDescription());
					// issue.setCvss_score(pluginAttributes.getRisk_information().getCvss_base_score());
					// issue.setPorts(pluginOutput.getPorts());
					// issues.put(vuln.getPluginId(), issue);
				}
				issue.getHostsV6().add(host);
				issue.getHostnames().add(host.getHostname());
			}
		}
		return issues;
	}

	public Map<HostV6, Map<Vulnerability, PluginOutput>> getAllHostWithVulns(String scanId, int minCrit)
			throws JsonParseException, JsonMappingException, IOException {
		Map<HostV6, Map<Vulnerability, PluginOutput>> hostsWithVulns = new HashMap<HostV6, Map<Vulnerability, PluginOutput>>();
		for (HostV6 host : getAllHosts(scanId)) {
			Map<Vulnerability, PluginOutput> vulntToPluginOutput = new HashMap<Vulnerability, PluginOutput>();
			List<Vulnerability> vulnerabilities = getVulnerabilities(scanId, host.getHostId());
			host.setVulnerabilities(vulnerabilities);
			for (Vulnerability vuln : vulnerabilities) {
				if (vuln.getSeverity() >= minCrit) {
					PluginOutput pluginOutput = getPluginInfoV6(scanId, host.getHostId(), vuln.getPluginId());
					vulntToPluginOutput.put(vuln, pluginOutput);
				}
			}
			hostsWithVulns.put(host, vulntToPluginOutput);
		}
		return hostsWithVulns;
	}

	public Map<HostV6, Map<Vulnerability, PluginOutput>> getAllHostWithVulns(String scanId)
			throws JsonParseException, JsonMappingException, IOException {
		return getAllHostWithVulns(scanId, 0);
	}

	public PluginOutput getPluginInfoV6(String scanId, int hostId, int pluginId)
			throws JsonParseException, JsonMappingException, IOException {
		WebTarget reportTarget = target.path("scans").path(scanId).path("hosts").path(Integer.toString(hostId))
				.path("plugins").path(Integer.toString(pluginId));
		// TODO: Workaround of getRequest(reportTarget, PluginOutput.class)
		// because @JsonAnySetter dont work
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(getRequest(reportTarget, String.class), PluginOutput.class);
	}
}