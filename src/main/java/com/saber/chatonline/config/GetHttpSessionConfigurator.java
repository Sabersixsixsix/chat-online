package com.saber.chatonline.config;


import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig config,
                                  HandshakeRequest request,
                                  HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        // 将HttpSession对象存入配置对象中
        config.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}
