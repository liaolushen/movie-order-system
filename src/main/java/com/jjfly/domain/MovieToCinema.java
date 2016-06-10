package com.jjfly.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by luwin on 16-5-28.
 */

@Entity
public class MovieToCinema {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String viewingDate;
    private boolean hasDiscount;
    private long movieId;
    private long cinemaId;

    protected MovieToCinema() {}

    public MovieToCinema(String viewingDate, boolean hasDiscount, long movieId, long cinemaId) {
        this.viewingDate = viewingDate;
        this.hasDiscount = hasDiscount;
        this.movieId = movieId;
        this.cinemaId = cinemaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getViewingDate() {
        return viewingDate;
    }

    public void setViewingDate(String viewingDate) {
        this.viewingDate = viewingDate;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }
}
