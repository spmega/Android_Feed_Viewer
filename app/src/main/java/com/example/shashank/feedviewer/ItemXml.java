package com.example.shashank.feedviewer;

/**
 * Created by shashank on 4/6/16.
 */
public class ItemXml {
    private String name = null;
    private String link = null;
    private String description = null;

    public ItemXml(){

    }

    public ItemXml(String name, String link, String description)
    {
        this.name = name;
        this.link = link;
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
