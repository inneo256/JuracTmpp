
package com.example.freelance;

public class ClientCreator extends UserCreator {

    @Override
    public User factoryMethod(String name) {
        return new Client(name);
    }

    @Override
    protected String getDashboardHtml(User user) {
        return "client_dashboard"; // шаблон клиента
    }
}