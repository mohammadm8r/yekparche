package biz.vrls.listing ;

/**************************************************
*
* Specifies interface for <code>Listing</code>s
* that represent real estate property listings.
*
***************************************************/

import java.util.*;
import biz.vrls.common.* ;

public interface Listing extends Identifiable, Describable, Logged {

    /***************************************************
    *
    * Returns the title of this <code>Listing</code>.
    *
    * @return  The title of this <code>Listing</code>
    *
    ***************************************************/
    public String getTitle() ;
    
    /***************************************************
    *
    * Sets the title of this <code>Listing</code>.
    *
    * @param  title  The title of this <code>Listing</code>
    *
    ***************************************************/
    public void setTitle(String title) ;
    
    /***************************************************
    *
    * Returns the type of this <code>Listing</code>.
    *
    * @return  The type of this <code>Listing</code>
    *
    ***************************************************/
    public int getType() ;
    
    /***************************************************
    *
    * Sets the type of this <code>Listing</code>.
    *
    * @param  type  The type of this <code>Listing</code>
    *
    ***************************************************/
    public void setType(int type) ;
    
    /***************************************************
    *
    * Returns the type of this <code>Listing</code>
    * as a <code>String</code>.
    *
    * @return  The type of this <code>Listing</code>
    *          as a <code>String</code>
    *
    ***************************************************/
    public String getTypeAsString() ;
    
    /***************************************************
    *
    * Returns the type of offer associated with
    * this <code>Listing</code>.
    *
    * @return  The type of offer associated with
    *          this <code>Listing</code>
    *
    ***************************************************/
    public int getOfferType() ;
    
    /***************************************************
    *
    * Sets the type of offer associated with
    * this <code>Listing</code>.
    *
    * @param offerType  The type of offer associated with
    *                     this <code>Listing</code>
    *
    ***************************************************/
    public void setOfferType(int offerType) ;

    /***************************************************
    *
    * Returns the type of offer associated with
    * this <code>Listing</code> as a <code>String</code>.
    *
    * @return  The type of offer associated with
    *          this <code>Listing</code> as a <code>String</code>
    *
    ***************************************************/
    public String getOfferTypeAsString() ;
    
    /***************************************************
    *
    * Returns the number of bedrooms for this <code>Listing</code>.
    *
    * @return  The number of bedrooms for this <code>Listing</code>
    *
    ***************************************************/
    public float getNumBedrooms() ;
    
    /***************************************************
    *
    * Sets the number of bedrooms for this <code>Listing</code>.
    *
    * @param  numBedrooms  The number of bedrooms for
    *                        this <code>Listing</code>
    *
    ***************************************************/
    public void setNumBedrooms(float numBedrooms) ;
    
    /***************************************************
    *
    * Returns the number of bathrooms for this <code>Listing</code>.
    *
    * @return  The number of bathrooms for this <code>Listing</code>
    *
    ***************************************************/
    public float getNumBathrooms() ;
    
    /***************************************************
    *
    * Sets the number of bathrooms for this <code>Listing</code>.
    *
    * @param  numBathrooms  The number of bathrooms for
    *                         this <code>Listing</code>
    *
    ***************************************************/
    public void setNumBathrooms(float numBathrooms) ;
    
    /***************************************************
    *
    * Returns the purchase price for this <code>Listing</code>.
    *
    * @return  The purchase price for this <code>Listing</code>
    *
    ***************************************************/
    public float getPurchasePrice() ;
    
    /***************************************************
    *
    * Sets the purchase price for this <code>Listing</code>.
    *
    * @param  purchasePrice  The purchase price for
    *                          this <code>Listing</code>
    *
    ***************************************************/
    public void setPurchasePrice(float purchasePrice) ;

    /***************************************************
    *
    * Returns the monthly payment (rent) for this <code>Listing</code>.
    *
    * @return  The monthly payment (rent) for this <code>Listing</code>
    *
    ***************************************************/
    public float getMonthlyPayment() ;
    
    /***************************************************
    *
    * Sets the monthly payment (rent) for this <code>Listing</code>.
    *
    * @param  monthlyPayment  The monthly payment (rent)
    *                           for this <code>Listing</code>
    *
    ***************************************************/
    public void setMonthlyPayment(float monthlyPayment) ;
    
