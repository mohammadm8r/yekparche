package biz.vrls.common ;

/**************************************************
*
* Specifies interface for "identifiable" classes
* (i.e., classes with an "id" attribute)
*
***************************************************/
public interface Identifiable {

    /***************************************************
    *
    * Gets the object's ID
    *
    * @return  The object's ID
    *
    ***************************************************/
    public int getId() ;
    
    /***************************************************
    *
    * Sets the object's ID
    *
    * @param  id  The object's ID
    *
    ***************************************************/
    public void setId(int id) ;
    
}

