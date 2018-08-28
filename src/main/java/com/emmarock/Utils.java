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
    private static String accountSid = "AC0344c5deadf63f51f7354754a8622f83";
    private static String authToken = "deb7839956801de4ecd181957d84f179";
    public static Message sendSMS(String to, String messageBody) {

        Twilio.init(accountSid, authToken);
        PhoneNumber TO = new PhoneNumber(to);
        //PhoneNumber FROM = new PhoneNumber("+12017309932");
        PhoneNumber FROM = new PhoneNumber("Esusu");
        return new MessageCreator(
                accountSid,
                TO,
                FROM,
                messageBody
        ).execute();
    }
    public static String padPhoneNumber(String phoneNumber) throws Exception {
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

    public static String phoneVerificationCode(){
        Random random = new Random();
        StringBuilder verificationCode = new StringBuilder();
        for(int i=0; i<6; i++){
            verificationCode.append(random.nextInt(9));
        }
        return verificationCode.toString();
    }

    public static String getZonedDateTimeLagos() {
        Instant now = Instant.now();
        ZoneId zoneId = ZoneId.of("Africa/Lagos");
        ZonedDateTime dateAndTimeInLA = ZonedDateTime.ofInstant(now, zoneId);
        SimpleDateFormat dtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return dtime.format(Date.from(Instant.from(dateAndTimeInLA)));
    }
    public static String getZonedDateTimeExpiry() {
        Instant now = Instant.now();
        ZoneId zoneId = ZoneId.of("Africa/Lagos");
        Date date = Date.from(Instant.from(ZonedDateTime.ofInstant(now, zoneId)).plusMillis(12*3600*1000));
        SimpleDateFormat dtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return dtime.format(date);
    }
    public static void main(String[] args) throws Exception {
       /* String paddedNumber = padPhoneNumber("08139651424");
        System.out.println(paddedNumber);
        System.out.println(phoneVerificationCode());
        String sms = "Dear  Babajide, your down line  has make donation to you, kindly approve on time, cheers";
        Utils.sendSMS(paddedNumber,sms);*/
        StringBuilder builder = new StringBuilder();
        builder.append("Emmanuel*( *123 &^$)");
        builder.reverse();
        System.out.println(builder.toString());
        System.out.println(getZonedDateTimeExpiry());

        System.out.println(getZonedDateTimeLagos());
    }
}
