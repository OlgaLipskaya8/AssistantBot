package by;

import by.entity.City;
import by.entity.Info;
import by.services.CityService;
import by.services.InfoService;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class AssistantBot extends TelegramLongPollingBot {
    private CityService cityService;
    private InfoService infoService;

    public AssistantBot(CityService cityService, InfoService infoService) {
        this.cityService = cityService;
        this.infoService = infoService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text = "";
        if (update.hasMessage() && update.getMessage().hasText()) {
            switch(update.getMessage().getText()){
                case "/help": {
                    text = "Введите название города и получите краткую информацию о достопримечательностях";
                    break;
                }
                case "/cities": {
                    List<City> cityList = cityService.getAll();
                    if(!cityList.isEmpty()) {
                        for (City city : cityList) {
                            text += city.getName() + "\n";
                        }
                    } else {
                        text = "Список городов пуст";
                    }
                    break;
                }
                default: {
                    try {
                        City city = cityService.getByName(update.getMessage().getText()).stream().findFirst().get();
                        if (city != null) {
                            for (Info info : city.getInfoList()) {
                                text += info.getText() + "\n";
                            }
                        } else {
                            text = "Город не найден";
                        }
                    } catch(Exception ex){
                        text = "Ошибки на сервере";
                    }
                    break;
                }
            }
        }
        sendMsg(update.getMessage(), text);
    }

    @Override
    public String getBotUsername() {
        return "@CityAssistantBot";
    }

    @Override
    public String getBotToken() {
        return "867485254:AAGHqMOqlfoeVzj2C62FHPrsTNJfTVSwPZM";
    }

    public void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/cities"));
        keyboardFirstRow.add(new KeyboardButton("/help"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            setButtons(sendMessage);
            execute(sendMessage);
        } catch(TelegramApiException e){
            e.printStackTrace();
        }
    }
}
