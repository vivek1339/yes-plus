package com.club.yes_plus;

/**
 * Created by vivek on 16-01-2019.
 */

public class user_reg {


    String username;

    String userkey;
public user_reg(String username,String userkey)
{
    this.username=username;
    this.userkey=userkey;
}
public user_reg(){}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

}
