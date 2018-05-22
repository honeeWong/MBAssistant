package com.model;

import java.util.List;

/**
 * Created by wanghy on 2018/5/19.
 */

public class RoleCreateText {

    private String title;
    private String[] listText;


    public RoleCreateText(String title, String[] listText){
        super();
        this.title = title;
        this.listText = listText;
    }

    public String getTitle() {

        return this.title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String[] getListText(){

        return this.listText;
    }

    public void setListText(String[] listText){

         this.listText = listText;
    }

}
