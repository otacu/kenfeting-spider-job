
package com.example.kenfetingspiderjob.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetHistoryResponseResultData implements Serializable {

    private String preDrawTime;

    private Long preDrawIssue;

    private String preDrawCode;
}
