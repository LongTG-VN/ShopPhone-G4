/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class UserAddresses {
    private int addressID;
    private User user;
    private String recipientName;
    private String phone;
    private String addressLine;
    private byte is_default;

    public UserAddresses() {
    }

    public UserAddresses(int addressID, User user, String recipientName, String phone, String addressLine, byte is_default) {
        this.addressID = addressID;
        this.user = user;
        this.recipientName = recipientName;
        this.phone = phone;
        this.addressLine = addressLine;
        this.is_default = is_default;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public byte getIs_default() {
        return is_default;
    }

    public void setIs_default(byte is_default) {
        this.is_default = is_default;
    }

    @Override
    public String toString() {
        return "userAddresses{" + "addressID=" + addressID + ", user=" + user + ", recipientName=" + recipientName + ", phone=" + phone + ", addressLine=" + addressLine + ", is_default=" + is_default + '}';
    }
    
    
    
    
}
