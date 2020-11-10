
package com.example.kenfetingspiderjob.dao;

import com.alibaba.fastjson.JSON;
import com.example.kenfetingspiderjob.config.Config;
import com.example.kenfetingspiderjob.pojo.FmsData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Slf4j
@Component
public class FmsDataDao {

    @Autowired
    private Config CONFIG;

    public void save(FmsData fmsData) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(CONFIG.getJDBC_DRIVER());
            conn = DriverManager.getConnection(CONFIG.getDB_URL(), CONFIG.getUSER(), CONFIG.getPASS());
            stmt = conn.createStatement();

            String sql = String.format("insert into tb_fms_data (type,term_no,draw_date,draw_number,sum,dragon_tiger) values ('%s','%s','%s','%s','%s','%s')"
                    , fmsData.getType(), fmsData.getTermNo(), fmsData.getDrawDate(), fmsData.getDrawNumber(), fmsData.getSum(), fmsData.getDragonTiger());
            int result = stmt.executeUpdate(sql);
            if (result > 0) {
                log.info("插入数据"+ JSON.toJSONString(fmsData));
            }
        } catch (SQLIntegrityConstraintViolationException e) {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }
    }
}
