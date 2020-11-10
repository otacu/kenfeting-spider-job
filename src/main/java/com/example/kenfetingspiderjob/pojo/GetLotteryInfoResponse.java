
package com.example.kenfetingspiderjob.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetLotteryInfoResponse implements Serializable {

    private Integer errorCode;

    private String message;

    private GetLotteryInfoResponseResult result;
}
