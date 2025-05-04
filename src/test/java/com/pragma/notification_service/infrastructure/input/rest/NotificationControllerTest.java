package com.pragma.notification_service.infrastructure.input.rest;

import com.pragma.notification_service.application.dto.request.NotificationSendDto;
import com.pragma.notification_service.application.handler.INotificationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationControllerTest {

    @Mock
    private INotificationHandler notificationHandler;

    @InjectMocks
    private NotificationController notificationController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendConfirmationCode_ShouldReturnOkStatus(){
        // Arrange
        NotificationSendDto notificationSendDto = new NotificationSendDto();
        doNothing().when(notificationHandler).sendConfirmationCode(notificationSendDto);

        // Act
        ResponseEntity<Void> response = notificationController.sendConfirmationCode(notificationSendDto);

        //Assert
        verify(notificationHandler, times(1)).sendConfirmationCode(notificationSendDto);
        assertEquals(ResponseEntity.ok().build(), response);
        assertNull(response.getBody());
    }

}