package com.seeshion.bean;

/***
 * @Author:ran
 */
public class StatisticsOfCprOrders {
    /**
     * 总任务数量
     */
    private int totalTask;
    private int successTask;
    private int failTask;
    private int spendingTask;
    /***
     * 最高长渲染时间
     */
    private long longestCostTime;
    /***
     * 最短渲染时间
     */
    private long shortestCostTime;
    private long totalCostTime;
    public double getRateOfSuccess() {
        return this.totalTask > 0 ? (double)this.successTask / this.totalTask : 0;
    }

    public double getRateOfFailed() {
        return this.totalTask > 0 ? (double)this.failTask / this.totalTask : 0;
    }

    public double getRateOfSpending() {
        return this.totalTask > 0 ? (double)this.spendingTask / this.totalTask : 0;
    }

    public double getAverageCostTime() {
        return this.successTask > 0 ? (double)this.totalCostTime / this.successTask : 0;
    }

    public void addTotalTask() {
        this.totalTask += 1;
    }

    public void addFailedTask() {
        this.failTask += 1;
    }

    public void addSpendingTask() {
        this.spendingTask += 1;
    }

    public void addSuccessTask() {
        this.successTask += 1;
    }

    public void addTotalCostTime(long costTime) {
        this.totalCostTime += costTime;
    }

    public int getTotalTask() {
        return totalTask;
    }

    public void setTotalTask(int totalTask) {
        this.totalTask = totalTask;
    }

    public int getSuccessTask() {
        return successTask;
    }

    public void setSuccessTask(int successTask) {
        this.successTask = successTask;
    }

    public int getFailTask() {
        return failTask;
    }

    public void setFailTask(int failTask) {
        this.failTask = failTask;
    }

    public long getLongestCostTime() {
        return longestCostTime;
    }

    public void setLongestCostTime(long longestCostTime) {
        if (longestCostTime > this.longestCostTime) {
            this.longestCostTime = longestCostTime;
        }

    }

    public int getSpendingTask() {
        return spendingTask;
    }

    public void setSpendingTask(int spendingTask) {
        this.spendingTask = spendingTask;
    }

    public long getShortestCostTime() {
        return shortestCostTime;
    }

    public void setShortestCostTime(long shortestCostTime) {
        if (shortestCostTime < this.shortestCostTime) {
            this.shortestCostTime = shortestCostTime;
        }
    }

    public long getTotalCostTime() {
        return totalCostTime;
    }

    public void setTotalCostTime(long totalCostTime) {
        this.totalCostTime = totalCostTime;
    }
}
