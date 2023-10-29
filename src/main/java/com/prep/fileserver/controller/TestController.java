package com.prep.fileserver.controller;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobErrorCode;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobStorageException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping
    public void test(){
        String sasToken = "?sv=2022-11-02&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2023-10-30T01:35:49Z&st=2023-10-29T17:35:49Z&spr=https&sig=R5fT8dMdc04sAqWzegFlwRzqrSe%2Fr2B%2FzK5kHWmyxtI%3D";
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("https://afeestorage.blob.core.windows.net")
                .sasToken(sasToken)
                .buildClient();

        BlobContainerClient containerClient;
        BlobClient blobClient;

        containerClient = blobServiceClient.getBlobContainerClient("images");
        blobClient = containerClient.getBlobClient("my-remote-file4.jpg");
        blobClient.uploadFromFile("D:\\ss1.png");

        BinaryData content = blobClient.downloadContent();
    }

    @GetMapping("/test2")
    public void test2(){
        String sasToken = "?sv=2022-11-02&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2023-10-30T01:35:49Z&st=2023-10-29T17:35:49Z&spr=https&sig=R5fT8dMdc04sAqWzegFlwRzqrSe%2Fr2B%2FzK5kHWmyxtI%3D";
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("https://afeestorage.blob.core.windows.net")
                .sasToken(sasToken)
                .buildClient();

        BlobContainerClient containerClient;
        BlobClient blobClient;

        containerClient = blobServiceClient.getBlobContainerClient("images");

        for (BlobItem blobItem : containerClient.listBlobs()) {
            System.out.println("\t" + blobItem.getName());
            blobClient = containerClient.getBlobClient(blobItem.getName());
            String path = "E:\\" + blobItem.getName();
            System.out.println("\nDownloading blob to\n\t " + path);
            blobClient.downloadToFile(path);
        }
    }
}









//package com.prep.fileserver.controller;
//
//import com.azure.core.util.BinaryData;
//import com.azure.storage.blob.BlobClient;
//import com.azure.storage.blob.BlobContainerClient;
//import com.azure.storage.blob.BlobServiceClient;
//import com.azure.storage.blob.BlobServiceClientBuilder;
//import com.azure.storage.blob.models.BlobErrorCode;
//import com.azure.storage.blob.models.BlobItem;
//import com.azure.storage.blob.models.BlobStorageException;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/")
//public class TestController {
//    @GetMapping
//    public void test(){
//        String sasToken = "?sv=2022-11-02&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2023-10-30T00:50:04Z&st=2023-10-29T16:50:04Z&spr=https&sig=h1%2BlcH0%2BAh9u74oJPiJC5ut7VA4XxbiXfzia7R6X1zQ%3D";
//        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
//                .endpoint("https://asa3666.blob.core.windows.net")
//                .sasToken(sasToken)
//                .buildClient();
//
//        BlobContainerClient containerClient;
//        BlobClient blobClient;
//
//        containerClient = blobServiceClient.getBlobContainerClient("fcont");
//        blobClient = containerClient.getBlobClient("my-remote-file2.jpg");
//        blobClient.uploadFromFile("D:\\ss1.png");
//
//        BinaryData content = blobClient.downloadContent();
//    }
//
//    @GetMapping("/test2")
//    public void test2(){
//        String sasToken = "?sv=2022-11-02&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2023-10-30T00:50:04Z&st=2023-10-29T16:50:04Z&spr=https&sig=h1%2BlcH0%2BAh9u74oJPiJC5ut7VA4XxbiXfzia7R6X1zQ%3D";
//        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
//                .endpoint("https://asa3666.blob.core.windows.net")
//                .sasToken(sasToken)
//                .buildClient();
//
//        BlobContainerClient containerClient;
//        BlobClient blobClient;
//
//        containerClient = blobServiceClient.getBlobContainerClient("fcont");
//
//        for (BlobItem blobItem : containerClient.listBlobs()) {
//            System.out.println("\t" + blobItem.getName());
//            blobClient = containerClient.getBlobClient(blobItem.getName());
//            String path = "E:\\" + blobItem.getName();
//            System.out.println("\nDownloading blob to\n\t " + path);
//            blobClient.downloadToFile(path);
//        }
//    }
//}