package com.bai.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile) {
        String imgUrl = "http://192.168.71.128";
        String file = PmsUploadUtil.class.getResource("/tracker.conf").getPath();

        try {
            ClientGlobal.init(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = null;

        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
        try {

            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+ 1) ;

            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);

            for (String uploadInfo : uploadInfos) {
                imgUrl += "/"+uploadInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}
