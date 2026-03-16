package com.example.freelance.AbsractFact;

public class DarkThemeFactory extends ThemeFactory {
    @Override
    public Theme createTheme() {
        return new Theme(
                "#121212",   // фон страницы — почти чёрный
                "#ffffff",   // шрифт — белый
                "#880e4f",   // кнопки — тёмно-малиновый
                "#6a0040",   // кнопки при наведении — темнее
                "#1e1e1e"    // фон карточки — чуть светлее фона
        );
    }
}