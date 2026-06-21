package com.mockito.advanced.exercise4;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Advanced Exercise 4: Mocking Network Interactions
 */
public class NetworkServiceTest {

    @Test
    void testServiceWithMockNetworkClient() {
        NetworkClient mockNetworkClient = Mockito.mock(NetworkClient.class);

        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        assertEquals("Connected to Mock Connection", result);
        verify(mockNetworkClient).connect();
    }

    @Test
    void testTransferDataFollowsConnectSendDisconnectOrder() {
        NetworkClient mockNetworkClient = Mockito.mock(NetworkClient.class);

        when(mockNetworkClient.connect()).thenReturn("TCP://localhost");
        when(mockNetworkClient.sendData("HELLO")).thenReturn("ACK");
        doNothing().when(mockNetworkClient).disconnect();

        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.transferData("HELLO");

        assertEquals("Transfer via TCP://localhost: ACK", result);

        InOrder inOrder = inOrder(mockNetworkClient);
        inOrder.verify(mockNetworkClient).connect();
        inOrder.verify(mockNetworkClient).sendData("HELLO");
        inOrder.verify(mockNetworkClient).disconnect();
    }
}
