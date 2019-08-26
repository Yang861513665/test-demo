package com.yangxj.test.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangxj
 * @date 2019-08-23 14:38
 * @desc 自定义json序列化器
 */
public class CustomerSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String date_json;

        try {
           date_json = simpleDateFormat.format(date);
        }catch (Exception e){
          date_json = simpleDateFormat2.format(date);
        }
        jsonGenerator.writeString(date_json);
    }
}
