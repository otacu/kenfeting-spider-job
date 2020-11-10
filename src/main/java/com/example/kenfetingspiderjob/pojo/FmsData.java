
package com.example.kenfetingspiderjob.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FmsData implements Serializable {
    private String type;
    private String termNo;
    private String drawDate;
    private String drawNumber;
    private String sum;
    private String dragonTiger;
}
