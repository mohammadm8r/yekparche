package biz.vrls.struts.form;

import java.util.* ;
import org.apache.struts.util.* ;

/**************************************************
*
* This utility class extends the Struts utility class
* <code>LabelValueBean</code> to provide more robust
* functionality for building options collections.
*
***************************************************/
public final class OptionsCollectionElement extends LabelValueBean {

	private static final long serialVersionUID = -8973855960988660626L;

	/**************************************************
    *
    * Static <code>Comparator</code> constant for having 
    * <code>OptionsCollectionElement</code>s presented in value order.
    * Use this constant as the <code>Comparator</code>
    * argument for constructing a <code>SortedSet</code>
    * intended for use as an options collection.
    *
    ***************************************************/
    public static final Comparator<OptionsCollectionElement> SORT_BY_VALUE =
        new OptionsCollectionElementComparatorByValue() ;

    /**************************************************
    *
    * Static <code>Comparator</code> constant for having 
    * <code>OptionsCollectionElement</code>s presented in label order.
    * Use this constant as the <code>Comparator</code>
    * argument for constructing a <code>SortedSet</code>
    * intended for use as an options collection.
    *
    ***************************************************/
    public static final Comparator<OptionsCollectionElement> SORT_BY_LABEL =
        new OptionsCollectionElementComparatorByLabel() ;
    
    /**************************************************
    *
    * Basic constructor. Note that, unlike <code>LabelValueBean</code>,
    * the value argument comes first in this constructor,
    * since the value is the distinguishing identifier for
    * an <code>OptionsCollectionElement</code>.
    *
    ***************************************************/
    public OptionsCollectionElement(String p_value, String p_label) {
        super(p_label, p_value) ;
    }
    
    /**************************************************
    *
    * Basic constructor that sets the value and label to
    * the same value.
    *
    ***************************************************/
    public OptionsCollectionElement(String p_value) {
        super(p_value, p_value) ;
    }

    /**************************************************
    *
    * Inner class for <code>Comparator</code> that sorts
    * <code>OptionsCollectionElement</code>s in value order.
    *
    ***************************************************/
    static class OptionsCollectionElementComparatorByValue implements Comparator<OptionsCollectionElement> {
        
        public int compare(OptionsCollectionElement oce1, OptionsCollectionElement oce2) {
            return oce1.getValue().compareTo(oce2.getValue()) ;
        }
    }
        
    /**************************************************
    *
    * Inner class for <code>Comparator</code> that sorts
    * <code>OptionsCollectionElement</code>s in label order.
    *
    ***************************************************/
    static class OptionsCollectionElementComparatorByLabel implements Comparator<OptionsCollectionElement> {
        
        public int compare(OptionsCollectionElement oce1, OptionsCollectionElement oce2) {
            return oce1.getLabel().compareTo(oce2.getLabel()) ;
        }
    }
    
}
