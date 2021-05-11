package com.company;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {

    public static void main(String[] args) {
        try {
            TelegramBotsApi telegram = new TelegramBotsApi(DefaultBotSession.class);
            //telegram.registerBot(new Bot());
            System.out.println("Bot started");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
