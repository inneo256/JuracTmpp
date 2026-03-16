package com.example.freelance.AbsractFact;

public class PinkThemeFactory extends ThemeFactory {
    @Override
    public Theme createTheme() {
        return new Theme(
                "#fff0f5",   // фон страницы
                "#dc143c",   // цвет текста
                "#e91e8c",   // кнопки
                "#c2185b",   // кнопки при наведении
                "#ffffff"    // фон карточки
        );
    }
}