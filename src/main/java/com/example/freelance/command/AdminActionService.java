package com.example.freelance.command;

import org.springframework.stereotype.Service;

@Service
public class AdminActionService {

    public String blockUser(String username) {
        return "Пользователь " + username + " заблокирован";
    }

    public String unblockUser(String username) {
        return "Блокировка пользователя " + username + " отменена";
    }

    public String deleteProject(String projectName) {
        return "Проект \"" + projectName + "\" удалён";
    }

    public String restoreProject(String projectName) {
        return "Проект \"" + projectName + "\" восстановлен";
    }

    public String refundMoney(String username) {
        return "Деньги возвращены пользователю " + username;
    }

    public String cancelRefund(String username) {
        return "Возврат денег пользователю " + username + " отменён";
    }

    public String warnUser(String username) {
        return "Пользователю " + username + " выдано предупреждение";
    }

    public String removeWarning(String username) {
        return "Предупреждение пользователя " + username + " отменено";
    }

    public String deleteReview(String reviewName) {
        return "Отзыв \"" + reviewName + "\" удалён";
    }

    public String restoreReview(String reviewName) {
        return "Отзыв \"" + reviewName + "\" восстановлен";
    }

    public String closeDispute(String disputeName) {
        return "Спор \"" + disputeName + "\" закрыт";
    }

    public String reopenDispute(String disputeName) {
        return "Спор \"" + disputeName + "\" снова открыт";
    }

    public String verifyCompany(String companyName) {
        return "Компания \"" + companyName + "\" получила галочку ✔";
    }

    public String removeCompanyVerification(String companyName) {
        return "Галочка компании \"" + companyName + "\" снята";
    }
}