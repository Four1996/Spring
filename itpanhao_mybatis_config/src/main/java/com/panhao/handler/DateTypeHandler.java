package com.panhao.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author panhao
 * @date 2021年05月31日 3:34 下午
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {
    //    负责将java类型转换成数据库需要的类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i,time);
    }
    //将数据库中类型转换成java类型
//    string参数 要转换的字段名称
//    resultset 查询出的结果集
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
//        获得结果集需要的数据(long)转换成Date类型返回
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date;
    }
    //将数据库中类型转换成java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
    //将数据库中类型转换成java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }

}
