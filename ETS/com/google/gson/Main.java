package ETS.com.google.gson;

import ETS.com.google.gson.Gson;
import ETS.com.google.gson.JsonIOException;
import ETS.com.google.gson.JsonSyntaxException;

class Delivery {
    private Status status;
    private ServicePackage servicePackage;
    private City city;
    private int weight;
    private int quantity;
    private int priceItem;
    private String productName;
    private PaymentService paymentService;

    public Delivery(Status status, ServicePackage servicePackage, City city, int weight, int quantity, int priceItem, String productName, PaymentService paymentService) {
        this.status = status;
        this.servicePackage = servicePackage;
        this.city = city;
        this.weight = weight;
        this.quantity = quantity;
        this.priceItem = priceItem;
        this.productName = productName;
        this.paymentService = paymentService;
    }

    public PaymentService getPaymentService() { return paymentService; }
    public void setPaymentService(PaymentService paymentService) { this.paymentService = paymentService; }

    @Override
    public String toString() {
        return "Delivery{" +
                "status=" + status +
                ", servicePackage=" + servicePackage +
                ", city=" + city +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", priceItem=" + priceItem +
                ", productName='" + productName + '\'' +
                ", paymentService=" + paymentService +
                '}';
    }
}

abstract class PaymentService {
    public abstract String getPaymentStatus();
    public abstract String getPaymentMethod();
}

class OVOPayment extends PaymentService {
    @Override
    public String getPaymentStatus() {
        return "OVO Payment Processed";
    }

    @Override
    public String getPaymentMethod() {
        return "OVO";
    }

    @Override
    public String toString() {
        return "OVOPayment{method='" + getPaymentMethod() + "', status='" + getPaymentStatus() + "'}";
    }
}

class QRISPayment extends PaymentService {
    @Override
    public String getPaymentStatus() {
        return "QRIS Payment Processed";
    }

    @Override
    public String getPaymentMethod() {
        return "QRIS";
    }

    @Override
    public String toString() {
        return "QRISPayment{method='" + getPaymentMethod() + "', status='" + getPaymentStatus() + "'}";
    }
}

class CashPayment extends PaymentService {
    @Override
    public String getPaymentStatus() {
        return "Cash Payment Received";
    }

    @Override
    public String getPaymentMethod() {
        return "Cash";
    }

    @Override
    public String toString() {
        return "CashPayment{method='" + getPaymentMethod() + "', status='" + getPaymentStatus() + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        Status status = new Status(0, "OK");
        ServicePackage servicePackage = new ServicePackage("Yakin Esok Sampai (YES)", 48000);
        City city = new City("SURABAYA", "JAKARTA");
        PaymentService paymentService = new OVOPayment();
        
        Delivery delivery = new Delivery(status, servicePackage, city, 2, 1, 80000, "Celana Jeans", paymentService);
        
        System.out.println(delivery);
        System.out.println("Payment Method: " + delivery.getPaymentService().getPaymentMethod());
        System.out.println("Payment Status: " + delivery.getPaymentService().getPaymentStatus());
    }
}