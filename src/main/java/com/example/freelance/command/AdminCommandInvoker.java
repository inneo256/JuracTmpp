package com.example.freelance.command;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class AdminCommandInvoker {

    private final Stack<AdminCommand> history = new Stack<>();

    public String executeCommand(AdminCommand command) {
        String result = command.execute();
        history.push(command);
        return result;
    }

    public String undoLastCommand() {
        if (history.isEmpty()) {
            return "Нет действий для отмены";
        }

        AdminCommand command = history.pop();
        return command.undo();
    }
}