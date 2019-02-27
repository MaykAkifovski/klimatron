package com.klimatron.klimatron.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MqttSubscriber implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws MqttException {
        System.out.println("== START SUBSCRIBER ==");

        MqttClient client = new MqttClient("tcp://test.mosquitto.org:1883", MqttClient.generateClientId());
        client.setCallback(new SimpleMqttCallBack());
        client.connect();

        client.subscribe("klimatron_data");
    }
}
