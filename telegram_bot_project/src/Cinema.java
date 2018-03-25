import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cinema extends Bot {

    public void cinemaCommand(Update e){
        Message msg = e.getMessage();
        String txt = msg.getText();
        Pattern p = Pattern.compile("\\.+кіно\\.|кіно|\\.+кіно|кіно+\\.|фільм");
        Matcher m = p.matcher(txt);
        StartPars strp = new StartPars();



        if (m.find()){
            try{
                strp.parce(e);
            } catch (IOException e1){
                System.out.println("Дупа");
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
