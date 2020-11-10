package com.example.kenfetingspiderjob.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetHistoryResponseResult implements Serializable {
    private Integer businessCode;

    private String message;

    private List<GetHistoryResponseResultData> data;
}
