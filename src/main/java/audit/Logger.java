package audit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    //Dia/Mês/Ano Hora:Minuto:Segundo
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Logger() {
    }

    private static String buildLogMessage(String level, String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        return String.format("[%s] [%s] %s", timestamp, level, message);
    }

    public static void info(String message) {
        System.out.println(buildLogMessage("INFO", message));
    }

    public static void error(String message, Exception e) {
        System.err.println(buildLogMessage("ERROR", message));
        if (e != null) {
            e.printStackTrace(); // Imprime o rastreio da pilha no terminal
        }
    }


}