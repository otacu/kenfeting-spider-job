
package com.example.kenfetingspiderjob.component;

import com.alibaba.fastjson.JSON;
import com.egoist.parent.common.utils.http.EgoistOkHttp3Util;
import com.egoist.parent.common.utils.string.EgoistStringUtil;
import com.example.kenfetingspiderjob.config.Config;
import com.example.kenfetingspiderjob.dao.FmsDataDao;
import com.example.kenfetingspiderjob.pojo.FmsData;
import com.example.kenfetingspiderjob.pojo.GetHistoryResponse;
import com.example.kenfetingspiderjob.pojo.GetHistoryResponseResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Component
public class DownloadAllDataComponent {

    @Autowired
    private FmsDataDao fmsDataDao;

    @Autowired
    private Config CONFIG;

    private final String TYPE ="幸运飞艇";

    @PostConstruct
    public void run() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDate = CONFIG.getSTART_DATE();
        String endDate = CONFIG.getEND_DATE();
        if (EgoistStringUtil.isBlank(startDate)) {
            return;
        }
        if (EgoistStringUtil.isBlank(endDate)) {
            endDate = LocalDate.now().toString();
        }
        LocalDate endLocalDate = LocalDate.parse(endDate);
        LocalDate localDate = LocalDate.parse(startDate);
        while (localDate.compareTo(endLocalDate) <= 0) {
            String date = localDate.format(dateTimeFormatter);
            try {
                String json = EgoistOkHttp3Util.get(String.format("https://api.api68.com/pks/getPksHistoryList.do?date=%s&lotCode=10057", date));
                GetHistoryResponse response = JSON.parseObject(json, GetHistoryResponse.class);
                List<GetHistoryResponseResultData> list = response.getResult().getData();
                for (GetHistoryResponseResultData data : list) {
                    FmsData fmsData = new FmsData();
                    fmsData.setType(TYPE);
                    fmsData.setTermNo(String.valueOf(data.getPreDrawIssue()));
                    fmsData.setDrawDate(data.getPreDrawTime());
                    fmsData.setDrawNumber(data.getPreDrawCode());
                    fmsData.setSum("");
                    fmsData.setDragonTiger("");
                    fmsDataDao.save(fmsData);
                }
                localDate = localDate.plusDays(1);
            } catch (Exception e) {
                log.error(String.format("日期%s下载数据报错", date), e);
            }
        }
    }
}
