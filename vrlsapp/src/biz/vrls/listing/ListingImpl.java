package biz.vrls.listing ;

import biz.vrls.common.* ;
import java.util.* ;

/**************************************************
*
* Specifies interface for <code>Listing</code>s
* that represent real estate property listings.
*
***************************************************/
public class ListingImpl implements Listing {
    
    /*************************************************************
    *
    * Listing identifier
    *
    *************************************************************/
    private int id ;
    
    /*************************************************************
    *
    * Listing description
    *
    *************************************************************/
    private String description ;

    /*************************************************************
    *
    * Listing title
    *
    *************************************************************/
    private String title ;
    
    /*************************************************************
    *
    * Listing type
    *
    *************************************************************/
    private int type ;
    
    /*************************************************************
    *
    * Offer type 
    *
    *************************************************************/
    private int offerType ;
    
    /*************************************************************
    *
    * Number of bedrooms 
    *
    *************************************************************/
    private float numBedrooms ;
    
    /*************************************************************
    *
    * Number of bathrooms
    *
    *************************************************************/
    private float numBathrooms ;
    
    /*************************************************************
    *
    * Purchase Price (for purchase)
    *
    *************************************************************/
    private float purchasePrice ;
    
    /*************************************************************
    *
    * Monthly payment (for rental)
    *
    *************************************************************/
    private float monthlyPayment ;
    
    /*************************************************************
    *
    * Region
    *
    *************************************************************/
    private String region ;
    
    /*************************************************************
    *
    * Listing Status
    *
    *************************************************************/
    private int status ;
    
    /*************************************************************
    *
    * ID of referring partner
    *
    *************************************************************/
    private int referringPartnerId ;
    
    /*************************************************************
    *
    * Date that status last changed
    *
    *************************************************************/
    private java.util.Date dateStatusChanged ;
    
    /*************************************************************
    *
    * Date listing was entered
    *
    *************************************************************/
    private java.util.Date dateEntered ;
    
    /*************************************************************
    *
    * Date listing was last modified
    *
    *************************************************************/
    private java.util.Date dateLastModified ;
    
    /*************************************************************
    *
    * URL of thumbnail image
    *
    *************************************************************/
    private String thumbnailImageUrl ;
    
    /*************************************************************
    *
    * URL of main image
    *
    *************************************************************/
    private String mainImageUrl ;

    /*************************************************************
    *
    * List of other image URLs
    *
    *************************************************************/
    private List<String> imageUrls = new ArrayList<String>() ;

    /***************************************************
    *
    * Basic constructor.
    *
    * @param  referringPartnerId  Id of partner associated with this <code>Listing</code>
    *
    ***************************************************/
    public ListingImpl(int referringPartnerId) {
        this.referringPartnerId = referringPartnerId ;
    }
    
    /***************************************************
    *
    * Returns the <code>Listing</code>'s id.
    *
    * @return  The <code>Listing</code>'s id
    *
    ***************************************************/
    public int getId() {
        return this.id ;
    }
    
    /***************************************************
    *
    * Sets the <code>Listing</code>'s id.
    *
    * @param  id  The <code>Listing</code>'s id
    *
    ***************************************************/
    public void setId(int id) {
        this.id = id ;
    }
    
    /***************************************************
    *
    * Returns the <code>Listing</code>'s description.
    *
    * @return  The <code>Listing</code>'s description
    *
    ***************************************************/
    public String getDescription() {
        return this.description ;
    }
    
    /***************************************************
    *
    * Sets the <code>Listing</code>'s description.
    *
    * @param  id  The <code>Listing</code>'s description
    *
    ***************************************************/
    public void setDescription(String description) {
        this.description = description ;
    }
    
    /***************************************************
    *
    * Gets the title associated with the listing.
    *
    * @return  the listing's title
    *
    ***************************************************/
    public String getTitle() {
        return this.title ;
    }
    
    /***************************************************
    *
    * Sets the title associated with this listing
    *
    * @param  title  the listing title
    *
    ***************************************************/
    public void setTitle(String title) {
        this.title = title ;
    }
    
    /***************************************************
    *
    * Gets the listing type
    *
    * @return  the listing type
    *
    ***************************************************/
    public int getType() {
        return this.type ;
    }
    
