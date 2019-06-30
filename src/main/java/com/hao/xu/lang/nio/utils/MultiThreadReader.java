package com.hao.xu.lang.nio.utils;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:38 2019/6/27
 */
public class MultiThreadReader implements Runnable {

	private FileChannel fileChannel;
	private long posotionStartIndex;  //起始位子
	private long subSize;  //读取长度
	private int subBuffer; //缓冲流大小

	public MultiThreadReader(FileChannel fileChannel, long posotionStartIndex, long subSize, int subBuffer) {
		this.fileChannel = fileChannel;
		this.posotionStartIndex = posotionStartIndex;
		this.subSize = subSize;
		this.subBuffer = subBuffer;
	}

	@Override
	public void run() {
		ByteBuffer byteBuffer;  //缓存数组
		int position; // 缓存数组当前位子
		byte[] temp = null;  //临时存放未满足一整条的数据
		boolean isRowData = false;  //是否为完整的一条数据
		boolean isLastRow = true;  //是否为最后一条没换行符的数据
		byte[] bufByteArr; // temp + byteBuffer的实际存放数据

		try {
			byteBuffer = ByteBuffer.allocate(this.subBuffer);
			fileChannel.position(posotionStartIndex);
			while ((position = this.fileChannel.read(byteBuffer)) != -1) {
				isLastRow = true;
				int startIdx = 0;
				bufByteArr = new byte[position];
				System.arraycopy(byteBuffer.array(),0,bufByteArr,0,position);
				if (temp != null) {
					byte[] temp2 = new byte[temp.length + bufByteArr.length];
					System.arraycopy(temp, 0, temp2, 0, temp.length);
					System.arraycopy(bufByteArr, 0, temp2, temp.length, bufByteArr.length);
					bufByteArr = temp2;
				}
				for (int i = 0; i < bufByteArr.length; i++) {
					isRowData = false;
					if (i == 0 && bufByteArr[i] == 10) {
						startIdx++;
						continue;
					}
					if (bufByteArr[i] == 13) {
						isRowData = true;
						isLastRow = false;
						//读取一行完整数据
						byte[] rowByte = new byte[i - startIdx];
						System.arraycopy(bufByteArr, startIdx, rowByte, 0, rowByte.length);
						System.out.println(new String(rowByte, StandardCharsets.UTF_8));
						if (i == bufByteArr.length - 1 || i + 1 == bufByteArr.length) {//缓冲数组的最后两位位是/n或/r
							continue;
						} else {
							startIdx = i + 2;
						}
					}
				}
				if (!isRowData) {
					isLastRow = true;
					temp = new byte[bufByteArr.length - startIdx];
					System.arraycopy(bufByteArr, startIdx, temp, 0, temp.length);
				}
				byteBuffer.clear();
			}
			//处理最后一行数据可能没有换行符
			if (isLastRow && Objects.nonNull(temp) && temp.length > 0) {
				System.out.println(new String(temp, StandardCharsets.UTF_8));
			}
			System.out.println();

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
