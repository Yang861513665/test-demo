package com.yangxj.test.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class PDFUtil {
    public static void writeToOutputStreamAsPDF(InputStream html, OutputStream os) {
        Document document =null;
        PdfWriter pdfWriter=null;
        try {
            document = new Document(PageSize.A4);
            pdfWriter = PdfWriter.getInstance(document, os);
            document.open();
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            worker.parseXHtml(pdfWriter, document, html, Charset.forName("UTF-8"), new AsianFontProvider());
        } catch (Exception e) {
        }finally {
            if(document!=null){
                document.close();
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(pdfWriter!=null){
                pdfWriter.close();
            }
        }
    }
}
/**
 * 用于中文显示的Provider
 */
class AsianFontProvider extends XMLWorkerFontProvider {
    @Override
    public Font getFont(final String fontname, String encoding, float size, final int style) {
        try {
            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            return new Font(bfChinese, size, style);
        } catch (Exception e) {
        }
        return super.getFont(fontname, encoding, size, style);
    }
}