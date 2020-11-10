package com.example.kenfetingspiderjob.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetHistoryResponse implements Serializable {

    private Integer errorCode;

    private String message;

    private GetHistoryResponseResult result;
}
