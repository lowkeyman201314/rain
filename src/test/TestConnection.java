package test;

import dao.BaseDao;
import dao.RainManageDao;
import service.RainManagerService;

/**
 * @Author: laoyu
 * @Date: 2020/2/18 10:17
 * @Description:
 */
public class TestConnection {
    public static void main(String[] args) {
        RainManagerService service = new RainManagerService();
        System.out.println(service.getAllInfo());
    }
}
