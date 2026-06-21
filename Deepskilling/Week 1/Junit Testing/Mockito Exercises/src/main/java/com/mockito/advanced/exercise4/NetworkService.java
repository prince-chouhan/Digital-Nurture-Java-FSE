package com.mockito.advanced.exercise4;

/**
 * Advanced Exercise 4: Mocking Network Interactions
 * NetworkService orchestrates connect, transfer, and disconnect through NetworkClient.
 */
public class NetworkService {

    private final NetworkClient networkClient;

    public NetworkService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public String connectToServer() {
        return "Connected to " + networkClient.connect();
    }

    public String transferData(String data) {
        String connection = networkClient.connect();
        String response = networkClient.sendData(data);
        networkClient.disconnect();
        return "Transfer via " + connection + ": " + response;
    }
}
