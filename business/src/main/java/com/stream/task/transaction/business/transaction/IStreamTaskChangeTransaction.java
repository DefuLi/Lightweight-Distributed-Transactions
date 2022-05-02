package com.stream.task.transaction.business.transaction;

/**
 * 流式任务变更处理的事务
 *
 * @author Defu Li
 * @since 2022/4/30 0:37
 */
public interface IStreamTaskChangeTransaction {
    void commit();

    void rollback();

    boolean isInValidState();
}
