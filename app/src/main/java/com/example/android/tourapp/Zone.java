package com.example.android.tourapp;

public class Zone {

    private int aPlaceName;
    private int aPlaceDescription;
    private int aPlaceAddress;

    // Drawable resource ID
    private int aImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     *  @param placeName is the place name
     * @param placeDescription is the description of the touristic place
     * @param placeAddress is the address of the touristic place
     *@param imageResourceId is the image to be included
     */

    public Zone(int placeName, int placeDescription, int placeAddress, int imageResourceId) {
        aPlaceName = placeName;
        aPlaceDescription = placeDescription;
        aPlaceAddress = placeAddress;
        aImageResourceId = imageResourceId;
    }

    /**
     * Get the Place Name
     */

    public int getPlaceName() {
        return aPlaceName;
    }

    /**
     * Get the Place Description
     */

    public int getPlaceDescription() {
        return aPlaceDescription;
    }

    /**
     * Get the Place Address
     */

    public int getPlaceAddress() {
        return aPlaceAddress;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return aImageResourceId;
    }

    /**
     * Defines if it has or not an ImageView
     */
    public boolean hasImage(){
        return aImageResourceId != NO_IMAGE_PROVIDED;
    }

}
