package test;

import dao.RainManageDao;
import entity.RainQuality;
import service.RainManagerService;

import java.util.Date;

/**
 * @Author: laoyu
 * @Date: 2020/2/20 9:58
 * @Description:
 */
public class TestAdd {
    public static void main(String[] args) {
        RainManagerService service = new RainManagerService();
        RainQuality rain = new RainQuality();

        rain.setRain(3);
        rain.setDistrictName("山东省");
        rain.setMonitoringStation("聊城市");
        rain.setMonitoringAddress("市区");
        rain.setMonitorTime(new Date());

        System.out.println(service.addNewRainInfo(rain));
    }
}
