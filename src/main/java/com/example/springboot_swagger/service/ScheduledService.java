package com.example.springboot_swagger.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //cron表达式
    //秒 分 时 日 月 周几  "0 * * * * 0-7"
    //"30 15 10 * * ?"      每天10点15分30秒执行一次
    //"30 0/5 10,18 * * ?"  每天10点和18点, 每隔5分钟执行一次
    //"0 15 10 ? * 1-6"     每个月的周一至周六的10点15分执行一次
    @Scheduled(cron = "0 46 21 * * ?")
    public void hello(){
        System.out.println("hello, 你被执行了~");
    }
}
