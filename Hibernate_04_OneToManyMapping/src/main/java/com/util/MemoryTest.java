package com.util;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MemoryTest {

	public static void main(String[] args) {

		long heapSize = Runtime.getRuntime().totalMemory();
		log.info(heapSize);
		// Get maximum size of heap in bytes. The heap cannot grow beyond this size.//
		// Any attempt will result in an OutOfMemoryException.
		long heapMaxSize = Runtime.getRuntime().maxMemory();
		log.info(heapMaxSize);
		// Get amount of free memory within the heap in bytes. This size will increase
		// // after garbage collection and decrease as new objects are created.
		long heapFreeSize = Runtime.getRuntime().freeMemory();
		log.info(heapFreeSize);
	}
}
