package jaxrs.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Car")
public class Car {
    private String band;
    private Double price;
    public Car() {
    }
    public String getBand() {
        return band;
    }
    public void setBand(String band) {
        this.band = band;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String toString() {
        return "[band: " + getBand() + ", price: " + price + "]";
    }
}
