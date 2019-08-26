package com.yangxj.test.config;

import freemarker.cache.TemplateLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Date;

/**
 * @author yangxj
 * @date 2019-08-26 18:12
 */
@Component
public class DataBaseTemplateLoader implements TemplateLoader {
    @Override
    public Object findTemplateSource(String name) throws IOException {
        // 模拟从数据库中获取ftl内容
        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "   ${name} !!\n" +
                "</body>\n" +
                "</html>";
        return new StringTemplateSource(name,content,new Date().getTime());
    }

    @Override
    public long getLastModified(Object templateSource) {
        return ((StringTemplateSource) templateSource).lastModified;
    }

    @Override
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        return new StringReader(((StringTemplateSource) templateSource).templateContent);
    }

    @Override
    public void closeTemplateSource(Object templateSource) throws IOException {

    }
    private static class StringTemplateSource {
        private final String name;
        private final String templateContent;
        private final long lastModified;

        StringTemplateSource(String name, String templateContent, long lastModified) {
            if (name == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (templateContent == null) {
                throw new IllegalArgumentException("source == null");
            }
            if (lastModified < -1L) {
                throw new IllegalArgumentException("lastModified < -1L");
            }
            this.name = name;
            this.templateContent = templateContent;
            this.lastModified = lastModified;
        }
}}
