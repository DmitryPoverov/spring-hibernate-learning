package ru.clevertec.spring.specialist._03_dependencyInjection;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MainWindow implements InitializingBean, DisposableBean {

    private MainWindow() {}

    @Override
    public void destroy() {
        closeConnection();
    }

    @Override
    public void afterPropertiesSet() {
        openConnection();
    }

    private static class MainWindowHolder {
        static MainWindow instance = new MainWindow();
    }

    public static MainWindow getInstance() {
        return MainWindowHolder.instance;
    }

    public void show() {
        System.out.println("\nShow main window");
    }

    public void openConnection() {
        System.out.println("Main window opens connection");
    }

    public void closeConnection() {
        System.out.println("Main window closes connection");
    }
}
