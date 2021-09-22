/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.ucb.est;

import java.util.List;
import java.util.logging.Level;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



/**
 *
 * @author Bernardo
 */
public class HelloBot extends TelegramLongPollingBot{

    @Override
    public String getBotToken() {
        return "2045747655:AAFVklUemzTTmje0WSQu3zVsgIHvBNeRbTE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chat_id = update.getMessage().getChatId();
        String message_text = update.getMessage().getText();
        SendMessage message = new SendMessage(); 
        if (update.hasMessage() && update.getMessage().hasText()) {

            
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Bienvenido al bot calculadora \nSeleccione una de las siguientes opciones \n1. Sumar 2 números. \n2.Calcular serie fibonacci.");
            try {
                execute(message); 
                
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        int opcion = Integer.parseInt(update.getMessage().getText());
        if (opcion == 1) {

            
            try {
                message.setText("Ingrese el primer número");
                int num1 = Integer.parseInt(update.getMessage().getText());
                execute(message); 
                
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if(opcion==2){
            message.setText("Funcionalidad no implementada, intente otro día");
            try {
                execute(message); 
                
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    
    
    @Override
    public String getBotUsername() {
        return "Calcu_duran_bot";
    }
    
}
