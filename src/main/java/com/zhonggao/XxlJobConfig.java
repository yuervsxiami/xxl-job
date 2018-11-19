package com.zhonggao;

import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User:zhaozhihui
 * Date: 2018/11/16.
 * Time: 16:33
 */
@Configuration
@ComponentScan(basePackages = "com.zhonggao.handle")
public class XxlJobConfig {
    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);

    @Value("${xxl.job.admin.addresses}")

    private String adminAddresses;

    @Value("${xxl.job.executor.appname}")

    private String appName;

    @Value("${xxl.job.executor.ip}")

    private String ip;

    @Value("${xxl.job.executor.port}")

    private int port;

    @Value("${xxl.job.accessToken}")

    private String accessToken;

    @Value("${xxl.job.executor.logpath}")

    private String logPath;

    private int logRetentionDays=-1;//Log文件定期清理

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobExecutor xxlJobExecutor() {

        logger.info(">>>>>>>>>>> xxl-job config init.");

        XxlJobSpringExecutor xxlJobExecutor = new XxlJobSpringExecutor();

        xxlJobExecutor.setAdminAddresses(adminAddresses);

        xxlJobExecutor.setAppName(appName);

        xxlJobExecutor.setIp(ip);

        xxlJobExecutor.setPort(port);

        xxlJobExecutor.setAccessToken(accessToken);

        xxlJobExecutor.setLogPath(logPath);

        xxlJobExecutor.setLogRetentionDays(logRetentionDays);
        xxlJobExecutor.setLogRetentionDays(-1);
        return xxlJobExecutor;

    }
}
