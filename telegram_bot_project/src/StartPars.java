import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartPars extends Cinema {

    public  void parce(Update e) throws IOException {
        Message msg = e.getMessage();
        String txt = msg.getText();


        Document doc = Jsoup.connect("https://planetakino.ua/lvov/showtimes").get();
        Elements pElements = doc.getElementsByAttributeValue("class", "movie-title") ;




        pElements.forEach(pElement ->  {
            Element aElement = pElement.child(0);
            String url = aElement.attr("href");
            String title = aElement.child(0).text();

            System.out.println( "https://planetakino.ua" + url);
            sendMsg(msg, "https://planetakino.ua" + url);
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

