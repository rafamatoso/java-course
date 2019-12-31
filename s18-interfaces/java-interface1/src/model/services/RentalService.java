package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;

    private TaxServices taxService;

    public RentalService() {
    }

    public RentalService(Double pricePerDay, Double pricePerHour, TaxServices taxServices) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxServices;
    }

    public void processInvoice(CarRental carRental) {
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();
        double hours = (double)(t2-t1)/1000/60/60;

        double basicPayment = 0;
        if(hours <= 12) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours/24) * pricePerDay;
        }
        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

}
