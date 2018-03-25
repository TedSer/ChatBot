import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start  extends Bot{

    public void startCommand(Update e) {
        Message msg = e.getMessage();
        String txt = msg.getText();
        Pattern p = Pattern.compile("Привіт|привіт|\\.+привіт|\\.+привіт+\\.|привіт\\.|Привіт\\.");
        Matcher m = p.matcher(txt);

        if (m.find()){
            sendMsg(msg, "Привіт! Це тестовий бот, щоб дізнатись більше, пропишіть /help");
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
