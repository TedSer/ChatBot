
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update e) {
        Message msg = e.getMessage();
        String txt = msg.getText();
        String pattern = "[^/start][^/help]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(txt);
        Start srt = new Start();
        Help hlp = new Help();
        if (m.find()){
            sendMsg(msg, "Unknown command");

        } else {
            srt.stardcommand(e);
            hlp.helpCommand(e);
        }
    }
    @Override
    public String getBotUsername() {
        return "Test Bot";
    }



    @Override
    public String getBotToken() {
        return "НАРОД, ТУТ МАЄ БУТИ ВАЖ ТОКЕН НА БОТА, ПРОГУГЛИТЬ ЯК ЦЕ РОПИТИ, ЩОБ ВИ МОГЛИ ТЕСТЕТИ НА ВАШИХ КОМПАХ!!!";
    }


    @SuppressWarnings("deprecation")
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
