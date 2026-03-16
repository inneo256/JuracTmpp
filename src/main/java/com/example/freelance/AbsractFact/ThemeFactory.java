package com.example.freelance.AbsractFact;

public abstract class ThemeFactory {
    public abstract Theme createTheme();

    // Статический метод — выбирает фабрику по названию
    public static ThemeFactory getFactory(String themeName) {
        if (themeName.equalsIgnoreCase("dark")) {
            return new DarkThemeFactory();
        } else if (themeName.equalsIgnoreCase("pink")) {
            return new PinkThemeFactory();
        } else {
            return new PinkThemeFactory(); // дефолтная
        }
    }
}