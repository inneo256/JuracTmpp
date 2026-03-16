package com.example.freelance;

public class Order {
    private String title;        // обязательное
    private String description;  // обязательное
    private Double price;        // необязательное
    private String deadline;     // необязательное

    // Конструктор приватный — только через Builder
    private Order() {}

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }
    public String getDeadline() { return deadline; }

    @Override
    public String toString() {
        return "Заказ: " + title +
                " | Описание: " + description +
                (price != null ? " | Цена: " + price : "") +
                (deadline != null ? " | Срок: " + deadline : "");
    }

    // Builder внутри класса Order
    public static class Builder {
        private String title;
        private String description;
        private Double price;
        private String deadline;

        // Обязательные поля — в конструкторе Builder
        public Builder(String title, String description) {
            this.title = title;
            this.description = description;
        }

        // Необязательные — через методы
        public Builder price(Double price) {
            this.price = price;
            return this; // возвращаем this чтобы можно было цепочкой вызывать
        }

        public Builder deadline(String deadline) {
            this.deadline = deadline;
            return this;
        }

        // Финальный метод — строит объект
        public Order build() {
            Order order = new Order();
            order.title = this.title;
            order.description = this.description;
            order.price = this.price;
            order.deadline = this.deadline;
            return order;
        }
    }
}