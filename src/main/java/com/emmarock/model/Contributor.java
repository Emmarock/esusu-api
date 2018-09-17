package com.emmarock.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;
import org.springframework.data.annotation.Id;

/**
 * Created by babajide.apata on 1/29/2017.
 */


public class Contributor implements Serializable{
    @Id
    private String id;
    private String email;
    private String password;
    private String passwordModifiedDatetime;
    private String firstName;
    private String lastName;
    private String gender;
    private String birthday;
    private String phoneNumber;
    private String state;
    private String city;
    private String regDatetime;
    private String regIp;
    private String lastModifiedDatetime;
    private String lastModifiedIp;
    private String bankName;
    private String bankAccountName;
    private String bankAccountNumber;
    private String bankAccountType;
    @Column(unique=true)
    private String username;
    private String phoneVerificationCode;
    private String notificationMode;
    private BigInteger balance;

    public Contributor() {
        UUID uuid = UUID.randomUUID();
        id=uuid.toString();
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordModifiedDatetime='" + passwordModifiedDatetime + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", regDatetime='" + regDatetime + '\'' +
                ", regIp='" + regIp + '\'' +
                ", lastModifiedDatetime='" + lastModifiedDatetime + '\'' +
                ", lastModifiedIp='" + lastModifiedIp + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountName='" + bankAccountName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", bankAccountType='" + bankAccountType + '\'' +
                ", username='" + username + '\'' +
                ", phoneVerificationCode='" + phoneVerificationCode + '\'' +
                ", notificationMode='" + notificationMode + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    private Contributor(Builder builder) {
        setId(builder.id);
        setEmail(builder.email);
        setPassword(builder.password);
        setPasswordModifiedDatetime(builder.passwordModifiedDatetime);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setGender(builder.gender);
        setBirthday(builder.birthday);
        setPhoneNumber(builder.phoneNumber);
        setState(builder.state);
        setCity(builder.city);
        setRegDatetime(builder.regDatetime);
        setRegIp(builder.regIp);
        setLastModifiedDatetime(builder.lastModifiedDatetime);
        setLastModifiedIp(builder.lastModifiedIp);
        setBankName(builder.bankName);
        setBankAccountName(builder.bankAccountName);
        setBankAccountNumber(builder.bankAccountNumber);
        setBankAccountType(builder.bankAccountType);
        setUsername(builder.username);
        setPhoneVerificationCode(builder.phoneVerificationCode);
        setNotificationMode(builder.notificationMode);
        setBalance(builder.balance);
    }

    public String getNotificationMode() {
        return notificationMode;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    public void setNotificationMode(String notificationMode) {
        this.notificationMode = notificationMode;
    }



    public String getPhoneVerificationCode() {
        return phoneVerificationCode;
    }

    public void setPhoneVerificationCode(String phoneVerificationCode) {
        this.phoneVerificationCode = phoneVerificationCode;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPasswordModifiedDatetime() {
        return passwordModifiedDatetime;
    }

    public void setPasswordModifiedDatetime(String passwordModifiedDatetime) {
        this.passwordModifiedDatetime = passwordModifiedDatetime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(String regDatetime) {
        this.regDatetime = regDatetime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public String getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(String lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public String getLastModifiedIp() {
        return lastModifiedIp;
    }

    public void setLastModifiedIp(String lastModifiedIp) {
        this.lastModifiedIp = lastModifiedIp;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public static final class Builder {
        @Id
        private String id;
        private String email;
        private String password;
        private String passwordModifiedDatetime;
        private String firstName;
        private String lastName;
        private String gender;
        private String birthday;
        private String phoneNumber;
        private String state;
        private String city;
        private String regDatetime;
        private String regIp;
        private String lastModifiedDatetime;
        private String lastModifiedIp;
        private String bankName;
        private String bankAccountName;
        private String bankAccountNumber;
        private String bankAccountType;
        @Column(unique=true)
        private String username;
        private String phoneVerificationCode;
        private String notificationMode;
        private BigInteger balance;
        public Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }



        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder passwordModifiedDatetime(String passwordModifiedDatetime) {
            this.passwordModifiedDatetime = passwordModifiedDatetime;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder regDatetime(String regDatetime) {
            this.regDatetime = regDatetime;
            return this;
        }

        public Builder regIp(String regIp) {
            this.regIp = regIp;
            return this;
        }

        public Builder lastModifiedDatetime(String lastModifiedDatetime) {
            this.lastModifiedDatetime = lastModifiedDatetime;
            return this;
        }

        public Builder lastModifiedIp(String lastModifiedIp) {
            this.lastModifiedIp = lastModifiedIp;
            return this;
        }


        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder bankAccountName(String bankAccountName) {
            this.bankAccountName = bankAccountName;
            return this;
        }

        public Builder bankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
            return this;
        }

        public Builder bankAccountType(String bankAccountType) {
            this.bankAccountType = bankAccountType;
            return this;
        }


        public Builder username(String username) {
            this.username = username;
            return this;
        }


        public Builder phoneVerificationCode(String phoneVerificationCode) {
            this.phoneVerificationCode = phoneVerificationCode;
            return this;
        }

        public Builder notificationMode(String notificationMode) {
            this.notificationMode=notificationMode;
            return this;
        }
        public Builder balance(BigInteger balance) {
            this.balance=balance;
            return this;
        }
        public Contributor build() {
            return new Contributor(this);
        }
    }
}
