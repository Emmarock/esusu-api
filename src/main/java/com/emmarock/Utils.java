package com.emmarock;

import com.twilio.sdk.Twilio;
import com.twilio.sdk.creator.api.v2010.account.MessageCreator;
import com.twilio.sdk.resource.api.v2010.account.Message;
import com.twilio.sdk.type.PhoneNumber;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;

/**
 * Created by babajide.apata on 3/1/2017.
 */
public class Utils {

    private String accountSid;
    private String authToken;

    public Utils(String accountId, String accountToken) {
        accountSid=accountId;
        authToken=accountToken;
    }

    public  Message sendSMS(String to, String messageBody) throws Exception {

        Twilio.init(accountSid, authToken);
        String destination = padPhoneNumber(to);
        PhoneNumber TO = new PhoneNumber(destination);
        PhoneNumber FROM = new PhoneNumber("+12017309932");
        //PhoneNumber FROM = new PhoneNumber("Esusu");
        return new MessageCreator(
                accountSid,
                TO,
                FROM,
                messageBody
        ).execute();
    }
    public  String padPhoneNumber(String phoneNumber) throws Exception {
        if(phoneNumber.length()<11 || phoneNumber.length()>11){
            throw  new Exception("Invalid mobile number, mobile number must be 11 digits");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+234");
        for(int i=1; i<phoneNumber.length(); i++){
            stringBuilder.append(phoneNumber.charAt(i));
        }
        return stringBuilder.toString();
    }

    public  String phoneVerificationCode(){
        Random random = new Random();
        StringBuilder verificationCode = new StringBuilder();
        for(int i=0; i<6; i++){
            verificationCode.append(random.nextInt(9));
        }
        return verificationCode.toString();
    }

    public  String getZonedDateTimeLagos() {
        Instant now = Instant.now();
        ZoneId zoneId = ZoneId.of("Africa/Lagos");
        ZonedDateTime dateAndTimeInLA = ZonedDateTime.ofInstant(now, zoneId);
        SimpleDateFormat dtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return dtime.format(Date.from(Instant.from(dateAndTimeInLA)));
    }
    public  String getZonedDateTimeExpiry() {
        Instant now = Instant.now();
        ZoneId zoneId = ZoneId.of("Africa/Lagos");
        Date date = Date.from(Instant.from(ZonedDateTime.ofInstant(now, zoneId)).plusMillis(12*3600*1000));
        SimpleDateFormat dtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return dtime.format(date);
    }
}
