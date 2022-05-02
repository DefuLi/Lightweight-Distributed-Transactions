package com.stream.task.transaction.business.transaction;

/**
 * 订阅采集任务事务
 *
 * @author Defu Li
 * @since 2022/4/30 0:40
 */
public class SubscribeCollectTaskTransaction implements IStreamTaskChangeTransaction {
    private boolean managerLevelState;

    private boolean neLevelState;

    private boolean dataLevelState;

    private int testValue;

    public SubscribeCollectTaskTransaction(int testValue) {
        this.testValue = testValue;
    }

    @Override
    public void commit() {
        // TODO ne操作成功、manager操作失败...
        neLevelState = false;
        managerLevelState = true;
    }

    @Override
    public void rollback() {

    }

    @Override
    public boolean isInValidState() {
        return managerLevelState && neLevelState && dataLevelState;
    }
}
