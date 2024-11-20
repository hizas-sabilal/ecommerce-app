package com.ecommerce.inventory.domain.entity;

import com.ecommerce.common.entity.BaseEntity;
import com.ecommerce.common.valueobject.Address;
import com.ecommerce.common.valueobject.WarehouseId;

public class Warehouse extends BaseEntity<WarehouseId> {

    private String name;
    private Address address;
    private double latitude;
    private double longitude;

    public Warehouse(WarehouseId warehouseId, String name, Address address){
        super.setId(warehouseId);
        this.name = name;
        this.address = address;
    }

    public Warehouse(WarehouseId warehouseId){
        super.setId(warehouseId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public static final class Builder{
        private String name;
        private Address address;
        private double latitude;
        private double longitude;

        private Builder(){}


    }
}
