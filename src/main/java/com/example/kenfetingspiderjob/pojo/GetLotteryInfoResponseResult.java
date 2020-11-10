package com.example.kenfetingspiderjob.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetLotteryInfoResponseResult implements Serializable {
    private Integer businessCode;

    private String message;

    private GetLotteryInfoResponseResultData data;
}
