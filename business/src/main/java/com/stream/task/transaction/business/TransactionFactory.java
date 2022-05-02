package com.stream.task.transaction.business;

import com.google.common.collect.ImmutableMap;
import com.stream.task.transaction.business.constants.ModifyType;
import com.stream.task.transaction.business.transaction.IStreamTaskChangeTransaction;
import com.stream.task.transaction.business.transaction.SubscribeCollectTaskTransaction;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 流式任务变更处理的事务工厂
 *
 * @author Defu Li
 * @since 2022/4/30 0:50
 */
@Component
public class TransactionFactory {
    private final Map<ModifyType, String> transactions = ImmutableMap.of(ModifyType.SUBSCRIBE, "com.stream.task.transaction.business.transaction.SubscribeCollectTaskTransaction");

    public IStreamTaskChangeTransaction begin(ModifyType modifyType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IStreamTaskChangeTransaction transaction = null;
        Class<?> clazz = Class.forName(transactions.get(modifyType));
        if (modifyType == ModifyType.SUBSCRIBE) {
            Constructor<?> constructor = clazz.getConstructor(Integer.class);
            transaction = (IStreamTaskChangeTransaction) constructor.newInstance(42);
        } else if (modifyType == ModifyType.UNSUBSCRIBE) {
            // TODO 接着实现
        }

        return transaction;
    }
}
