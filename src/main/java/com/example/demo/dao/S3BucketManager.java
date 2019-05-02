package com.example.demo.dao;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3BucketManager {

    private AmazonS3 s3Client = null;
    private File file;
    private static S3BucketManager S3BucketManager = null;

    private static AWSCredentialsProvider awsCredentialsProvider = DefaultAWSCredentialsProviderChain.getInstance();

    private S3BucketManager() throws IOException {
        s3Client = AmazonS3ClientBuilder.standard()
                                        .withCredentials(awsCredentialsProvider)
                                        .withRegion(Regions.US_EAST_2)
                                        .build();
    }

    public static S3BucketManager getS3BucketManager() throws IOException {

        if (S3BucketManager == null) {
            S3BucketManager = new S3BucketManager();
        }

        return S3BucketManager;
    }

    public void addFileToBucket(String bucketName, String key, String filePath) {

        file = new File(filePath);

        if (s3Client.doesBucketExistV2(bucketName)) {
            try {
                s3Client.putObject(new PutObjectRequest(bucketName, key, file));
            } catch (AmazonServiceException e) {
                System.out.println(e.getErrorMessage());
            }
        }
    }
}
