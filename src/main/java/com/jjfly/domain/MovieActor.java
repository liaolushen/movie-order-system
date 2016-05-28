package com.jjfly.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by luwin on 16-5-28.
 */

@Entity
public class MovieActor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String zhName;
    private String enName;
    private String imgUrl;
    private String type;
    private long movieId;

    protected MovieActor() {}

    public MovieActor(String zhName, String enName, String imgUrl, String type, long movieId) {
        this.zhName = zhName;
        this.enName = enName;
        this.imgUrl = imgUrl;
        this.type = type;
        this.movieId = movieId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public void setImgUrl(String imgUrl) {

        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
