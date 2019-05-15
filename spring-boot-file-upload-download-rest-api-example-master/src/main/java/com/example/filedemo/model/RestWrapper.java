package com.example.filedemo.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestWrapper {
	private String errorCode;
	
	@JsonProperty(value="reportRows")
	ArrayList<ReportRow> rows = new ArrayList<ReportRow>();

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ArrayList<ReportRow> getRows() {
		return rows;
	}

	public void setRows(ArrayList<ReportRow> rows) {
		this.rows = rows;
	}

}
