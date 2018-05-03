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

    int value = 5;
    int value2 = 10;

    public  void parce(Update update) throws IOException {
        Message msg = update.getMessage();
        String txt = msg.getText();



        Document docMultiplex = Jsoup.connect("http://kinopalace.lviv.ua").get();
        Elements aElements = docMultiplex.getElementsByAttributeValue("class", "poster-title");


        for (Element aElement : aElements.subList(0, value)) {
            Element cElement = aElement.child(0);
            String urlMultiplex = cElement.attr("href");
            String titleMultiplex = cElement.text();
            sendMsg(msg, titleMultiplex + " " + urlMultiplex);
        }

        sendMsg(msg, "Для перегляду наступних напишіть 'ще'");
        }

        public void parceNext(Update update) throws IOException {

            Message msg = update.getMessage();
            String txt = msg.getText();

            Document docMultiplex = Jsoup.connect("http://kinopalace.lviv.ua").get();
            Elements aElements = docMultiplex.getElementsByAttributeValue("class", "poster-title");

            for (Element aElement : aElements.subList(value + 1 , value + 6)) {
                Element cElement = aElement.child(0);
                String urlMultiplex = cElement.attr("href");
                String titleMultiplex = cElement.text();
                sendMsg(msg, titleMultiplex + " " + urlMultiplex);
            }


        }
        public void parceNext2 (Update update) throws IOException {

        Message msg = update.getMessage();
        String txt = msg.getText();

        Document docMultiplex = Jsoup.connect("http://kinopalace.lviv.ua").get();
        Elements aElements = docMultiplex.getElementsByAttributeValue("class", "poster-title");

        for (Element aElement : aElements.subList(value2 + 1, value2 + 6)) {
            Element cElement = aElement.child(0);
            String urlMultiplex = cElement.attr("href");
            String titleMultiplex = cElement.text();
            sendMsg(msg, titleMultiplex + " " + urlMultiplex);
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

