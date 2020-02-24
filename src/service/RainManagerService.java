package service;

import dao.RainManageDao;
import entity.RainQuality;

import java.util.List;

/**
 * @Author: laoyu
 * @Date: 2020/2/18 17:37
 * @Description:
 */
public class RainManagerService {
    private RainManageDao rainManageDao = new RainManageDao();

    public List<RainQuality> getAllInfo() {
        return rainManageDao.getAllInfo();
    }

    public int addNewRainInfo(RainQuality rain) {
        return rainManageDao.addNewRainInfo(rain);
    }

    public int deleteById(String id) {
        return rainManageDao.deleteById(id);
    }
}
