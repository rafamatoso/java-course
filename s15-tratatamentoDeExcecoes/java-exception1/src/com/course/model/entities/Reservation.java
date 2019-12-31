package com.course.model.entities;

import com.course.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)) {
            throw new DomainException ("Check-Out date must be after Check-In date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duration() {
        long dif = checkOut.getTime()-checkIn.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {

        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Error in reservation: Reservation dates for update must be future date");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException ("Check-Out date must be after Check-In date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
