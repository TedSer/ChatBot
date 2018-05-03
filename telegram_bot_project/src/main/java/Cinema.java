import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import org.telegram.telegrambots.api.objects.Location;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Cinema extends Bot {




    public void cinemaCommand(Update update){
        Message msg = update.getMessage();
        String txt = msg.getText();
        Pattern p = Pattern.compile("\\.+кіно\\.|кіно|\\.+кіно|кіно+\\.|фільм");
        Matcher m = p.matcher(txt);
        ParsPlaneta parsPlaneta = new ParsPlaneta();
        ParsMultiplex parsMultiplex = new ParsMultiplex();
        ParsKinopalace parsKinopalace = new ParsKinopalace();
        MultiplexLocation multiplexLocation = new MultiplexLocation();




        if (txt.equals("Multiplex")){

            sendMsg(msg, "https://maps.google.com/maps?ll=49.806232,23.981953&z=15&t=m&hl=en-US&gl" +
                    "=US&mapclient=embed&cid=11981398925180740473");

            SendMessage message = new SendMessage()
                    .setChatId(msg.getChatId())
                    .setText("Виберіть локацію кінотеатру");


            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow row = new KeyboardRow();
            row.add("Multiplex Кульпарківська 226 А");
            keyboard.add(row);
            keyboardMarkup.setKeyboard(keyboard);
            message.setReplyMarkup(keyboardMarkup);

            try {
                execute(message);
            } catch (TelegramApiException e2) {
                e2.printStackTrace();
            }


        }


        if (txt.equals("Планета кіно")) {

            try {
                parsPlaneta.parce(update);
            } catch (IOException e1){
                e1.printStackTrace();
            }


        }


                if (txt.equals("Multiplex Кульпарківська 226 А")){
                    try{
                        parsMultiplex.parce(update);
                    } catch (IOException e1){
                        e1.printStackTrace();
                    }



        }

//
//        if (txt.equals("Кінопалац")) {
//            try {
//                parsKinopalace.parce(update);
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//
//
//            SendMessage message = new SendMessage()
//                    .setChatId(msg.getChatId())
//                    .setText("Виберіть локацію кінотеатру");
//
//
//            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
//            List<KeyboardRow> keyboard = new ArrayList<>();
//            KeyboardRow row = new KeyboardRow();
//            row.add("ім. Довженка");
//            row.add("Театртальна");
//            row.add("Копернік");
//            keyboard.add(row);
//            keyboardMarkup.setKeyboard(keyboard);
//            message.setReplyMarkup(keyboardMarkup);
//
//            try {
//                execute(message);
//            } catch (TelegramApiException e2) {
//                e2.printStackTrace();
//            }
//
//        }


        if (txt.equals("ім. Довженка")){
            sendMsg(msg, "https://www.google.com.ua/maps/place/%D0%9A%D1%96%D0%BD%D0%BE%D0%BF%D0%B0%D0%BB%D0%B" +
                    "0%D1%86+%D1%96%D0%BC.+%D0%94%D0%BE%D0%B2%D0%B6%D0%B5%D0%BD%D0%BA%D0%B0/@49.7901703,23.997616,12z" +
                    "/data=!4m8!1m2!2m1!1z0LrRltC90L7Qv9Cw0LvQsNGG!3m4!1s0x473ae86d3aa07edd:0x225db12979ffb78a!8m2!" +
                    "3d49.7950917!4d24.0577198");
        }


        if (txt.equals("Театртальна")){
            sendMsg(msg, "https://www.google.com/maps/place/%D0%9A%D1%96%D0%BD%D0%BE%D0%BF%D0%B0%D0%BB%D0%B0%D" +
                    "1%86/@49.7901703,23.997616,12z/data=!4m8!1m2!2m1!1z0LrRltC90L7Qv9Cw0LvQsNGG!3m4!1s0x473add72950" +
                    "f6e8d:0x6cf545e48e348c1f!8m2!3d49.8432393!4d24.0287981");
        }

        if (txt.equals("Копернік")) {
            sendLocation(msg,  49.838769f, 24.027179f);
        }


        if (m.find()) {




            SendMessage message = new SendMessage()
                    .setChatId(msg.getChatId())
                    .setText("Виберіть для себе найзручніший кінотеатр");


                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboard = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                row.add("Планета кіно");
                row.add("Multiplex");
                row.add("Кінопалац");
                keyboard.add(row);
                keyboardMarkup.setKeyboard(keyboard);
                message.setReplyMarkup(keyboardMarkup);

                try {
                    execute(message);
                } catch (TelegramApiException e2) {
                    e2.printStackTrace();
                }






        }


    }







        private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(text);
        try {
            sendMessage(s);

        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    private void sendLocation(Message msg, Float latitude, Float longitude) {
        SendLocation sendLoc = new SendLocation();
        sendLoc.setChatId(msg.getChatId());
        sendLoc.setLongitude(longitude);
        sendLoc.setLatitude(latitude);
        try {
            sendLocation(sendLoc);
        } catch (TelegramApiException e1){
            e1.printStackTrace();
        }

    }

}
