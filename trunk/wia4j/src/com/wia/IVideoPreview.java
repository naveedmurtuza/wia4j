package com.wia  ;

import com4j.*;

@IID("{4DDC737E-B426-4FB7-AD48-7448F53E5CB6}")
public interface IVideoPreview extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Returns/Sets the Device to preview
   * </p>
   * <p>
   * Getter method for the COM property "Device"
   * </p>
   * @return  Returns a value of type com.wia.IDevice
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  com.wia.IDevice device();


  /**
   * <p>
   * Returns/Sets the Device to preview
   * </p>
   * <p>
   * Setter method for the COM property "Device"
   * </p>
   * @param ppResult Mandatory com.wia.IDevice parameter.
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(8)
  void device(
    com.wia.IDevice ppResult);


  /**
   * <p>
   * Returns/Sets whether video playback is paused
   * </p>
   * <p>
   * Getter method for the COM property "Pause"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(10)
  boolean pause();


  /**
   * <p>
   * Returns/Sets whether video playback is paused
   * </p>
   * <p>
   * Setter method for the COM property "Pause"
   * </p>
   * @param pResult Mandatory boolean parameter.
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(11)
  void pause(
    boolean pResult);


  // Properties:
}
