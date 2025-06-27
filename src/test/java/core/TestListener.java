package core;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Тест начат: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Тест успешен: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Тест провален: " + result.getName());
        // Здесь можно добавить код для захвата скриншота
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Тест пропущен: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Все тесты завершены. Количество тестов: " + context.getAllTestMethods().length);
    }
    // Другие методы интерфейса ITestListener можно переопределить по мере необходимости
}
