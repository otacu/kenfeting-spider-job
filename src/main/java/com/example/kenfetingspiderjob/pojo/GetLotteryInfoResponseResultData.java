package com.example.kenfetingspiderjob.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetLotteryInfoResponseResultData implements Serializable {

    private String lotName;

    private String preDrawCode;

    private String preDrawIssue;

    private String preDrawTime;
}
