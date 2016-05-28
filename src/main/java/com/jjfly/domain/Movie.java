package com.jjfly.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by luwin on 16-5-26.
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String imgUrl;
    private String name;
    private String premiereTime;  // 首映时间
    private String duration;      // 电影时长
    private String type;          // 电影类型：历史、恐怖等
    private String region;        // 电影地区：中、日、欧美
    private int hot;              // 电影热度
    private String description;   // 电影描述

    protected Movie() {}

    public Movie(String name, String imgUrl, String premiereTime,
                 String duration, String type, String region,
                 int hot, String description) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.premiereTime = premiereTime;
        this.duration = duration;
        this.type = type;
        this.region = region;
        this.hot = hot;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Movie[id=%d, name='%s']",
                id, name
        );
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPremiereTime() {
        return premiereTime;
    }

    public void setPremiereTime(String premiereTime) {
        this.premiereTime = premiereTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
