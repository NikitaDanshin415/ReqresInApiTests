package api.helpers;

import io.qameta.allure.Allure;

public class Attacher {
    public void expectationAndReality(String expectation, String reality) {
        Allure.attachment("Результат проверки", "Ожидаемое значнеие: " + expectation + "\n" +
            "Фактическое значение: " + reality);
    }

    public void expectationAndReality(String title, String expectation, String reality) {
        Allure.attachment(title, "Ожидаемое значнеие: " + expectation + "\n" +
            "Фактическое значение: " + reality);
    }

    public void expectationAndReality(int expectation, int reality) {
        expectationAndReality(
            Integer.toString(expectation),
            Integer.toString(reality)
        );
    }

    public void expectationAndReality(String title, int expectation, int reality) {
        expectationAndReality(
            title,
            Integer.toString(expectation),
            Integer.toString(reality)
        );
    }

}