    /***************************************************
    *
    * Returns the region for this <code>Listing</code>.
    *
    * @return  The region for this <code>Listing</code>
    *
    ***************************************************/
    public String getRegion() ;
    
    /***************************************************
    *
    * Sets the region for this <code>Listing</code>.
    *
    * @param  region  The region for this <code>Listing</code>
    *
    ***************************************************/
    public void setRegion(String region) ;
    
    /***************************************************
    *
    * Returns the status for this <code>Listing</code>.
    * (e.g., active, in process, closed)
    *
    * @return  The status for this <code>Listing</code>
    *
    ***************************************************/
    public int getStatus() ;
    
    /***************************************************
    *
    * Sets the status for this <code>Listing</code>.
    * (e.g., active, in process, closed)
    *
    * @param  status  The status for this <code>Listing</code>
    *
    ***************************************************/
    public void setStatus(int status) ;
    
    /***************************************************
    *
    * Returns the status for this <code>Listing</code> as a <code>String</code>.
    * (e.g., "Active", "In Process", "Closed")
    *
    * @return  The purchase price for this <code>Listing</code>
    *
    ***************************************************/
    public String getStatusAsString() ;
    
    /***************************************************
    *
    * Returns the date that the status for this <code>Listing</code>
    * was last changed.
    *
    * @return  The date that the status for this <code>Listing</code>
    *          was last changed
    *
    ***************************************************/
    public java.util.Date getDateStatusChanged() ;
    
    /***************************************************
    *
    * Returns the date that the information for this <code>Listing</code>
    * was entered.
    *
    * @return  The date that the information for this <code>Listing</code>
    *          was entered
    *
    ***************************************************/
    public java.util.Date getDateEntered() ;
    
    /***************************************************
    *
    * Returns the date that the information for this <code>Listing</code>
    * was entered.
    *
    * @return  The date that the information for this <code>Listing</code>
    *          was entered
    *
    ***************************************************/
    public void setDateEntered(java.util.Date dateEntered) ;
    
    /***************************************************
    *
    * Returns the date that any information for this <code>Listing</code>
    * was last changed.
    *
    * @return  The date that any information for this <code>Listing</code>
    *          was last changed
    *
    ***************************************************/
    public java.util.Date getDateLastModified() ;
    
    /***************************************************
    *
    * Returns the date that any information for this <code>Listing</code>
    * was last changed.
    *
    * @return  The date that any information for this <code>Listing</code>
    *          was last changed
    *
    ***************************************************/
    public void setDateLastModified(java.util.Date dateLastModified) ;
    
    /***************************************************
    *
    * Returns the ID for the <code>Partner</code>
    * associated with this <code>Listing</code>.
    *
    * @return  The ID for the <code>Partner</code>
    *          associated with this <code>Listing</code>
    *
    ***************************************************/
    public int getReferringPartnerId() ;
    
    /***************************************************
    *
    * Returns the file name for this <code>Listing</code>'s
    * thumbnail image.
    *
    * @return  The file name for this <code>Listing</code>'s
    *          thumbnail image.
    *
    ***************************************************/
    public String getThumbnailImageUrl() ;
    
    /***************************************************
    *
    * 
    *
    * @param  
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setThumbnailImageUrl(String thumbnailImageUrl) ;
    
    /***************************************************
    *
    * Returns the file name for this <code>Listing</code>'s
    * main image.
    *
    * @return  The file name for this <code>Listing</code>'s
    *          main image.
    *
    ***************************************************/
    public String getMainImageUrl() ;

    /***************************************************
    *
    * 
    *
    * @param  
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setMainImageUrl(String thumbnailImageUrl) ;
    
    /***************************************************
    *
    * Returns the <code>List</code> of file name for
    * this <code>Listing</code>'s images.
    *
    * @return  The <code>List</code> of file names for
    *          this <code>Listing</code>'s images.
    *
    ***************************************************/
    public List<String> getImageUrls() ;
    
    /***************************************************
    *
    * Adds an image URL to the <code>List</code> of image URLs
    *
    * @param imageUrl the URL of the image to be added 
    *
    ***************************************************/
    public void addImageUrl(String imageUrl) ;
    
}
