package com.platform.web.common.util;

/**
 * TpmisFiles entity. @author MyEclipse Persistence Tools
 */

public class Files implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Double length;
	private String filepath;
	private String exename;
	private Double download;
	private String garnerindex;
	private String uri;
	private String ctime;
	private String cusername;
	private Long cuserid;
	private String etime;
	private String eusername;
	private Long euserid;
	private String note;
	private String state;

	// Constructors

	/** default constructor */
	public Files() {
	}

	/** minimal constructor */
	public Files(String name, Double length, String filepath,
			String exename, String ctime, String cusername, Long cuserid,
			String etime, String eusername, Long euserid, String state) {
		this.name = name;
		this.length = length;
		this.filepath = filepath;
		this.exename = exename;
		this.ctime = ctime;
		this.cusername = cusername;
		this.cuserid = cuserid;
		this.etime = etime;
		this.eusername = eusername;
		this.euserid = euserid;
		this.state = state;
	}

	/** full constructor */
	public Files(String name, Double length, String filepath,
			String exename, Double download, String garnerindex, String uri,
			String ctime, String cusername, Long cuserid, String etime,
			String eusername, Long euserid, String note, String state) {
		this.name = name;
		this.length = length;
		this.filepath = filepath;
		this.exename = exename;
		this.download = download;
		this.garnerindex = garnerindex;
		this.uri = uri;
		this.ctime = ctime;
		this.cusername = cusername;
		this.cuserid = cuserid;
		this.etime = etime;
		this.eusername = eusername;
		this.euserid = euserid;
		this.note = note;
		this.state = state;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLength() {
		return this.length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getExename() {
		return this.exename;
	}

	public void setExename(String exename) {
		this.exename = exename;
	}

	public Double getDownload() {
		return this.download;
	}

	public void setDownload(Double download) {
		this.download = download;
	}

	public String getGarnerindex() {
		return this.garnerindex;
	}

	public void setGarnerindex(String garnerindex) {
		this.garnerindex = garnerindex;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCusername() {
		return this.cusername;
	}

	public void setCusername(String cusername) {
		this.cusername = cusername;
	}

	public Long getCuserid() {
		return this.cuserid;
	}

	public void setCuserid(Long cuserid) {
		this.cuserid = cuserid;
	}

	public String getEtime() {
		return this.etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getEusername() {
		return this.eusername;
	}

	public void setEusername(String eusername) {
		this.eusername = eusername;
	}

	public Long getEuserid() {
		return this.euserid;
	}

	public void setEuserid(Long euserid) {
		this.euserid = euserid;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}