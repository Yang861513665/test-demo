package com.yangxj.test;

import com.yangxj.test.utils.HtmlUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemoApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 换行样式
        CellStyle cs = workbook.createCellStyle();
        cs.setWrapText(true);

        // 标题样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        // 水平居中
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 垂直居中
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 设置字体
        HSSFFont font =workbook.createFont();
        font.setFontHeightInPoints((short) 8);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        titleStyle.setFont(font);

        HSSFSheet sheet1 = workbook.createSheet("sheet1");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // 1 header
        String[] headerNames = new String[]{"日期","时间","值1 mmol/L"};
        //3 row,3 col
        for (int i = 0; i < 4; i++) {
            HSSFRow row = sheet1.createRow(i);
            for (int j = 0; j < 3; j++) {
                if(i==0){
                    HSSFCell cell = row.createCell(j);
                    cell.setCellValue(headerNames[j]);
                    row.setRowStyle(titleStyle);
                }else{
                    if(j==0){
                        row.createCell(j).setCellValue(dateFormat.format(calendar.getTime()));
                    }else if(j==1){
                        row.createCell(j).setCellValue(timeFormat.format(calendar.getTime()));
                    }else{
                        HSSFCell cell = row.createCell(j);
                        // 设置换行
                        cell.setCellStyle(cs);
                        cell.setCellValue("8.8 \n 电子签名");
                    }
                }
                //调整列宽以适合内容
                sheet1.autoSizeColumn(j);
            }
            calendar.add(Calendar.DATE,-1);
        }
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/edz/test.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
    @Test
    public void test(){
        HtmlUtils.HtmlCovertPdf("/Users/edz/test.html","/Users/edz/test.pdf");
    }

}
