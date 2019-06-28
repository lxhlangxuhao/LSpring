package com.hao.xu.lang.nio.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:38 2019/6/27
 */
public class MultiThreadReader implements Runnable {

	private FileChannel fileChannel;
	private long startIndex;  //起始位子
	private long subSize;  //读取长度
	private int subBuffer; //缓冲流大小

	public MultiThreadReader(FileChannel fileChannel, long startIndex, long subSize, int subBuffer) {
		this.fileChannel = fileChannel;
		this.startIndex = startIndex;
		this.subSize = subSize;
		this.subBuffer = subBuffer;
	}

	@Override
	public void run() {
		try {
			ByteBuffer byteBuffer = ByteBuffer.allocate(this.subBuffer);
			fileChannel.position(startIndex);
			int byteBufferLength = 0;
			while ((byteBufferLength = this.fileChannel.read(byteBuffer)) != -1) {
//				byte[] tempByte = new byte[byteBufferLength];
//				byteBuffer.get(tempByte, 0, byteBufferLength);
				byte[] array = byteBuffer.array();
				for (int i = 0; i < array.length; i++) {
					char ca = (char) array[i];
					if (ca == '\r' || ca == '\n') {
						break;
					}
				}
//				for (byte b : byteBuffer) {
//					char ca = (char) b;
//					if (ca == '\r' || ca == '\n') {
//						break;
//					}
//				}
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
