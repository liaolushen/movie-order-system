package com.jjfly.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by luwin on 16-5-29.
 */
@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String startTime;
    private String roomType;
    private float price;
    private int row;
    private int col;
    private String seatStatus;
    private long movieToCinemaId;

    protected Showtime() {}

    public Showtime(String startTime, String roomType, float price, long movieToCinemaId, int row, int col) {
        this.startTime = startTime;
        this.roomType = roomType;
        this.price = price;
        this.movieToCinemaId = movieToCinemaId;
        this.row = row;
        this.col = col;
        StringBuffer seatStatus = new StringBuffer();
        for (int index = 0; index < row * col; index++) {
            seatStatus.append(String.valueOf('0'));
        }
        this.seatStatus = seatStatus.toString();
    }

    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getMovieToCinemaId() {
        return movieToCinemaId;
    }

    public void setMovieToCinemaId(long movieToCinemaId) {
        this.movieToCinemaId = movieToCinemaId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
