package api.helpers;

import io.qameta.allure.Allure;

public class Attacher {
    public void expectationAndReality(String expectation, String reality) {
        Allure.attachment("Результат проверки", "Ожидаемое значнеие: " + expectation + "\n" +
                "Фактическое значение: " + reality);
    }

    public void expectationAndReality(int expectation, int reality) {
        expectationAndReality(
                Integer.toString(expectation),
                Integer.toString(reality)
        );
    }

}
