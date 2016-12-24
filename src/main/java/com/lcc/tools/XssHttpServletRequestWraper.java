package com.lcc.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 对头部信息和参数过滤
 * Created by lcc on 2016/12/24.
 */
public class XssHttpServletRequestWraper extends HttpServletRequestWrapper {
    public XssHttpServletRequestWraper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        return clearXss(super.getParameter(name));
    }

    @Override
    public String getHeader(String name) {
        return clearXss(super.getHeader(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            String[] newValues = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                newValues[i] = clearXss(values[i].trim());
                System.out.print(newValues[i]);
            }
            return newValues;
        } else {
            return values;
        }
    }

    /**
     * 处理特殊字符串
     */
    private String clearXss(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }

        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replace("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replace("script", "");
        return value;
    }
}
