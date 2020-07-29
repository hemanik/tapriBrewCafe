package com.tapriBrewCafe.dashboard.orderMgmt.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String type;

    @Column
    private double cost;
}
