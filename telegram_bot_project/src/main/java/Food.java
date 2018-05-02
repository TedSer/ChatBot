import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Food extends Bot {

    public void foodCommand(Update update) {
        Message msg = update.getMessage();
        String txt = msg.getText();
        Pattern p = Pattern.compile("\\.+поїсти\\.|поїсти|\\.+поїсти|поїсти+\\.|\\.+їсти|\\.+їсти+\\.|їсти+\\.|їсти|" +
                "\\.жерти|жерти\\.|\\.жерти\\.");
        Matcher m = p.matcher(txt);

        if (m.find()){
            sendMsg(msg, "Hear will be list of institution.");
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
