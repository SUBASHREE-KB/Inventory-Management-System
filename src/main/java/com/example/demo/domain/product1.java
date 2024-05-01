package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "product1")
@IdClass(productkey.class)
public class product1 implements Serializable {
    @Id
    private int prodid;  
    @Id
    private Date prodexp;
    private String prodname;
    private int prodqty;
    private float prodprice;
    private int supid;
    @Column(name = "userId")
    private int userId; 

    public product1() {
    }

    public product1(int prodid, Date prodexp, String prodname, int prodqty, float prodprice, int supid, int userId) {
        this.prodid = prodid;
        this.prodexp = prodexp;
        this.prodname = prodname;
        this.prodqty = prodqty;
        this.prodprice = prodprice;
        this.supid = supid;
        this.userId = userId; 
    }

   

}
