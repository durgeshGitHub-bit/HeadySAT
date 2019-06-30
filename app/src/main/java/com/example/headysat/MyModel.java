package com.example.headysat;

public class MyModel
{
    private String section,title,strAbstract,byline,urlLink,publishDate,image;

    public MyModel() {
    }

    public MyModel(String section, String title, String strAbstract, String byline, String urlLink, String publishDate, String image)
    {
        this.section = section;
        this.title = title;
        this.strAbstract = strAbstract;
        this.byline = byline;
        this.urlLink = urlLink;
        this.publishDate = publishDate;
        this.image = image;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getStrAbstract()
    {
        return strAbstract;
    }

    public void setStrAbstract(String strAbstract)
    {
        this.strAbstract = strAbstract;
    }

    public String getByline()
    {
        return byline;
    }

    public void setByline(String byline)
    {
        this.byline = byline;
    }

    public String getUrlLink()
    {
        return urlLink;
    }

    public void setUrlLink(String urlLink)
    {
        this.urlLink = urlLink;
    }

    public String getPublishDate()
    {
        return publishDate;
    }

    public void setPublishDate(String publishDate)
    {
        this.publishDate = publishDate;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
}
