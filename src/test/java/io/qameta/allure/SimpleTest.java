package io.qameta.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

    @Test
    @Feature("Diamond")
    @Owner("Karim")
    @DisplayName("Brilliant test")
    void simpleTest(){
    Allure.step("first brilliant step");
    Allure.step("second brilliant step");
    Allure.step("third brilliant step");
}
