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
        Pattern p = Pattern.compile("/help|кіно|\\.+кіно\\.|\\.+кіно|кіно+\\.|фільм|\\.+робити\\.|робити|\\." +
                "+робити|робити+\\.|Куди піти\\.|куди піти\\.|\\.куди піти\\.|\\.куди піти|Куди піти|куди піти|куди " +
                "сходити|куди сходити\\.|\\.куди сходити\\.|\\.куди сходити|\\.+поїсти\\.|поїсти|\\.+поїсти|поїсти+" +
                "\\.|\\.+їсти|\\.+їсти+\\.|їсти+\\.|їсти|Привіт|привіт|\\.+привіт|\\.+привіт+\\.|привіт\\.|Привіт\\.");
        Matcher m = p.matcher(txt);
        Start srt = new Start();
        Help hlp = new Help();
        List lst = new List();
        Food fd = new Food();
        Cinema cnm = new Cinema();


        if (m.find()){

            srt.startCommand(e);
            hlp.helpCommand(e);
            lst.listCommand(e);
            fd.foodCommand(e);
            cnm.cinemaCommand(e);

        } else {

            sendMsg(msg, "Unknown command");

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
