package com.example.freelance;

public abstract class UserCreator {

    // Factory Method — создаёт конкретного пользователя
    public abstract User factoryMethod(String name);

    // Метод для создания кабинета
    // Возвращает название HTML-шаблона, на который пойдёт пользователь
    public String createDashboard(String name) {
        // Создаём конкретного пользователя через фабрику
        User user = factoryMethod(name);

        // Здесь можно делать любую общую логику, например инициализацию данных кабинета
        System.out.println(user.getRole() + " " + user.getName() + " вошёл в систему");

        // Возвращаем шаблон, конкретный фабричный класс решает какой
        return getDashboardHtml(user);
    }

    // Абстрактный метод — конкретный класс указывает HTML-шаблон
    protected abstract String getDashboardHtml(User user);
}