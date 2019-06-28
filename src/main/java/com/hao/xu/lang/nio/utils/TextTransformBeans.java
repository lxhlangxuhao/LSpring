package com.hao.xu.lang.nio.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 22:21 2019/6/27
 */
public class TextTransformBeans {

	//读取文件File
	private File inputFile;
	//线程池
	private ExecutorService executorService;
	//线程数
	private int executorThreadCount;
	//缓冲区大小
	private int subBuffer;

	public TextTransformBeans(File inputFile, int executorThreadCount, int subBuffer) {
		this.inputFile = inputFile;
		this.executorThreadCount = executorThreadCount;
		this.executorService = Executors.newFixedThreadPool(executorThreadCount);
		this.subBuffer = subBuffer;
	}

	public void inputTextTransformBeans() {
		RandomAccessFile file;
		FileChannel channel;
		try {
			long sumSize = this.inputFile.length();//  文件总大小
			long subSize = sumSize / executorThreadCount;//  每个线程需要读取的文件大小  sumSize/executorThreadCount
			//1.循环调用线程
			for (int i = 0; i < executorThreadCount; i++) {
			//2.创建连接
				file = new RandomAccessFile(this.inputFile, "rw");
				channel = file.getChannel();
				executorService.execute(new MultiThreadReader(channel, i * subSize, subSize, subBuffer));
			}


		} catch (IOException e) {
			e.printStackTrace();
		}






	}















	public static void main(String[] args) {

		TextTransformBeans textTransformBeans = new TextTransformBeans(new File("E:\\test8.txt"), 1, 50);
		textTransformBeans.inputTextTransformBeans();

	}

}
