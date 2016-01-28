package com.victor.h5blog.model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * XML configuration
 * 
 * @author tangfan
 * @since 2015-10-12
 *
 */
@XmlRootElement(name = "configuration")
public class ConfigurationDefinition implements Identity {

	private String id;

	private String description;

	private List<ServerDefinition> servers = new LinkedList<ServerDefinition>();

	@XmlElementWrapper(name = "servers")
	@XmlElement(name = "server")
	public List<ServerDefinition> getServers() {
		return servers;
	}

	@XmlElement(name = "id", required = true)
	public String getId() {
		return id;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setServers(List<ServerDefinition> servers) {
		this.servers = servers;
	}

}
