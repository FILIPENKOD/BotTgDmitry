import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
public class TgBot  extends TelegramLongPollingBot {
    private String userName;
    private int count = 0;
    private int percent = 0;
    public InlineKeyboardButton programm = InlineKeyboardButton.builder()
            .text("Да")
            .callbackData("Да")
            .build();
    public InlineKeyboardButton programm2 = InlineKeyboardButton.builder()
            .text("Нет")
            .callbackData("Нет")
            .build();
    public InlineKeyboardButton programm3 = InlineKeyboardButton.builder()
            .text("Без разницы")
            .callbackData("Без разницы")
            .build();

    private InlineKeyboardMarkup keyboardProgramm = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(programm2))
            .keyboardRow(List.of(programm3))
            .keyboardRow(List.of(programm))
            .build();


    public InlineKeyboardButton pervoe = InlineKeyboardButton.builder()
            .text("В скорости поиска")
            .callbackData("В скорости поиска")
            .build();
    public InlineKeyboardButton vtoroe = InlineKeyboardButton.builder()
            .text("В простоте написания кода")
            .callbackData("В простоте написания кода")
            .build();
    public InlineKeyboardButton tretie = InlineKeyboardButton.builder()
            .text("ни сном ни духом")
            .callbackData("ни сном ни духом")
            .build();


    private InlineKeyboardMarkup keyboardFormyla = InlineKeyboardMarkup.builder()

            .keyboardRow(List.of(vtoroe))
            .keyboardRow(List.of(pervoe))
            .keyboardRow(List.of(tretie))
            .build();


    public InlineKeyboardButton vopross = InlineKeyboardButton.builder()
            .text("Java")
            .callbackData("Java")
            .build();
    public InlineKeyboardButton vopross2 = InlineKeyboardButton.builder()
            .text("C++")
            .callbackData("C++")
            .build();
    public InlineKeyboardButton vopross3 = InlineKeyboardButton.builder()
            .text("C#")
            .callbackData("C#")
            .build();


    private InlineKeyboardMarkup keyboardVopross = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(vopross2))
            .keyboardRow(List.of(vopross3))
            .keyboardRow(List.of(vopross))
            .build();
    public InlineKeyboardButton primer = InlineKeyboardButton.builder()
            .text("3")
            .callbackData("3")
            .build();
    public InlineKeyboardButton primer2 = InlineKeyboardButton.builder()
            .text("1")
            .callbackData("1")
            .build();
    public InlineKeyboardButton primer3 = InlineKeyboardButton.builder()
            .text("2")
            .callbackData("2")
            .build();
    public InlineKeyboardButton primer4 = InlineKeyboardButton.builder()
            .text("4")
            .callbackData("4")
            .build();

    private InlineKeyboardMarkup getKeyboardPrimer = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(primer2))
            .keyboardRow(List.of(primer))
            .keyboardRow(List.of(primer3))
            .keyboardRow(List.of(primer4))
            .build();

    @Override
    public String getBotUsername() {
        return "@BotMaksonchik";
    }

    @Override
    public String getBotToken() {
        return "7297368093:AAGsK-fOAva7mgPoO1v-Jia7_jLEDhlVKbY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        gg(update);
    }

    public void gg(Update update) {

        if (update.hasCallbackQuery()) {

            String idUser = update.getCallbackQuery().getMessage().getChatId().toString();
            int idMessage = update.getCallbackQuery().getMessage().getMessageId();
            String data = update.getCallbackQuery().getData();
            String queryId = update.getCallbackQuery().getId();

            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(idUser)
                    .messageId(idMessage)
                    .text("")
                    .build();

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .chatId(idUser.toString())
                    .messageId(idMessage)
                    .build();


            if (data.equals("Да") && count == 1) {
                editMessageText.setText("Преимущество бинарного поиска от линейного?");
                editMessageReplyMarkup.setReplyMarkup(keyboardFormyla);
                count++;
                percent = percent + 25;
            } else if (data.equals("Нет") && count == 1 || data.equals("Без разницы") && count == 1) {
                editMessageText.setText("Преимущество бинарного поиска от линейного?");
                editMessageReplyMarkup.setReplyMarkup(keyboardFormyla);
                count++;
            }

            if (data.equals("В скорости поиска") && count == 2) {
                editMessageText.setText("Самый безопасный язык по мнению многих?");
                editMessageReplyMarkup.setReplyMarkup(keyboardVopross);
                count++;
                percent = percent + 25;
            } else if (data.equals("В простоте написания кода") && count == 2 || data.equals("Не в чем") && count == 2) {
                editMessageText.setText("Самый безопасный язык по мнению многих?");
                editMessageReplyMarkup.setReplyMarkup(keyboardVopross);
                count++;
            }

            if (data.equals("Java") && count == 3) {
                editMessageText.setText("2 + 2 / 2");
                editMessageReplyMarkup.setReplyMarkup(getKeyboardPrimer);
                count++;
                percent = percent + 25;
            } else if (data.equals("C++") && count == 3 || data.equals("C#") && count == 3) {
                editMessageText.setText("2 + 2 / 2");
                editMessageReplyMarkup.setReplyMarkup(getKeyboardPrimer);
                count++;
            }

            if (data.equals("3") && count == 4) {
                count++;
                percent = percent + 25;
                editMessageText.setText(getPercent());

            } else if (data.equals("1") && count == 4 || data.equals("4") && count == 4
                    || data.equals("2") && count == 4) {
                count++;
                editMessageText.setText(getPercent());
            }

            AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                    .callbackQueryId(queryId)
                    .build();
            try {
                execute(answerCallbackQuery);
                execute(editMessageText);
                execute(editMessageReplyMarkup);
            } catch (Exception ex) {
                ex.getMessage();
            }

        } else if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            userName = update.getMessage().getFrom().getFirstName();
            count = 0;
            percent = 0;
            sendMenu(update.getMessage().getFrom().getId(), "<b>Массив должен быть отсортированным для бинарного поиска?</b>", keyboardProgramm);
            count++;
        }
    }

    public void sendMenu(Long who, String txt, InlineKeyboardMarkup km) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .parseMode("HTML")
                .text(txt)
                .replyMarkup(km)
                .build();

        try {
            execute(sm);
        } catch (TelegramApiException tae) {
            throw new RuntimeException(tae);
        }
    }

    private String getPercent() {

        String response = userName + ", Вы прошли тест и правильно выполнили " + percent + "% заданий!";
        if (percent >= 70) {
            System.out.println("Пользователь \"" + userName + "\" прошёл тест на " + percent + "%.");
            return response + ".\nТеперь Вы можете связаться с заказчиком\nпо его имени в телеграмме - @maxozaaavr";
        }
        System.out.println("Пользователь \"" + userName + "\" прошёл тест на " + percent + "%.");
        return response;
    }

}












