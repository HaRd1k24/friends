package org.api.friend.executerProvider;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteServiceProvider {
    private static ExecutorService executorService;

    // Приватный конструктор, чтобы предотвратить создание экземпляров
    private ExecuteServiceProvider() {}

    public static synchronized ExecutorService getExecutorService() {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(10);
        }
        return executorService;
    }


    @PreDestroy
    public void destroy() {
        executorService.shutdown();
    }
}
