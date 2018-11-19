package com.zhonggao.handle;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User:zhaozhihui
 * Date: 2018/11/16.
 * Time: 16:38
 */
@JobHandler(value = "exjobHandler")
@Component
public class ExJobHandler  extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println("启动");
        return SUCCESS;
    }
}
