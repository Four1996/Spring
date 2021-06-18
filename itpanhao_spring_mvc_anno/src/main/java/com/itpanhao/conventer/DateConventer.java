package com.itpanhao.conventer;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author panhao
 * @date 2021年05月25日 9:39 下午
 */
public class DateConventer implements Converter<String, Date> {
    @Override
    public Date convert(String dateStr) {
//        将日期的字符串转换成真正的日期对象
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
