import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cinema extends Bot {




    public void cinemaCommand(Update e){
        Message msg = e.getMessage();
        String txt = msg.getText();
        Pattern p = Pattern.compile("\\.+кіно\\.|кіно|\\.+кіно|кіно+\\.|фільм");
        Matcher m = p.matcher(txt);
        ParsPlaneta parsPlaneta = new ParsPlaneta();
        ParsMultiplex parsMultiplex = new ParsMultiplex();
        ParsKinopalace parsKinopalace = new ParsKinopalace();


        if(txt.equals("Multiplex")){
           try {
               parsMultiplex.parce(e);
           } catch (IOException e1){
               e1.printStackTrace();
           }
        }


        if (txt.equals("Кінопалац")) {
            try {
                parsKinopalace.parce(e);
            } catch (IOException e1){
                e1.printStackTrace();
            }
        }

        if (m.find()){


            SendMessage message = new SendMessage()
                    .setChatId(msg.getChatId())
                    .setText("---------------------");


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

                if (txt.equals("Планета кіно")){
                    try {
                        parsPlaneta.parce(e);
                    } catch (IOException e1){
                        e1.printStackTrace();
                    }
                }

            if (txt.equals("Multiplex")) {
                try {
                    parsMultiplex.parce(e);
                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }





        } else {

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

}
