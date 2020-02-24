package test;

import service.RainManagerService;

/**
 * @Author: laoyu
 * @Date: 2020/2/24 11:07
 * @Description:
 */
public class TestDeleteById {
    public static void main(String[] args) {
        RainManagerService service = new RainManagerService();
        int i = service.deleteById("14");
        System.out.println(i);

    }
}
