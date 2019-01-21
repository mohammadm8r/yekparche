package biz.vrls.util ;

import java.net.* ;
import java.util.* ;
import java.text.* ;

import javax.mail.internet.* ;

import java.io.UnsupportedEncodingException;

/**************************************************
*
* Utility class with static methods for text processing.
*
***************************************************/
public class TextUtils {

    /*************************************************************
    *
    * Private constructor.
    *
    *************************************************************/
    private TextUtils() { }
    
    /***************************************************
    *
    * Convert a <code>Collection</code> to a <code>String</code> of tokenized elements.
    *
    * @param  collection  The original <code>Collection</code>
    *
    * @param  separator The separator <code>String</code>
    *
    * @return  A <code>String</code> containing of the <code>Collection</code>'s elements
    *
    ***************************************************/
    public static String collectionToString(Collection<?> collection, String separator) {
        Iterator<?> i = collection.iterator() ;
        boolean firstTime = true ;
        StringBuffer sb = new StringBuffer() ;
        while (i.hasNext()) {
            sb.append(firstTime ? "" : separator) ;
            firstTime = false ;
            sb.append(i.next().toString()) ;
        }
        return(sb.toString()) ;
    }

}