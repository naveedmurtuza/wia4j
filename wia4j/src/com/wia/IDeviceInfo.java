package com.wia  ;

import com4j.*;

@IID("{2A99020A-E325-4454-95E0-136726ED4818}")
public interface IDeviceInfo extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Returns the DeviceID for this Device
   * </p>
   * <p>
   * Getter method for the COM property "DeviceID"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  java.lang.String deviceID();


  /**
   * <p>
   * Returns the Type of Device
   * </p>
   * <p>
   * Getter method for the COM property "Type"
   * </p>
   * @return  Returns a value of type com.wia.WiaDeviceType
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
  com.wia.WiaDeviceType type();


  /**
   * <p>
   * A collection of all properties for this imaging device that are applicable when the device is not connected
   * </p>
   * <p>
   * Getter method for the COM property "Properties"
   * </p>
   * @return  Returns a value of type com.wia.IProperties
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  com.wia.IProperties properties();


  @VTID(9)
  @ReturnValue(defaultPropertyThrough={com.wia.IProperties.class})
  com.wia.IProperty properties(
    java.lang.Object index);

  /**
   * <p>
   * Establish a connection with this device and return a Device object
   * </p>
   * @return  Returns a value of type com.wia.IDevice
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  com.wia.IDevice connect();


  // Properties:
}
