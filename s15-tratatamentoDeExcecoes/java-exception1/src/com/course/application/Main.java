package com.course.application;

import com.course.model.entities.Reservation;
import com.course.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("\nRoom Number: ");
            int number = sc.nextInt();
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.print("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter Data to update the reservation: ");
            System.out.print("Check-In Date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out Date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.print("Reservation: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        catch (DomainException e) {
            System.out.println("Error in Reservation: "+e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected Error");
        }
        sc.close();
    }
}
