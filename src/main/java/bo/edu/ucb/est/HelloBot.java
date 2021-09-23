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
    
    int opcion;
    String message_text;
    String hola="Bienvenido al bot calculadora \nSeleccione una de las siguientes opciones \n1. Sumar 2 números. \n2.Calcular serie fibonacci.";
    int num1;
    int num2;
    int suma;

    @Override
    public String getBotToken() {
        return "";
    }

    @Override
    public void onUpdateReceived(Update update) {
        message_text = update.getMessage().getText();
        SendMessage message = new SendMessage(); 
        message.setText(hola);
        opcion = Integer.parseInt(update.getMessage().getText());
        if (opcion == 1) {

            
                message.setText("Ingrese el primer número");
                num1 = Integer.parseInt(update.getMessage().getText());
                message.setText("Ingrese el segundo número");
                num2 = Integer.parseInt(update.getMessage().getText());
                suma=num1+num2;
                message.setText("La suma es: "+suma);
                message.setText(hola);
            
        }else if(opcion==2){
            message.setText("Funcionalidad no implementada, intente otro día");
            message.setText(hola);
        }
        
    }
    
    
    
    @Override
    public String getBotUsername() {
        return "Calcu_duran_bot";
    }
    
}
