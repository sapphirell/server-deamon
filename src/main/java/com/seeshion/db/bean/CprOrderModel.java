package com.seeshion.db.bean;

public class CprOrderModel {


    private String productId;
    /***
     * '0=等待渲染 1=渲染成功 其它=错误码
     */
    private int status;
    private String uid;
    private String recordId;
    /***
     * 1=渲染任务 2=剪辑任务
     */
    private int renderType;

    private long createdAt;

    private String userFeatures;

    private String ext;

    private String notifyUrl;

    private long costTime;

    private int notifyResult;

    private String resultVideoUrl;

    private String queueTaskData;

    private int repeatedByTaskFailedNum;

    private String userPostData;

    private String errorMessage;

    private String accessKey;

    private String accessSecret;

    private String consumeFeature;

    private String queueName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public int getRenderType() {
        return renderType;
    }

    public void setRenderType(int renderType) {
        this.renderType = renderType;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserFeatures() {
        return userFeatures;
    }

    public void setUserFeatures(String userFeatures) {
        this.userFeatures = userFeatures;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    public int getNotifyResult() {
        return notifyResult;
    }

    public void setNotifyResult(int notifyResult) {
        this.notifyResult = notifyResult;
    }

    public String getResultVideoUrl() {
        return resultVideoUrl;
    }

    public void setResultVideoUrl(String resultVideoUrl) {
        this.resultVideoUrl = resultVideoUrl;
    }

    public String getQueueTaskData() {
        return queueTaskData;
    }

    public void setQueueTaskData(String queueTaskData) {
        this.queueTaskData = queueTaskData;
    }

    public int getRepeatedByTaskFailedNum() {
        return repeatedByTaskFailedNum;
    }

    public void setRepeatedByTaskFailedNum(int repeatedByTaskFailedNum) {
        this.repeatedByTaskFailedNum = repeatedByTaskFailedNum;
    }

    public String getUserPostData() {
        return userPostData;
    }

    public void setUserPostData(String userPostData) {
        this.userPostData = userPostData;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getConsumeFeature() {
        return consumeFeature;
    }

    public void setConsumeFeature(String consumeFeature) {
        this.consumeFeature = consumeFeature;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
