package com.hao.xu.lang.nio.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:38 2019/6/27
 */
public class MultiThreadReaderV2 implements Runnable {

	private FileChannel fileChannel;
	private long filePosition;  //起始位子
	private long readSubSize;  //读取长度
	private int bufferSize; //缓冲流大小

	public MultiThreadReaderV2(FileChannel fileChannel, long filePosition, long readSubSize, int bufferSize) {
		this.fileChannel = fileChannel;
		this.filePosition = filePosition;
		this.readSubSize = readSubSize;
		this.bufferSize = bufferSize;
	}

	@Override
	public void run() {

		ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
		int startWith = 0; // 完整行的起始坐标
		boolean isNotCompleteLine = true; // 是否存在不完整行
		int lenth = 0;
			try {
				while ((lenth = fileChannel.read(byteBuffer)) != -1) {
					startWith = 0;
					byte[] bufferArry = byteBuffer.array();
					for (int i = 0; i < lenth; i++) {
						isNotCompleteLine = true;
						byte el = bufferArry[i];
						if (el == 13) {  // 有完整行数据
							isNotCompleteLine = false;
							byte[] temp = new byte[i - startWith];
							System.arraycopy(bufferArry, startWith, temp, 0, temp.length);
							String lineStr = new String(temp, 0, temp.length, StandardCharsets.UTF_8);
							// 数据处理转换
							System.out.println(lineStr);
							if (i + 1 != bufferArry.length) {//最后一个字符是'13'
								startWith = i + 2;
							}
						}
					}
					if (isNotCompleteLine) {
						fileChannel.position(filePosition += startWith);
					}
					byteBuffer.clear();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}







}
