package com.univo.backend_app.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class InteligenciaArtificialService {

    private final ChatClient chatClient;

    // Spring Boot inyecta inyecta el cliente ya configurado para hablar con Groq
    public InteligenciaArtificialService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    // Este metodo recibirá las preguntas desde el controlador y nos devolverá la respuesta de Groq
    public String generarRespuestaSimple(String preguntaUsuario) {
        return chatClient.prompt()
                .user(preguntaUsuario)
                .call()
                .content();
    }
}