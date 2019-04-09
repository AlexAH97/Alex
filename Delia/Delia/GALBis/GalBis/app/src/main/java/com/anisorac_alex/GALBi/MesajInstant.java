package com.anisorac_alex.GALBi;

/**
 * Created by Napoca_MoveUp on 8/18/2017.
 */

public class MesajInstant
{
    private String autor;
    private String text;


    public MesajInstant(String autor,String text)
    {
        this.autor=autor;
        this.text=text;
    }

    public MesajInstant()
    {

    }

    public String getAutor()
    {
        return autor;
    }

    public String getText()
    {
        return text;
    }
}
