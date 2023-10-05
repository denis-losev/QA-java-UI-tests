package org.praktikum.transitions;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.TestPattern;
import org.praktikum.page_object_model.ConstructorModal;

public class ConstructorTest extends TestPattern {
    @Before
    public void getUrl() {
        webdriver.get(APP_URL);
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверяем, что работает переход к разделу начинок")
    public void checkFilingBtnTest() {
        ConstructorModal constructorModal = new ConstructorModal(webdriver);
        constructorModal.scrollTo(constructorModal.getFilingItem(), constructorModal.getFilingContainer());
        Assert.assertTrue(constructorModal.getElementClass(constructorModal.getFilingContainer()).contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверяем, что работает переход к разделу соусов")
    public void checkSauceBtnTest() {
        ConstructorModal constructorModal = new ConstructorModal(webdriver);
        constructorModal.scrollTo(constructorModal.getSaucesItem(), constructorModal.getSauceContainer());
        Assert.assertTrue(constructorModal.getElementClass(constructorModal.getSauceContainer()).contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверяем, что работает переход к разделу булок")
    public void checkBunsBtnTest() {
        ConstructorModal constructorModal = new ConstructorModal(webdriver);
        constructorModal.scrollTo(constructorModal.getFilingItem(), constructorModal.getFilingContainer());
        constructorModal.scrollTo(constructorModal.getBunsItem(), constructorModal.getBunsContainer());
        Assert.assertTrue(constructorModal.getElementClass(constructorModal.getBunsContainer()).contains("tab_tab_type_current__2BEPc"));
    }
}
