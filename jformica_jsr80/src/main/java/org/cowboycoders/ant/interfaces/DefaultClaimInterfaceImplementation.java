package org.cowboycoders.ant.interfaces;

import java.util.concurrent.locks.ReentrantLock;

import javax.usb.UsbClaimException;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbException;
import javax.usb.UsbInterface;
import javax.usb.UsbNotActiveException;

public class DefaultClaimInterfaceImplementation 
implements ClaimInterfaceStrategy {
	
	private ReentrantLock interfaceLock = new ReentrantLock();

	@Override
	public void claimInterface(UsbInterface _interface, boolean claim) {
		try {
			interfaceLock.lock();
			if (claim) {
				_interface.claim();
			} else {
				if (_interface.isClaimed()) {
					_interface.release();
				}
			}
		} catch (UsbClaimException e) {
			e.printStackTrace();
			throw new AntCommunicationException(e);
		} catch (UsbNotActiveException e) {
			throw new AntCommunicationException(e);
		} catch (UsbDisconnectedException e) {
			throw new AntCommunicationException(e);
		} catch (UsbException e) {
			throw new AntCommunicationException(e);
		} finally {
			interfaceLock.unlock();
		}

	}

}
