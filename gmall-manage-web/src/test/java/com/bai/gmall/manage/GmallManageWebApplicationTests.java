package com.bai.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        String file = GmallManageWebApplication.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(file);

        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = null;

        trackerServer = trackerClient.getTrackerServer();

        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
       String url = "http://192.168.71.128";
        String[] strings = storageClient.upload_file("E:\\a.jpg", "jpg", null);
        for (String string : strings) {
            url += "/"+string;
        }
        System.out.println(url);
    }

}
