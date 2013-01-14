package com.wia.events;

import com4j.*;

@IID("{2E9A5206-2360-49DF-9D9B-1762B4BEAE77}")
public abstract class _IDeviceManagerEvents {
  // Methods:
  /**
   * <p>
   * Occurs for any event registered with RegisterEvent
   * </p>
   * @param eventID Mandatory java.lang.String parameter.
   * @param deviceID Mandatory java.lang.String parameter.
   * @param itemID Mandatory java.lang.String parameter.
   */

  @DISPID(1)
  public void onEvent(
    java.lang.String eventID,
    java.lang.String deviceID,
    java.lang.String itemID) {
        throw new UnsupportedOperationException();
  }


  // Properties:
}
