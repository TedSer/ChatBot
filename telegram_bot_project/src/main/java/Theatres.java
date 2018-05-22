import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Theatres extends Bot {

    public void theatresCommand(Update update) {
        Message msg = update.getMessage();
        String txt = msg.getText();
        Pattern p = Pattern.compile("театр|\\.театр|театр\\.|\\.театр\\.|вистав|\\.вистав|вистав\\.|\\.вистав\\.");
        Matcher m = p.matcher(txt);

        if (m.find()) {

            SendMessage message = new SendMessage()
                    .setChatId(msg.getChatId())
                    .setText("Виберіть для себе найзручніший Театр");


            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow row = new KeyboardRow();
            row.add("Театр опери та балету");
            row.add("Театр ім. Марії Заньковецької");
            row.add("Театр ім. Лесі Українки");
            keyboard.add(row);
            keyboardMarkup.setKeyboard(keyboard);
            message.setReplyMarkup(keyboardMarkup);

            try {
                execute(message);
            } catch (TelegramApiException e2) {
                e2.printStackTrace();
            }

        }


    }
}
