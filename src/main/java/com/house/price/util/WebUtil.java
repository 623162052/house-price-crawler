package com.house.price.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * Web工具类
 * Created by alex on 2015/8/26.
 */
public class WebUtil {

    private static final Log LOG = LogFactory.getLog(WebUtil.class);
    public final static Gson gson = new GsonBuilder().create();
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;

    public static final String RESULT_VAL = "resultVal";
    public static final String RESULT_MSG = "resultMsg";

    /**
     * 默认操作结果
     */
    public static final String DEFAULT_SUCCESS_MSG = "Operate Success";
    public static final String DEFAULT_FAIL_MSG = "Operate Fail";
    public static final String DEFAULT_ERROR_MSG = "Operate Error";

    /**
     * 解析对象
     */
    public static <T> T parseObject(HttpServletRequest request, Class<T> clazz) throws Exception {
        BufferedReader bfReader = null;
        try {
            bfReader = request.getReader();
            return gson.fromJson(request.getReader(), clazz);
        } finally {
            if (bfReader != null) {
                bfReader.close();
            }
        }
    }

}
