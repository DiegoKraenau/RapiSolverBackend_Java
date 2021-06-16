package com.rapisolver.rapisolveruserservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
//@Table(name="supplier")
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("SUPPLIER")
public class Supplier extends User {
    @Column(length = 100)
    String comercialName;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    //private List<SupplierAttention> supplierAttentionsList;


}