    /***************************************************
    *
    * Sets the listing type
    *
    * @param  type  the listing title
    *
    ***************************************************/
    public void setType(int type) {
        this.type = type ;
    }
    
    /***************************************************
    *
    * Gets the listing type as a <tt>String</tt>
    *
    * @return  the listing type as a <tt>String</tt>
    *
    ***************************************************/
    public String getTypeAsString() {
        return Integer.toString(this.type) ;
    }
    
    /***************************************************
    *
    * Gets the offer type
    *
    * @return  the offer type
    *
    ***************************************************/
    public int getOfferType() {
        return this.offerType ;
    }
    
    /***************************************************
    *
    * Sets the offer type
    *
    * @param  offerType
    *
    ***************************************************/
    public void setOfferType(int offerType) {
        this.offerType = offerType ;
    }

    /***************************************************
    *
    * Gets offer type as a <tt>String</tt>
    *
    * @return  the offer type as a <tt>String</tt>
    *
    ***************************************************/
    public String getOfferTypeAsString() {
        return Integer.toString(this.offerType) ;
    }
    
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
    public float getNumBedrooms() {
        return this.numBedrooms ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  numBedrooms
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setNumBedrooms(float numBedrooms) {
        this.numBedrooms = numBedrooms ;
    }
    
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
    public float getNumBathrooms() {
        return this.numBathrooms ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  numBathrooms
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setNumBathrooms(float numBathrooms) {
        this.numBathrooms = numBathrooms ;
    }
    
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
    public float getPurchasePrice() {
        return this.purchasePrice ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  purchasePrice
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice ;
    }

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
    public float getMonthlyPayment() {
        return this.monthlyPayment ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  monthlyPayment
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment ;
    }
    
    /***************************************************
    *
    * Returns the region for this <code>Listing</code>.
    *
    * @return  The region for this <code>Listing</code>
    *
    ***************************************************/
    public String getRegion() {
        return this.region ;
    }
    
    /***************************************************
    *
    * Sets the region for this <code>Listing</code>.
    *
    * @param  region  The region for this <code>Listing</code>
    *
    ***************************************************/
    public void setRegion(String region) {
        this.region = region ;
    }
    
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
    public int getStatus() {
        return this.status ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  status
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setStatus(int status) {
        this.status = status ;
    }
    
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
    public String getStatusAsString() {
        return Integer.toString(this.status) ;
    }
    
    /***************************************************
    *
    * Returns the ID for the <code>Partner</code>
    * that created this <code>Listing</code>.
    *
    * @return  The ID for the <code>Partner</code>
    *          that created this <code>Listing</code>
    *
    ***************************************************/
    public int getReferringPartnerId() {
        return this.referringPartnerId ;
    }

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
    public java.util.Date getDateStatusChanged() {
        return this.dateStatusChanged ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  dateStatusChanged
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setDateStatusChanged(java.util.Date dateStatusChanged) {
        this.dateStatusChanged = dateStatusChanged ;
    }
    
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
    public java.util.Date getDateEntered() {
        return this.dateEntered ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  dateEntered
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setDateEntered(java.util.Date dateEntered) {
        this.dateEntered = dateEntered ;
    }

    /***************************************************
    *
    * 
    *
    * @param  dateEntered
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public java.util.Date getDateLastModified() {
        return this.dateLastModified ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  dateLastModified
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public void setDateLastModified(java.util.Date dateLastModified) {
        this.dateLastModified = dateLastModified ;
    }
    
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
    public String getThumbnailImageUrl() {
        return this.thumbnailImageUrl ;
    }
    
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
    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl ;
    }
    
    /***************************************************
    *
    * 
    *
    * @param  thumbnailImageUrl
    *
    * @param  
    *
    * @return  
    *
    * @throws  
    *
    ***************************************************/
    public String getMainImageUrl() {
        return this.mainImageUrl ;
    }

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
    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl ;
    }
    
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
    public List<String> getImageUrls() {
        return this.imageUrls ;
    }

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
    public void addImageUrl(String imageUrl) {
        if (imageUrl != null && ! this.imageUrls.contains(imageUrl)) {
            this.imageUrls.add(imageUrl) ;
        }
    }
    
}
