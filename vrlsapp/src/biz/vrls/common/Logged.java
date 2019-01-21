package biz.vrls.common ;

/**************************************************
*
* Specifies interface for "logged" classes
* (i.e., classes whose creation and modification dates are recorded)
*
***************************************************/
public interface Logged {

    /***************************************************
    *
    * Returns the date that the information for this object
    * was entered.
    *
    * @return  The date that the information for this object
    *          was entered
    *
    ***************************************************/
    public java.util.Date getDateEntered() ;
    
    /***************************************************
    *
    * Returns the date that any information for this object
    * was last changed.
    *
    * @return  The date that any information for this object
    *          was last changed
    *
    ***************************************************/
    public java.util.Date getDateLastModified() ;

}

