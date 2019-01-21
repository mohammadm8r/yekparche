package biz.vrls.common ;

/**************************************************
*
* Specifies interface for "describable" classes
* (i.e., classes with an "description" attribute)
*
***************************************************/
public interface Describable {

    /***************************************************
    *
    * Gets the object's description.
    *
    * @return  The object's description
    *
    ***************************************************/
    public String getDescription() ;
    
    /***************************************************
    *
    * Sets the object's description.
    *
    * @param  id  The object's description
    *
    ***************************************************/
    public void setDescription(String description) ;
    
}
