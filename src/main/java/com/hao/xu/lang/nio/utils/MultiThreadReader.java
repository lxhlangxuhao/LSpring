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
			int byteBufferLenth = 0;
			while ((byteBufferLenth = this.fileChannel.read(byteBuffer)) != -1) {

			}


		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
