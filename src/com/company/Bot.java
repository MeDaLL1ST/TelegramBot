package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {

    ReplyKeyboardMarkup keyboard12 = new ReplyKeyboardMarkup();
    String out1;

    @Override
    public void onUpdateReceived(Update update) {

        update.getUpdateId();
        SendMessage msg = new SendMessage();
        msg.setChatId(update.getMessage().getChatId().toString());
        msg.setReplyMarkup(keyboard12);
        keyboard12.setSelective(true);
        keyboard12.setResizeKeyboard(true);
        keyboard12.setOneTimeKeyboard(false);


        if (update.getMessage().getText().equals("/start") || update.getMessage().getText().equals("Меню")) {
            setKeyboardH();
            msg.setText("Привет! Скажи что ты хочешь сделать:" + "\n" +
                    "1.HTML" + "\n" +
                    "2.Погода в реальном времени" + "\n" +
                    "3.Курсы валют в реальном времени");
            sendMsg(msg);
        }


        if (update.getMessage().getText().equals("1") || update.getMessage().getText().equals("HTML")) {
            msg.setText("Введи ссылку:");
            sendMsg(msg);
        }

        if (update.getMessage().getText().contains("https://") || update.getMessage().getText().contains("http://") || update.getMessage().getText().contains("Http://") || update.getMessage().getText().contains("Https://")) {
            String ss1 = update.getMessage().getText();
            setKeyboardH();

            BufferedReader reader = null;
            try {
                URL site = new URL(ss1);
                reader = new BufferedReader(new InputStreamReader(site.openStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    msg.setText(line);
                    sendMsg(msg);
                }
                reader.close();
            } catch (IOException ex) {
                System.out.println(ex);
                msg.setText("Error");
                sendMsg(msg);

            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {

                }
            }
        }

        if (update.getMessage().getText().equals("2") || update.getMessage().getText().equals("Погода")) {
            setKeyboard();
            msg.setText("Выбери город:" + "\n" +
                    "Moscow" + "\n" +
                    "Spb" + "\n" +
                    "Sochi" + "\n" +
                    "Murmansk" + "\n" +
                    "Krasnodar" + "\n" +
                    "London" + "\n" +
                    "Los Angeles" + "\n" +
                    "Kazan" + "\n" +
                    "Berlin" + "\n" +
                    "Tokyo" + "\n" +
                    "Voronezh" + "\n" +
                    "Vladivostok" + "\n" +
                    "Paris" + "\n" +
                    "Chicago");

            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Moscow") || update.getMessage().getText().equals("Москва")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Kazan") || update.getMessage().getText().equals("Казань")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Kazan&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Spb")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Saint%20Petersburg&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Krasnodar") || update.getMessage().getText().equals("Краснодар")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Krasnodar&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Sochi") || update.getMessage().getText().equals("Сочи")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Sochi&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Los Angeles")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Los%20Angeles&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("London") || update.getMessage().getText().equals("Лондон")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=London&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Murmansk") || update.getMessage().getText().equals("Мурманск")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Murmansk&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Berlin") || update.getMessage().getText().equals("Берлин")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Berlin&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Tokyo") || update.getMessage().getText().equals("Токио")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Tokyo&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Voronezh") || update.getMessage().getText().equals("Воронеж")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Voronezh&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Vladivostok") || update.getMessage().getText().equals("Владивосток")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Vladivostok&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Chicago") || update.getMessage().getText().equals("Чикаго")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Chicago&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("Paris") || update.getMessage().getText().equals("Париж")) {
            setKeyboard();
            msg.setText(mn("http://api.openweathermap.org/data/2.5/weather?q=Paris&appid=token"));
            sendMsg(msg);
        }

        if (update.getMessage().getText().equals("3") || update.getMessage().getText().equals("Курсы")) {

            String output = getUrlContent("https://www.cbr-xml-daily.ru/daily_json.js");
            JSONObject obj = new JSONObject(output);
            JSONObject c = obj.getJSONObject("Valute");
            JSONObject cd = c.getJSONObject("USD");
            JSONObject ce = c.getJSONObject("EUR");
            Double rub2 = ce.getDouble("Value");
            Double rub1 = cd.getDouble("Value");
            msg.setText("Доллар в рублях: " + rub1 + "\n" +
                    "Евро в рублях: " + rub2);
            sendMsg(msg);
        }
    }//end update

    String mn(String api) {

        String output = getUrlContent(api);
        JSONObject jObject = new JSONObject(output);
        JSONArray myValue = jObject.getJSONArray("weather");//weather
        JSONObject c = myValue.getJSONObject(0);        //weather
        String mainn = c.getString("main");             //weather
        String namen = jObject.getString("name");         //city
        Integer temp = jObject.getJSONObject("main").getInt("temp");
        temp -= 273;
        Integer spd = jObject.getJSONObject("wind").getInt("speed");
        out1 = "Город: " + namen + "\n" +
                "Примерная температура в городе: " + temp + "°" + "\n" +
                "Погода сейчас: " + mainn + "\n" +
                "Ветер: " + spd + " m/s";
        return out1;
    }

    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error53");
        }
        return content.toString();
    }

    @Override
    public String getBotUsername() {
        return "perv11_bot";
    }

    @Override
    public String getBotToken() {
        return "token";
    }

    void sendMsg(SendMessage msg) {
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    void setKeyboard() {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        KeyboardRow keyboard3Row = new KeyboardRow();
        KeyboardRow keyboard4Row = new KeyboardRow();
        KeyboardRow keyboard5Row = new KeyboardRow();
        KeyboardRow keyboard6Row = new KeyboardRow();
        KeyboardRow keyboard7Row = new KeyboardRow();
        KeyboardRow keyboard8Row = new KeyboardRow();
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Москва");
        keyboardFirstRow.add("Spb");
        keyboardSecondRow.add("Сочи");
        keyboardSecondRow.add("Мурманск");
        keyboard3Row.add("Краснодар");
        keyboard3Row.add("Лондон");
        keyboard4Row.add("Los Angeles");
        keyboard4Row.add("Казань");
        keyboard5Row.add("Берлин");
        keyboard5Row.add("Токио");
        keyboard6Row.add("Воронеж");
        keyboard6Row.add("Владивосток");
        keyboard7Row.add("Париж");
        keyboard7Row.add("Чикаго");
        keyboard8Row.add("Меню");
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboard3Row);
        keyboard.add(keyboard4Row);
        keyboard.add(keyboard5Row);
        keyboard.add(keyboard6Row);
        keyboard.add(keyboard7Row);
        keyboard.add(keyboard8Row);
        keyboard12.setKeyboard(keyboard);
    }

    void setKeyboardH() {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Погода");
        keyboardFirstRow.add("Курсы");
        keyboardSecondRow.add("HTML");
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard12.setKeyboard(keyboard);
    }
}
