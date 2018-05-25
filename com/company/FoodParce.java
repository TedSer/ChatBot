package com.company;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Location;
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

    public void foodInSykhiv(Update update) {
        Message msg = update.getMessage();
        String txt = msg.getText();



        SendMessage message = new SendMessage() // Create a message object object
                .setChatId(update.getMessage().getChatId())
                .setText("Медобори\n" +
                        "Кафе\n" +
                        "Адреса: проспект Червоної Калини, 102, Львів, Львівська область, 79000\n" +
                        "Години роботи: \n" +
                        "вівторок\t09–23\n" +
                        "середа\t09–23\n" +
                        "четвер\t09–23\n" +
                        "пʼятниця\t09–23\n" +
                        "субота\t09–23\n" +
                        "неділя\n" +
                        "(День Святої Трійці)\n" +
                        "09–23\n" +
                        "Розклад роботи може бути іншим\n" +
                        "понеділок\t09–23\n" +
                        "Запропонувати зміну\n" +
                        "Телефон: 063 015 8838");

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://restaurant-cervonaruta.business.site/"));
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

        sendLocation(msg, 49.784657f, 24.058768f);

        sendMsg(msg, "Оазис\n" +
                "Ресторан\n" +
                "Адреса: проспект Червоної Калини, 35, Львів, Львівська область, 79000\n" +
                "Години роботи:  \n" +
                "вівторок\t12–00\n" +
                "середа\t12–00\n" +
                "четвер\t12–00\n" +
                "пʼятниця\t12–00\n" +
                "субота\t12–00\n" +
                "неділя\n" +
                "12–00\n" +
                "понеділок\t12–00" +
                "Телефон: 03222 24554");

        sendMsg(msg, "Кримська перепічка\n" +
                "Кафе\n" +
                "Адреса: проспект Червоної Калини, 62А, Львів, Львівська область, 79000\n" +
                "Години роботи:  \n" +
                "вівторок\t08:30–20\n" +
                "середа\t08:30–20\n" +
                "четвер\t08:30–20\n" +
                "пʼятниця\t08:30–20\n" +
                "субота\t10–20\n" +
                "неділя\n" +
                "10–20\n" +
                "понеділок\t08:30–20" +
                "Телефон: 068 701 2644");

        sendMsg(msg, "Ресторан Червона Рута\n" +
                "Ресторан\n" +
                "Адреса: вулиця Хуторівка, 26, Львів, Львівська область, 79000\n" +
                "Години роботи:  \n" +
                "вівторок\t11–23\n" +
                "середа\t11–23\n" +
                "четвер\t11–23\n" +
                "пʼятниця\t11–23\n" +
                "субота\t11–23\n" +
                "неділя\n" +
                "11–23\n" +
                "понеділок\t11–23" +
                "Телефон: 068 227 4040");

    }


    public void foodInFrank (Update update){
        Message msg = update.getMessage();
        String txt = msg.getText();


        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Аякси\n" +
                        "Кафе\n" +
                        "Адреса: вул. Володимира Великого, 29, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t09:00–23:00\n"+
                        "вівторок\t09:00–23:00\n" +
                        "середа\t09:00–23:00"+
                        "четвер\t09:00–23:00\n" +
                        "пʼятниця\t09:00–23:00\n" +
                        "субота\t09:00–23:00\n" +
                        "неділя\t09:00–23:00\n"+
                        "Телефон: 0322 986 737");

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://lviv.virtual.ua/ua/object/76308/about.html"));
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

        sendLocation(msg, 49.809050f, 24.009582f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message1 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Гуцульська гражда\n" +
                        "Ресторан\n"+
                        "Адреса: 2 A, вулиця Володимира Великого, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t12:00–23:00\n"+
                        "вівторок\t12:00–23:00\n" +
                        "середа\t12:00–23:00"+
                        "четвер\t12:00–23:00\n" +
                        "пʼятниця\t12:00–23:00\n" +
                        "субота\t12:00–23:00\n" +
                        "неділя\t12:00–23:00\n"+
                        "Телефон: 0322 954 142");
        InlineKeyboardMarkup markupInline1 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();


        rowInline1.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://guculska-grazhda.lviv.ua/"));
        // Set the keyboard to the markup
        rowsInline1.add(rowInline1);
        // Add it to the message
        markupInline1.setKeyboard(rowsInline1);
        message1.setReplyMarkup(markupInline1);
        try {
            execute(message1); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.809312f, 24.015049f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message2 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Арома Кава\n" +
                        "Кафе\n"+
                        "Адреса: вулиця Володимира Великого, 24А, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\tцілодобово\n"+
                        "вівторок\tцілодобово\n" +
                        "середа\tцілодобово"+
                        "четвер\tцілодобово\n" +
                        "пʼятниця\tцілодобово\n" +
                        "субота\tцілодобово\n" +
                        "неділя\tцілодобово\n"+
                        "Телефон: 0322 954 142");
        InlineKeyboardMarkup markupInline2 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();


        rowInline2.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://aromakava.ua/ru/menyu/"));
        // Set the keyboard to the markup
        rowsInline2.add(rowInline2);
        // Add it to the message
        markupInline2.setKeyboard(rowsInline2);
        message2.setReplyMarkup(markupInline2);
        try {
            execute(message2); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.810485f, 23.998180f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message3 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Хвилинкаz\n" +
                        "Кафе\n"+
                        "Адреса: вулиця Героїв УПА, 72, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t09:00–22:00\n"+
                        "вівторок\t09:00–22:00\n" +
                        "середа\t09:00–22:00"+
                        "четвер\t09:00–22:00\n" +
                        "пʼятниця\t09:00–22:00\n" +
                        "субота\t10:00–22:00\n" +
                        "неділя\t10:00–22:00\n"+
                        "Телефон: 0800 501 101");
        InlineKeyboardMarkup markupInline3 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();


        rowInline3.add(new InlineKeyboardButton().setText("Детальніше").setUrl("https://www.okko.ua/uk/services#restaurant"));
        // Set the keyboard to the markup
        rowsInline3.add(rowInline3);
        // Add it to the message
        markupInline.setKeyboard(rowsInline3);
        message3.setReplyMarkup(markupInline3);
        try {
            execute(message3); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.831430f, 23.997021f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message4 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Yolla Cafe\n" +
                        "Кафе\n"+
                        "Адреса: вулиця Наукова, 29а, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t11:00–23:00\n"+
                        "вівторок\t11:00–23:00\n" +
                        "середа\t11:00–23:00"+
                        "четвер\t11:00–23:00\n" +
                        "пʼятниця\t11:00–23:00\n" +
                        "субота\t11:00–23:00\n" +
                        "неділя\t11:00–23:00\n"+
                        "Телефон: 067 192 7942");
        InlineKeyboardMarkup markupInline4 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline4 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();


        rowInline4.add(new InlineKeyboardButton().setText("Детальніше").setUrl("https://ru.foursquare.com/v/pizza-yolla/5820b62d96b0d84ce721dcbd"));
        // Set the keyboard to the markup
        rowsInline4.add(rowInline4);
        // Add it to the message
        markupInline4.setKeyboard(rowsInline4);
        message4.setReplyMarkup(markupInline4);
        try {
            execute(message4); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.803387f, 23.992456f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message5 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Смачні сезони\n" +
                        "Бістро\n"+
                        "Адреса: вулиця Володимира Великого, 59 A, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t10:00–23:00\n"+
                        "вівторок\t10:00–23:00\n" +
                        "середа\t10:00–23:00"+
                        "четвер\t10:00–23:00\n" +
                        "пʼятниця\t10:00–23:00\n" +
                        "субота\t10:00–23:00\n" +
                        "неділя\t09:30–23:00\n"+
                        "Телефон: 067 672 7226");
        InlineKeyboardMarkup markupInline5 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline5 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline5 = new ArrayList<>();


        rowInline5.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://sezony.com.ua/"));
    // Set the keyboard to the markup
        rowsInline5.add(rowInline5);
        // Add it to the message
        markupInline5.setKeyboard(rowsInline5);
        message5.setReplyMarkup(markupInline5);
        try {
            execute(message5); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.807854f, 24.000001f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message6 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Перфетто\n" +
                        "Кафе\n"+
                        "Адреса: вулиця Сар'яна, 6, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t12:00–19:00\n"+
                        "вівторок\t12:00–19:00\n" +
                        "середа\t12:00–19:00"+
                        "четвер\t12:00–19:00\n" +
                        "пʼятниця\t12:00–19:00\n" +
                        "субота\t12:00–19:00\n" +
                        "неділя\t12:00–19:00\n"+
                        "Телефон: 068 011 7613");
        InlineKeyboardMarkup markupInline6 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline6 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline6 = new ArrayList<>();


        rowInline6.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://lviv.virtual.ua/ua/object/362238/Perfetto-Cafe.html"));
        // Set the keyboard to the markup
        rowsInline6.add(rowInline6);
        // Add it to the message
        markupInline6.setKeyboard(rowsInline6);
        message6.setReplyMarkup(markupInline6);
        try {
            execute(message6); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.834250f, 24.001800f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message7 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Багет\n" +
                        "Кафе\n"+
                        "Адреса: 68, вулиця Генерала Чупринки, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t09:00–22:00\n"+
                        "вівторок\t09:00–22:00\n" +
                        "середа\t09:00–22:00"+
                        "четвер\t09:00–22:00\n" +
                        "пʼятниця\t09:00–22:00\n" +
                        "субота\t10:00–22:00\n" +
                        "неділя\t10:00–22:00\n"+
                        "Телефон: 097 077 5775");
        InlineKeyboardMarkup markupInline7 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline7 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline7 = new ArrayList<>();


        rowInline7.add(new InlineKeyboardButton().setText("Детальніше").setUrl("https://tomato.ua/ua/lviv/restaurants/baguette"));
        // Set the keyboard to the markup
        rowsInline7.add(rowInline7);
        // Add it to the message
        markupInline7.setKeyboard(rowsInline7);
        message7.setReplyMarkup(markupInline7);
        try {
            execute(message7); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.830527f, 24.008112f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message8 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Чехович\n" +
                        "Кафе\n"+
                        "Адреса: вулиця Героїв УПА, 72, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t08:29–21:00\n"+
                        "вівторок\t08:29–21:00\n" +
                        "середа\t08:29–21:00\n"+
                        "четвер\t08:29–21:00\n" +
                        "пʼятниця\t08:29–21:00\n" +
                        "субота\t10:00–22:00\n" +
                        "неділя\t09:59–21:00\n"+
                        "Телефон: 095 761 2419");
        InlineKeyboardMarkup markupInline8 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline8 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline8 = new ArrayList<>();


        rowInline8.add(new InlineKeyboardButton().setText("Детальніше").setUrl("https://lv.cf.ua/news/news-cf/palyarnya-chehovich-ne-paliti-a-obsmazhuvati"));
        // Set the keyboard to the markup
        rowsInline8.add(rowInline8);
        // Add it to the message
        markupInline8.setKeyboard(rowsInline8);
        message8.setReplyMarkup(markupInline8);
        try {
            execute(message8); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.831769f, 23.996553f);
        //----------------------------------------------------------------------------------------------------------------//
        SendMessage message9 = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Fika\n" +
                        "Кафе\n"+
                        "Адреса: 79000, вулиця Степана Бандери, 21, Львів, Львівська область, 79000\n" +
                        "Години роботи:  \n"+
                        "понеділок\t08:29–21:00\n"+
                        "вівторок\t08:29–21:00\n" +
                        "середа\t08:29–21:00\n"+
                        "четвер\t08:29–21:00\n" +
                        "пʼятниця\t08:29–21:00\n" +
                        "субота\t10:00–22:00\n" +
                        "неділя\t09:59–21:00\n"+
                        "Телефон: 067 007 4660");
        InlineKeyboardMarkup markupInline9 = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline9 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline9 = new ArrayList<>();


        rowInline9.add(new InlineKeyboardButton().setText("Детальніше").setUrl("https://www.fika.com.ua/"));
        // Set the keyboard to the markup
        rowsInline9.add(rowInline9);
        // Add it to the message
        markupInline9.setKeyboard(rowsInline9);
        message9.setReplyMarkup(markupInline9);
        try {
            execute(message9); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendLocation(msg, 49.834494f, 24.015082f);


        }


        public void foodInLuchakiv(Update update){
            Message msg = update.getMessage();
            String txt = msg.getText();


            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText("Кафе-вітальня\n" +
                            "Кафе\n" +
                            "Адреса: вул. вулиця Академіка Богомольця, 6/1, Львів, Львівська область, 79000\n" +
                            "Години роботи:  \n"+
                            "понеділок\t09:00–20:00\n"+
                            "вівторок\t09:00–20:00\n" +
                            "середа\t09:00–20:00"+
                            "четвер\t09:00–20:00\n" +
                            "пʼятниця\t09:00–20:00\n" +
                            "субота\t10:00–18:00\n" +
                            "неділя\t10:00–18:00\n"+
                            "Телефон: 097 498 6449");

            InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
            List<InlineKeyboardButton> rowInline = new ArrayList<>();

            rowInline.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://lviv.virtual.ua/ua/object/377165/Livingroom-Cafe.html"));
            // Set the keyboard to the markup
            rowsInline.add(rowInline);
            // Add it to the message1
            markupInline.setKeyboard(rowsInline);
            message.setReplyMarkup(markupInline);
            try {
                execute(message); // Sending our message1 object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            sendLocation(msg, 49.837262f, 24.035780f);
            //----------------------------------------------------------------------------------------------------------------//
            SendMessage message1 = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText("Ліванська кухня\n" +
                            "Кафе\n" +
                            "Адреса: вулиця Пекарська, 9, Львів, Львівська область, 79000\n" +
                            "Години роботи:  \n"+
                            "понеділок\t10:00–23:00\n"+
                            "вівторок\t10:00–23:00\n" +
                            "середа\t10:00–23:00"+
                            "четвер\t10:00–23:00\n" +
                            "пʼятниця\t10:00–23:00\n" +
                            "субота\t10:00–23:00\n" +
                            "неділя\t10:00–23:00\n"+
                            "Телефон: 0322 752 014");

            InlineKeyboardMarkup markupInline1 = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInline1 = new ArrayList<>();
            List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

            rowInline1.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://www.beirut-hall.com.ua/#anchor-u345"));
            // Set the keyboard to the markup
            rowsInline1.add(rowInline1);
            // Add it to the message1
            markupInline1.setKeyboard(rowsInline1);
            message1.setReplyMarkup(markupInline1);
            try {
                execute(message1); // Sending our message1 object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            sendLocation(msg, 49.837990f, 24.037392f);
            //----------------------------------------------------------------------------------------------------------------//

            SendMessage message2 = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText("The Garage\n" +
                            "Кафе\n" +
                            "Адреса:  вулиця Джорджа Вашингтона, 3, Львів, Львівська область, 79000\n" +
                            "Години роботи:  \n"+
                            "понеділок\t11:00–23:00\n"+
                            "вівторок\t11:00–23:00\n" +
                            "середа\t11:00–23:00"+
                            "четвер\t11:00–23:00\n" +
                            "пʼятниця\t11:00–23:00\n" +
                            "субота\t11:00–23:00\n" +
                            "неділя\t11:00–23:00\n"+
                            "Телефон:  097 586 0301");

            InlineKeyboardMarkup markupInline2 = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInline2 = new ArrayList<>();
            List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

            rowInline2.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://www.garage.lviv.ua/"));
            // Set the keyboard to the markup
            rowsInline2.add(rowInline2);
            // Add it to the message1
            markupInline2.setKeyboard(rowsInline2);
            message2.setReplyMarkup(markupInline2);
            try {
                execute(message2); // Sending our message1 object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            sendLocation(msg, 49.816294f, 24.062346f);
            //----------------------------------------------------------------------------------------------------------------//

            SendMessage message3 = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText("М'ята\n" +
                            "Кафе\n" +
                            "Адреса:   вулиця Зелена, 14, Львів, Львівська область, 79000\n" +
                            "Години роботи:  \n"+
                            "понеділок\t12:00–04:00\n"+
                            "вівторок\t12:00–04:00\n" +
                            "середа\t12:00–04:00"+
                            "четвер\t12:00–04:00\n" +
                            "пʼятниця\t12:00–04:00\n" +
                            "субота\t12:00–04:000\n" +
                            "неділя\t12:00–04:00\n"+
                            "Телефон:  063 299 9739");

            InlineKeyboardMarkup markupInline3 = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInline3 = new ArrayList<>();
            List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

            rowInline3.add(new InlineKeyboardButton().setText("Детальніше").setUrl("https://www.dlab.com.ua/id/9515"));
            // Set the keyboard to the markup
            rowsInline3.add(rowInline3);
            // Add it to the message1
            markupInline3.setKeyboard(rowsInline3);
            message3.setReplyMarkup(markupInline3);
            try {
                execute(message3); // Sending our message1 object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            sendLocation(msg, 49.833480f, 24.037861f);
            //----------------------------------------------------------------------------------------------------------------//
            SendMessage message4 = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText("Друзі Кафе\n" +
                            "Кафе\n" +
                            "Адреса:  вулиця Краківська, 5, Львів, Львівська область, 79000\n" +
                            "Години роботи:  \n"+
                            "понеділок\t08:00–00:00\n"+
                            "вівторок\t08:00–00:00\n" +
                            "середа\t08:00–00:00"+
                            "четвер\t08:00–00:00\n" +
                            "пʼятниця\t08:00–01:00\n" +
                            "субота\t08:00–01:00\n" +
                            "неділя\t08:00–00:00\n"+
                            "Телефон:  0322 472 047");

            InlineKeyboardMarkup markupInline4 = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInline4 = new ArrayList<>();
            List<InlineKeyboardButton> rowInline4 = new ArrayList<>();

            rowInline4.add(new InlineKeyboardButton().setText("Детальніше").setUrl("http://druzicafe.com.ua/"));
            // Set the keyboard to the markup
            rowsInline4.add(rowInline4);
            // Add it to the message1
            markupInline4.setKeyboard(rowsInline4);
            message4.setReplyMarkup(markupInline4);
            try {
                execute(message4); // Sending our message1 object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            sendLocation(msg, 49.842686f, 24.029924f);
            //----------------------------------------------------------------------------------------------------------------//

            SendMessage message5 = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText("Ресторан «Ратуша»\n" +
                            "Ресторан\n" +
                            "Адреса:  вулиця Краківська, 5, Львів, Львівська область, 79000\n" +
                            "Години роботи:  \n"+
                            "понеділок\t10:00–23:00\n"+
                            "вівторок\t10:00–23:00"+
                            "четвер\t10:00–23:00\n" +
                            "пʼятниця\t10:00–23:00\n" +
                            "субота\t10:00–23:00\n" +
                            "неділя\t10:00–23:00\n"+
                            "Телефон:  097 997 5565");

            InlineKeyboardMarkup markupInline5 = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInline5 = new ArrayList<>();
            List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

            rowInline5.add(new InlineKeyboardButton().setText("Детальніше").setUrl("https://ratusha-cafe.virtual.ua/ua/"));
            // Set the keyboard to the markup
            rowsInline5.add(rowInline5);
            // Add it to the message1
            markupInline5.setKeyboard(rowsInline5);
            message5.setReplyMarkup(markupInline5);
            try {
                execute(message5); // Sending our message1 object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            sendLocation(msg, 49.841776f, 24.031113f);
            //----------------------------------------------------------------------------------------------------------------//










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

    private void sendLocation(Message msg, Float latitude, Float longitude) {
        SendLocation sendLoc = new SendLocation();
        sendLoc.setChatId(msg.getChatId());
        sendLoc.setLongitude(longitude);
        sendLoc.setLatitude(latitude);
        try {
            sendLocation(sendLoc);
        } catch (TelegramApiException e1){
            e1.printStackTrace();
        }

    }

    }

