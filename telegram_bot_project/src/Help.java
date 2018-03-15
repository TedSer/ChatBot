import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Help extends Bot {

    public void helpCommand(Update e) {
        Message msg = e.getMessage();
        String txt = msg.getText();
        if (txt.equals("/help")){
            sendMsg(msg, "This is all commands: \n /start -- Greeting with bot \n /help -- the same page");
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
