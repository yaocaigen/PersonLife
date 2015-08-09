package com.personlife.bean;

import java.util.Date;
import java.util.List;

import android.graphics.drawable.Drawable;

public class App {
	private int id;
	private String name;
	private int stars;
	private int dowloadcount;
	private String tag;
	private String icon;
	private String introdution;
	private String version;
	private String size;
	private Date updateDate;
	private String[] urls;
	private List<Comment> comments;
	private String downloadUrl;
	private List<App> likes;
	private Drawable appIcon;
	private String packageName;
	public List<App> getLikes() {
		return likes;
	}
	public void setLikes(List<App> likes) {
		this.likes = likes;
	}
	public Drawable getAppIcon() {
		return appIcon;
	}
	public void setAppIcon(Drawable appIcon) {
		this.appIcon = appIcon;
	}
	public App(){
	}
	public App(String appname,int stars,String tag,int downloadcounts){
		this.name=appname;
		this.stars = stars;
		this.tag = tag;
		this.dowloadcount = downloadcounts;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIntrodution() {
		return introdution;
	}
	public void setIntrodution(String introdution) {
		this.introdution = introdution;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String[] getUrls() {
		return urls;
	}
	public void setUrls(String[] urls) {
		this.urls = urls;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public int getDowloadcount() {
		return dowloadcount;
	}
	public void setDowloadcount(int dowloadcount) {
		this.dowloadcount = dowloadcount;
	}
	public String getPackageName() {  
        return packageName;  
    }  
    public void setPackageName(String packageName) {  
        this.packageName = packageName;
    }
}
