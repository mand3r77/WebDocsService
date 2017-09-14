package com.uscs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="file:C:\\EWM_\\WebDocsService\\web_docs.properties")
public class ExternalProperties {
	
	@Value("${webdocs.serverAddress}")
	String serverAddress;
	
	@Value("${webdocs.domain}")
	String domain;
	
	@Value("${webdocs.username}")
	String userName;
	
	@Value("${webdocs.password}")
	String password;
	
	@Value("${webdocs.inboundTypeKey}")
	String inboundTypeKey;
	
	@Value("${webdocs.inboundFolderKey}")
	String inboundFolderKey;
	
	@Value("${webdocs.outboundTypeKey}")
	String outboundTypeKey;
	
	@Value("${webdocs.outboundFolderKey}")
	String outboundFolderKey;
	
	@Value("${signaturecapture.signaturePath}")
	String signaturePath;
	
	@Value("${signaturecapture.completePath}")
	String completePath;

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInboundTypeKey() {
		return inboundTypeKey;
	}

	public void setInboundTypeKey(String inboundTypeKey) {
		this.inboundTypeKey = inboundTypeKey;
	}

	public String getInboundFolderKey() {
		return inboundFolderKey;
	}

	public void setInboundFolderKey(String inboundFolderKey) {
		this.inboundFolderKey = inboundFolderKey;
	}

	public String getOutboundTypeKey() {
		return outboundTypeKey;
	}

	public void setOutboundTypeKey(String outboundTypeKey) {
		this.outboundTypeKey = outboundTypeKey;
	}

	public String getOutboundFolderKey() {
		return outboundFolderKey;
	}

	public void setOutboundFolderKey(String outboundFolderKey) {
		this.outboundFolderKey = outboundFolderKey;
	}

	public String getSignaturePath() {
		return signaturePath;
	}

	public void setSignaturePath(String signaturePath) {
		this.signaturePath = signaturePath;
	}

	public String getCompletePath() {
		return completePath;
	}

	public void setCompletePath(String completePath) {
		this.completePath = completePath;
	}

	@Override
	public String toString() {
		return "ExternalProperties [serverAddress=" + serverAddress
				+ ", domain=" + domain + ", userName=" + userName
				+ ", password=" + password + ", inboundTypeKey="
				+ inboundTypeKey + ", inboundFolderKey=" + inboundFolderKey
				+ ", outboundTypeKey=" + outboundTypeKey
				+ ", outboundFolderKey=" + outboundFolderKey
				+ ", signaturePath=" + signaturePath + ", completePath="
				+ completePath + "]";
	}
	
	

}
