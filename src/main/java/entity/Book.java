package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author madsr
 */

@Entity(name = "BOOK")
public class Book implements Serializable {
    
    @Id
    int id;
    
    String title; 
    String info; 
    String moreInfo; 

    public Book()
    {
    }
    
    public Book(int id, String t, String i, String mi) {
        this.id = id; 
        title = t; 
        info = i; 
        moreInfo = mi; 
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getMoreInfo()
    {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo)
    {
        this.moreInfo = moreInfo;
    }
    
    
}
