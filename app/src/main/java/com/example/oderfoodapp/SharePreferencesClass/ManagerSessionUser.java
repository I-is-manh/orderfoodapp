package com.example.oderfoodapp.SharePreferencesClass;

import android.content.Context;
import android.content.SharedPreferences;

public class ManagerSessionUser {
    private static final String pref_name = "orderapp";
    private static final String email = "email";
    private static final String password = "isLoggedIn";
    private static  SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public ManagerSessionUser(Context mcontext){
        sharedPreferences = mcontext.getSharedPreferences(pref_name,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public boolean createLoginSession(String email,String password){
        editor.putString(email,email);
        editor.putString(password,password);
        return editor.commit();
    }
    public void removeLoginSession(){
        editor.clear();
        editor.commit();
    }
    public String getUserName(){
        return sharedPreferences.getString(email,"null");
    }
    public String getPassword(){
        return sharedPreferences.getString(password,"null");
    }
    public boolean checkLogin(){
        if(sharedPreferences.getString(email,"null") == "null" && sharedPreferences.getString(password,"null") == "null"){
            return false;
        }
        else{
            return true;
        }
    }
}
