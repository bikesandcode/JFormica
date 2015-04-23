package org.cowboycoders.ant.interfaces;

import javax.usb.UsbInterface;

public interface ClaimInterfaceStrategy {
	/**
	 * Claim the interface. Allow for alternate implementations. (Different platforms, etc)
	 * 
	 * @param _interface the interface to claim
	 * @param claim true to claim, false to release
	 */
	void claimInterface(UsbInterface _interface, boolean claim);
}
