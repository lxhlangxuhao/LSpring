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
		ByteBuffer byteBuffer = null;
		try {
			byteBuffer = ByteBuffer.allocate(this.subBuffer);
			fileChannel.position(startIndex);
			int byteBufferLength = 0;
			byte[] temp = null;
			while ((byteBufferLength = this.fileChannel.read(byteBuffer)) != -1) {
				byte[] array;
				if (temp != null) {
					array = byteBuffer.array();
					byte[] temp2 = new byte[temp.length+array.length];
					System.arraycopy(temp, 0, temp2, 0, temp.length);
					System.arraycopy(array, 0, temp2, temp.length, array.length);
					array = temp2;
				} else {
					array = byteBuffer.array();
				}

				for (int i = 0; i < array.length; i++) {
					char ca = (char) array[i];
					System.out.println(ca);
					if (ca == '\r' || ca == '\n') {
						int overSize = array.length - i - 2;

						temp = new byte[overSize];
						System.arraycopy(array, i + 2, temp, 0, overSize);
						byteBuffer.clear();
						break;
					}
				}
			}


		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fileChannel != null) {
				try {
					fileChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
