package com.example.kenfetingspiderjob;

import com.alibaba.fastjson.JSON;
import com.egoist.parent.common.utils.http.EgoistOkHttp3Util;
import com.example.kenfetingspiderjob.pojo.GetHistoryResponse;

public class TestHttp {
    public static void main(String[] args) throws Exception {
        String json = EgoistOkHttp3Util.get("https://api.api68.com/pks/getPksHistoryList.do?date=2020-11-07&lotCode=10057");
        GetHistoryResponse getHistoryResponse = JSON.parseObject(json, GetHistoryResponse.class);
        System.out.println(JSON.toJSONString(getHistoryResponse));
    }
}
