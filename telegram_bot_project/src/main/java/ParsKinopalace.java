import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;

public class ParsKinopalace extends Cinema {

    public  void parce(Update update) throws IOException {
        Message msg = update.getMessage();
        String txt = msg.getText();



        Document docMultiplex = Jsoup.connect("http://kinopalace.lviv.ua").get();
        Elements aElements = docMultiplex.getElementsByAttributeValue("class", "poster-title");








        aElements.forEach(aElement ->{
            Element cElement = aElement.child(0);
            String urlMultiplex = cElement.attr("href");
            String titleMultiplex = cElement.text();

            sendMsg(msg, titleMultiplex + " " + urlMultiplex);
        });









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

