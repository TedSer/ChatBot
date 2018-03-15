import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Start  extends Bot{

    public void stardcommand(Update e) {
        Message msg = e.getMessage();
        String txt = msg.getText();
        if (txt.equals("/start")){
            sendMsg(msg, "Hello! This is test bot team Visons \n If you don't know any commans enter: /help");
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
