package com.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {
    private Integer enId;

    private String enUsername;

    private String enReallyname;

    private String enPassword;

    private String enSex;

    private Integer enAge;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enBirthday;

    private String enPhone;

    private Integer enStatus;

    private static final long serialVersionUID = 1L;

    public User(Integer enId, String enUsername, String enReallyname, String enPassword, String enSex, Integer enAge, Date enBirthday, String enPhone, Integer enStatus) {
        this.enId = enId;
        this.enUsername = enUsername;
        this.enReallyname = enReallyname;
        this.enPassword = enPassword;
        this.enSex = enSex;
        this.enAge = enAge;
        this.enBirthday = enBirthday;
        this.enPhone = enPhone;
        this.enStatus = enStatus;
    }

    public User() {
        super();
    }

    public Integer getEnId() {
        return enId;
    }

    public void setEnId(Integer enId) {
        this.enId = enId;
    }

    public String getEnUsername() {
        return enUsername;
    }

    public void setEnUsername(String enUsername) {
        this.enUsername = enUsername == null ? null : enUsername.trim();
    }

    public String getEnReallyname() {
        return enReallyname;
    }

    public void setEnReallyname(String enReallyname) {
        this.enReallyname = enReallyname == null ? null : enReallyname.trim();
    }

    public String getEnPassword() {
        return enPassword;
    }

    public void setEnPassword(String enPassword) {
        this.enPassword = enPassword == null ? null : enPassword.trim();
    }

    public String getEnSex() {
        return enSex;
    }

    public void setEnSex(String enSex) {
        this.enSex = enSex == null ? null : enSex.trim();
    }

    public Integer getEnAge() {
        return enAge;
    }

    public void setEnAge(Integer enAge) {
        this.enAge = enAge;
    }

    public Date getEnBirthday() {
        return enBirthday;
    }

    public void setEnBirthday(Date enBirthday) {
        this.enBirthday = enBirthday;
    }

    public String getEnPhone() {
        return enPhone;
    }

    public void setEnPhone(String enPhone) {
        this.enPhone = enPhone == null ? null : enPhone.trim();
    }

    public Integer getEnStatus() {
        return enStatus;
    }

    public void setEnStatus(Integer enStatus) {
        this.enStatus = enStatus;
    }

	@Override
	public String toString() {
		return "User [enId=" + enId + ", enUsername=" + enUsername + ", enReallyname=" + enReallyname + ", enPassword="
				+ enPassword + ", enSex=" + enSex + ", enAge=" + enAge + ", enBirthday=" + enBirthday + ", enPhone="
				+ enPhone + ", enStatus=" + enStatus + "]";
	}
    
}