import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.toIntExact;


public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String txt = msg.getText();
        Pattern p = Pattern.compile("/help|кіно|\\.+кіно\\.|\\.+кіно|кіно+\\.|фільм|\\.+робити\\.|робити|\\." +
                "+робити|робити+\\.|Куди піти\\.|куди піти\\.|\\.куди піти\\.|\\.куди піти|Куди піти|куди піти|куди " +
                "сходити|куди сходити\\.|\\.куди сходити\\.|\\.куди сходити|\\.+поїсти\\.|поїсти|\\.+поїсти|поїсти+" +
                "\\.|\\.+їсти|\\.+їсти+\\.|їсти+\\.|їсти|Привіт|привіт|\\.+привіт|\\.+привіт+\\.|привіт\\.|Привіт\\.|" +
                "Multiplex|Кінопалац");
        Matcher m = p.matcher(txt);
        Start srt = new Start();
        Help hlp = new Help();
        ListOf lst = new ListOf();
        Food fd = new Food();
        Cinema cnm = new Cinema();





        if (m.find()){

            srt.startCommand(update);
            hlp.helpCommand(update);
            lst.listCommand(update);
            fd.foodCommand(update);
            cnm.cinemaCommand(update);


        } else {

            sendMsg(msg, "Чуваче, ти щось не те написав, можливо тобі потрбна допомога?");
            SendMessage message = new SendMessage()
                    .setChatId(msg.getChatId())
                    .setText("Нажміть на цю кнопку, щоб дізнатись більше про функціонал↓↓↓↓↓↓↓↓↓↓↓");
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


}
