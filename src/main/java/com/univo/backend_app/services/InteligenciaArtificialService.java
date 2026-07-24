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
    // Este metodo recibirá el nombre de un producto nuevo y devuelva automáticamente la categoría ideal del inventario y el nivel de stock mínimo recomendado (Lógica del SaaS InvenMax)
    public String analizarDatosSaaS(String descripcionProducto) {
        String systemPrompt = "Eres el motor de IA de InvenMax, un sistema SaaS de gestión de inventarios. " +
                "Tu tarea es recibir el nombre de un producto, describirlo y clasificarlo. " +
                "Responde EXCLUSIVAMENTE en este formato de una sola línea: " +
                "CATEGORÍA: [Nombre de categoría] | STOCK MÍNIMO RECOMENDADO: [Número entre 5 y 50] | DESCRIPCIÓN: [Descripcion breve Max 150 palabras]. " +
                "No agregues saludos, explicaciones ni puntos extra.";

        return chatClient.prompt()
                .system(systemPrompt)
                .user(descripcionProducto)
                .call()
                .content();
    }
}