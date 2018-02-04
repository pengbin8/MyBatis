package com.huawei.model;

public class UpdateLayer {
	private Integer id;
	private String appId;
	private String objectCode;
	private String projectCode;
	
	public UpdateLayer(Integer id, String appId, String objectCode, String projectCode) {
		super();
		this.id = id;
		this.appId = appId;
		this.objectCode = objectCode;
		this.projectCode = projectCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getObjectCode() {
		return objectCode;
	}
	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
}
