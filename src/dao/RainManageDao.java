package dao;

import entity.RainQuality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laoyu
 * @Date: 2020/2/18 16:28
 * @Description:
 */
public class RainManageDao extends BaseDao {
    Connection conn;
    ResultSet rs;
    PreparedStatement pstmt;

    /**
     * 查询所有的雨量监测信息，并且按照时间倒序排列
     *
     * @return
     */
    public List<RainQuality> getAllInfo() {
        List<RainQuality> rainQualityList = new ArrayList<RainQuality>();
        RainQuality rainQuality = null;
        try {
            //编写SQL语句
            String sql = "SELECT id,districtName,monitorTime,rain,monitoringStation,monitoringAddress FROM `rainquality` ORDER  BY monitorTime DESC ";
            //获取数据库连接
            conn = BaseDao.getConn();
            //创建执行SQL的对象
            pstmt = conn.prepareStatement(sql);
            //执行SQL语句
            rs = pstmt.executeQuery();
            //处理结果集对象
            while (rs.next()) {
                //实例化对象
                rainQuality = new RainQuality();
                rainQuality.setId(rs.getInt("id"));
                rainQuality.setDistrictName(rs.getString("districtName"));
                rainQuality.setMonitorTime(rs.getDate("monitorTime"));
                rainQuality.setRain(rs.getInt("rain"));
                rainQuality.setMonitoringStation(rs.getString("monitoringStation"));
                rainQuality.setMonitoringAddress(rs.getString("monitoringAddress"));
                //将rainQuality对象添加到集合中
                rainQualityList.add(rainQuality);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rainQualityList;
    }

    /**
     * 新增雨量监测信息
     *
     * @param rain 雨量对象
     * @return 是否添加成功：1表示成功，其他表示失败
     */
    public int addNewRainInfo(RainQuality rain) {
        int num = 0;
        try {
            //编写SQL语句
            StringBuffer sql = new StringBuffer("INSERT into rainquality ");
            sql.append("(districtName,monitorTime,rain,monitoringStation,monitoringAddress)");
            sql.append("VALUES(?,?,?,?,?)");

            //连接数据库
            conn = BaseDao.getConn();

            //prepareStatement对象
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setObject(1,rain.getDistrictName());
            pstmt.setObject(2,rain.getMonitorTime());
            pstmt.setObject(3,rain.getRain());
            pstmt.setObject(4,rain.getMonitoringStation());
            pstmt.setObject(5,rain.getMonitoringAddress());

            //执行SQL
            num = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            num = -1;
        }
        return num;
    }

    /**
     * 根据编号删除雨量信息
     * @param id
     * @return
     */
    public int deleteById(String id){
        int num =0;
        try {
            //编写删除雨量信息的SQL
            String sql = "delete from rainquality where id = ?";
            //连接数据库
            conn = BaseDao.getConn();
            //prepareStatement对象
            pstmt = conn.prepareStatement(sql);
            //参数赋值
            pstmt.setObject(1,id);
            //执行SQL
            num = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            num = -1;
        }
        return num;
    }
}
