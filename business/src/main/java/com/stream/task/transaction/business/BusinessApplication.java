package com.stream.task.transaction.business;

import com.stream.task.transaction.business.constants.ModifyType;
import com.stream.task.transaction.business.transaction.IStreamTaskChangeTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class BusinessApplication {

    @Resource
    private TransactionFactory transactionFactory;

    public void test() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        IStreamTaskChangeTransaction transaction = transactionFactory.begin(ModifyType.SUBSCRIBE);
        transaction.commit();
        if (transaction.isInValidState()) {
            transaction.rollback();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);


    }

}
