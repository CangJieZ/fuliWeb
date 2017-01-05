package com.fuli.web.pojo;

import java.util.Date;

public class SubjectInfo extends BaseModel{
    /**  
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = -927639304850705643L;

	private Integer id;

    private String title;

    private Integer fromId;

    private Date addTime;

    private String preview;
    
    public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

}