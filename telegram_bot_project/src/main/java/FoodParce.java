import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FoodParce extends Food {




    public void parceBest(Update update) throws IOException {


        Document docMultiplex = Jsoup.connect("http://lviv-online.com/ua/rest/restaurant/").get();
        Elements aElements = docMultiplex.getElementsByAttributeValue("class", "places--title");
        Elements lElements = docMultiplex.getElementsByAttributeValue("class", "places--logo");
        Elements tElements = docMultiplex.getElementsByAttributeValue("itemprop", "address");

        Message msg = update.getMessage();
        String txt = msg.getText();


        for (int i = 1; i <= 6; i++) {


            for (Element aElement : aElements.subList(i - 1, i)) {

                Element cElement = aElement;
                String title = cElement.text();


                for (Element tElement : tElements.subList(i - 1, i)) {
                    Element kElement = tElement;
                    String info = kElement.text();

                    for (Element nElement : lElements.subList(i - 1, i)) {
                        Element bElement = nElement;
                        String url = bElement.attr("href");

                        long chat_id = update.getMessage().getChatId();
                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText(title + "\n" + info);

                        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline = new ArrayList<>();

                        rowInline.add(new InlineKeyboardButton().setText("Детальніше").setUrl(url).setCallbackData("update_msg_text"));
                        // Set the keyboard to the markup
                        rowsInline.add(rowInline);
                        // Add it to the message
                        markupInline.setKeyboard(rowsInline);
                        message.setReplyMarkup(markupInline);
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }


                    }
                }

            }
        }
    }


    public void moreFood(Update update) throws IOException {



        Document docMultiplex = Jsoup.connect("http://lviv-online.com/ua/rest/restaurant/").get();
        Elements aElements = docMultiplex.getElementsByAttributeValue("class", "places--title");
        Elements lElements = docMultiplex.getElementsByAttributeValue("class", "places--logo");
        Elements tElements = docMultiplex.getElementsByAttributeValue("itemprop", "address");



        for (int i = 7; i <= 10; i++) {


            for (Element aElement : aElements.subList(i - 1, i)) {

                Element cElement = aElement;
                String title = cElement.text();


                for (Element tElement : tElements.subList(i - 1, i)) {
                    Element kElement = tElement;
                    String info = kElement.text();

                    for (Element nElement : lElements.subList(i - 1, i)) {
                        Element bElement = nElement;
                        String url = bElement.attr("href");

                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(update.getCallbackQuery().getMessage().getChatId())
                                .setText(title + "\n" + info);

                        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                        List<InlineKeyboardButton> rowInline = new ArrayList<>();

                        rowInline.add(new InlineKeyboardButton().setText("Детальніше").setUrl(url).setCallbackData("" +
                                "update_msg_text"));
                        // Set the keyboard to the markup
                        rowsInline.add(rowInline);
                        // Add it to the message
                        markupInline.setKeyboard(rowsInline);
                        message.setReplyMarkup(markupInline);
                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }


                    }
                }


            }

        }
    }

    public void foodInSykhiv(Update update) throws IOException {
        Document docMultiplex = Jsoup.connect("https://www.google.com.ua/search?q=%D0%9A%D0%B0%D1%84%D0%B5+%D1%" +
                "81%D0%B8%D1%85%D1%96%D0%B2&npsic=0&rflfq=1&rlha=0&rllag=49787034,24069345,720&tbm=lcl&ved=0ahUKEwj0g" +
                "-m49JnbAhWOGuwKHWPbAHoQjGoIXQ&tbs=lrf:!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:9&rldoc=1#rlfi=hd:;si:;mv:!" +
                "1m3!1d31543.770231836366!2d24.068792036239984!3d49.80483662020078!3m2!1i780!2i588!4f13.1").get();
        Elements aElements = docMultiplex.getElementsByAttributeValue("class", "cXedhc uQ4NLd");
        Elements cElements = docMultiplex.getElementsByAttributeValue("class", "LJOFid ab_button");


        for (Element aElement : aElements.subList(0, 7)) {
            Element vElement = aElement;

            String title = vElement.text();

            long chat_id = update.getMessage().getChatId();
            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(title);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

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
