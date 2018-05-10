package com.esau.mpesatrial.api;

import com.esau.mpesatrial.service.STKPushService;

public class ApiUtils {
    //endpoint of my Api
    public static final String BASE_URL = "https://sandbox.safaricom.co.ke/";

    public static STKPushService getTasksService(String token) {
        return RetrofitClient.getClient(BASE_URL, token).create(STKPushService.class);
    }
}
