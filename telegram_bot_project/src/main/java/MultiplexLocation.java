import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultiplexLocation extends Cinema {



    //
//    SendLocation location = new SendLocation()
//            .setChatId(.getChatId())
//            .setText("Виберіть для себе найзручніший кінотеатр");
//
//
//    private void sendLocation(Location lct, String text) {
//        SendLocation l = new SendLocation();
//        l.setChatId(lct.)
//    }

    public void location(Update update) throws IOException {
        Message msg = update.getMessage();
        String txt = msg.getText();
        ParsMultiplex parsMultiplex = new ParsMultiplex();
//        String loc = "";
//
//
//
//        Document docMultiplex = Jsoup.connect("https://multiplex.ua/ua/cinema/lviv/victoriagardens").get();
//        Elements aElements = docMultiplex.getElementsByAttributeValue("class", "google-maps-link");
//
//        aElements.forEach(aElement ->{
//            Element cElement = aElement.child(0);
//            String urlMultiplexLocation = cElement.attr("href");
//
//
//            sendMsg(msg, urlMultiplexLocation);
//        });

        sendMsg(msg, "https://maps.google.com/maps?ll=49.806232,23.981953&z=15&t=m&hl=en-US&gl=US&mapclient=embed&cid=11981398925180740473");




    }



//    public void sendLocation(Location location, SendLocation sendLocation) {
//        SendLocation sendLocation1 = new SendLocation();
//
//    }
//

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
