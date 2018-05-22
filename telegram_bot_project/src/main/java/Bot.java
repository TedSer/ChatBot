import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Location;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.toIntExact;


public class Bot extends TelegramLongPollingBot {




    @Override
    public void onUpdateReceived(Update update) {


//            if (update.getCallbackQuery() != null) {
//                ParceKinopalaceButtons btn = new ParceKinopalaceButtons();
//                try {
//                    btn.button(update);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }

// ВИРІШЕННЯ ЕКСЕПШИНУ!!!
        if (update.getMessage() == null) {   //місце для прописування методів колбеку кнопок, інакши викидає NPE
            if (update.hasCallbackQuery()) {
                String call_data = update.getCallbackQuery().getData();
                long message_id = update.getCallbackQuery().getMessage().getMessageId();
                long chat_id = update.getCallbackQuery().getMessage().getChatId();

                if (call_data.equals("morePalace")) {
                    ParceKinopalaceButtons parceKinopalaceButtons = new ParceKinopalaceButtons();
                    try {
                        parceKinopalaceButtons.moreButtons(update);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (call_data.equals("moreMultiplex")) {
                    ParceMultiplexButtons parceMultiplexButtons = new ParceMultiplexButtons();
                    try {
                        parceMultiplexButtons.moreButtons(update);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (call_data.equals("morePlaneta")) {
                    ParcePlanetaButtons parcePlanetaButtons = new ParcePlanetaButtons();
                    try {
                        parcePlanetaButtons.moreButtons(update);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (call_data.equals("moreFood")) {
                    FoodParce foodParce = new FoodParce();
                    try {
                        foodParce.moreFood(update);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        } else {

            String p = "/help|\\.+\\sкіно\\s+\\.|кіно|\\.+\\sкіно|кіно\\s+\\.|фільм|\\.+робити\\.|робити|\\." +
                    "+робити|робити+\\.|Куди піти\\.|куди піти\\.|\\.куди піти\\.|\\.куди піти|Куди піти|куди піти|куди " +
                    "сходити|куди сходити\\.|\\.куди сходити\\.|\\.куди сходити|\\.+поїсти\\.|поїсти|\\.+поїсти|поїсти+" +
                    "\\.|\\.+їсти|\\.+їсти+\\.|їсти+\\.|їсти|Привіт|привіт|\\.+привіт|\\.+привіт+\\.|привіт\\.|Привіт\\.|" +
                    "Multiplex|Кінопалац|Multiplex Кульпарківська 226 А|Копернік|Театртальна|ім. Довженка|/start|update_msg_text|" +
                    "Update message text|Планета кіно|ще|ближчі|\\.ближ|ближ\\.|\\.ближ\\.|найкращі|\\.найкр|найкр\\." +
                    "|\\.найкр\\.|я задовбався";
            Pattern pattern = Pattern.compile(p);
            Matcher m = pattern.matcher(update.getMessage().getText());

            Start srt = new Start();
            Help hlp = new Help();
            ListOf lst = new ListOf();
            Food fd = new Food();
            Cinema cnm = new Cinema();
            ParceKinopalaceButtons parceKinopalaceButtons = new ParceKinopalaceButtons();


            if (m.find()) {

                srt.startCommand(update);
                hlp.helpCommand(update);
                lst.listCommand(update);
                fd.foodCommand(update);
                cnm.cinemaCommand(update);



            } else {

                sendMsg(update.getMessage(), "Вибач, я тебе не розумію...");
                SendMessage message = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText("Нажми на цю кнопку, щоб дізнатись більше про функціонал↓↓↓↓↓↓↓↓↓↓↓");
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboard = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                row.add("/help");
                keyboard.add(row);
                keyboardMarkup.setKeyboard(keyboard);
                message.setReplyMarkup(keyboardMarkup);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            }


        }
    }

    @Override
    public String getBotUsername() {
        return "Test Bot";
    }



    @Override
    public String getBotToken() {
        return "542267185:AAH5bzZJEvo8g8QEsE74vcEtN1X28CAgiwU";
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



    private void sendLocation(Message msg, Location location, Float longitude, Float latitude) {
        SendLocation sendLoc = new SendLocation();
        sendLoc.setChatId(msg.getChatId());
        sendLoc.setLatitude(latitude);
        sendLoc.setLongitude(longitude);
        try {
            sendLocation(sendLoc);
        } catch (TelegramApiException e1){
            e1.printStackTrace();
        }

    }


}
