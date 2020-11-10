
package com.example.kenfetingspiderjob.component;

import com.alibaba.fastjson.JSON;
import com.egoist.parent.common.utils.http.EgoistOkHttp3Util;
import com.example.kenfetingspiderjob.dao.FmsDataDao;
import com.example.kenfetingspiderjob.pojo.FmsData;
import com.example.kenfetingspiderjob.pojo.GetLotteryInfoResponse;
import com.example.kenfetingspiderjob.pojo.GetLotteryInfoResponseResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DownloadCronJobComponent {

    @Autowired
    private FmsDataDao fmsDataDao;

    @Scheduled(cron = "0 */5 * * * ?")
    public void run() {
        try {
            String json = EgoistOkHttp3Util.get("https://api.api68.com/pks/getLotteryPksInfo.do?issue=&lotCode=10057");
            GetLotteryInfoResponse response = JSON.parseObject(json, GetLotteryInfoResponse.class);
            GetLotteryInfoResponseResultData data = response.getResult().getData();
            FmsData fmsData = new FmsData();
            fmsData.setType(data.getLotName());
            fmsData.setTermNo(data.getPreDrawIssue());
            fmsData.setDrawDate(data.getPreDrawTime());
            fmsData.setDrawNumber(data.getPreDrawCode());
            fmsData.setSum("");
            fmsData.setDragonTiger("");
            fmsDataDao.save(fmsData);
        } catch (Exception e) {
            log.error("报错", e);
        }
    }
}
