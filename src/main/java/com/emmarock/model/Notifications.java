package com.emmarock.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by babajide.apata on 2/14/2017.
 */

public class Notifications {
    @Id
    private String id;
    private String fromUser;
    private String toUser;
    private String content;
    private String notificationDate;
    private String notificationType;
    private String notificationStatus;
    private Notifications(Builder builder) {

        setId(builder.id);
        setFromUser(builder.fromUser);
        setToUser(builder.toUser);
        setContent(builder.content);
        setNotificationDate(builder.notificationDate);
        setNotificationType(builder.notificationType);
        setNotificationStatus(builder.notificationStatus);
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "id=" + id +
                ", fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                ", content='" + content + '\'' +
                ", notificationDate='" + notificationDate + '\'' +
                ", notificationType='" + notificationType + '\'' +
                ", notificationStatus='" + notificationStatus + '\'' +
                '}';
    }

    public Notifications() {
        UUID uuid = UUID.randomUUID();
        id=uuid.toString();
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public static final class Builder {
        private String id;
        private String fromUser;
        private String toUser;
        private String content;
        private String notificationDate;
        private String notificationType;
        private String notificationStatus;
        public Builder() {
        }

        public Builder notificationId(String id) {
            this.id = id;
            return this;
        }

        public Builder fromUser(String fromUser) {
            this.fromUser = fromUser;
            return this;
        }

        public Builder toUser(String toUser) {
            this.toUser = toUser;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder notificationDate(String notificationDate) {
            this.notificationDate = notificationDate;
            return this;
        }

        public Builder notificationType(String notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public Builder notificationStatus(String notificationStatus){
            this.notificationStatus=notificationStatus;
            return this;
        }
        public Notifications build() {
            return new Notifications(this);
        }
    }
}
