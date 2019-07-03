package com.hao.xu.lang.nio;

import com.google.gson.Gson;
import com.hao.xu.lang.AspectLang.Operator;
import com.hao.xu.lang.core.utils.FileUtils;
import com.hao.xu.lang.entity.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.aspectj.util.FileUtil;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:23 2019/6/26
 */
public class MyFileChannel {

/*
	//获取文件通道位置
	fileChannelInput.position();
	fileChannelInput.size();
	//截取内容
	fileChannelInput.truncate(1024);
	//强制刷新数据到硬盘
	fileChannelInput.force(true);
*/

	public static void main(String[] args) throws Exception{

//		File file = new File("E:\\text8.txt");
//		System.out.println(file.length());


		test1();
//		write();
	}

	private static void write() {

		FileChannel channel = null;
		RandomAccessFile randomAccessFile = null;
		File file = null;
		try {
			file = new File("E:\\test3.txt");
//			if (FileUtils.createFile(file)) {
//				System.out.println("文件创建成功");
//			}
			//创建读写模式
			randomAccessFile = new RandomAccessFile(file, "rw");
			//追加内容
			randomAccessFile.seek(randomAccessFile.length());
			//通道
			channel = randomAccessFile.getChannel();
			//写入文件
			for (int i = 0; i < 10000000; i++) {
				String str = "{\"id\":1,\"name\": \"lang\", \"department\": \"IT\", \"score\": "+i+"}"+"\r\n";
				//写入缓冲区
				ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
				channel.write(wrap);
				wrap.clear();
				System.out.println("文件大小："+FileUtils.getFileSizeDescription(file.length()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (channel != null) {
					channel.close();
				}
				if (randomAccessFile != null) {
					randomAccessFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	private static void test1() {

		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\test3.txt", "rw");
			FileChannel channel = randomAccessFile.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(4);
			int read = channel.read(buffer);
			long position2 = channel.position();
//			buffer.flip();
			long position = channel.position();
			channel.position(2);
			long position3 = channel.position();
			buffer.clear();
			int read2 = channel.read(buffer);
			System.out.println();
//			int offset = 0;
//			while ((offset = channel.read(buffer)) != -1) {
//				int position = buffer.position();
//				buffer.flip();
//				//检查是否还有数据未写入
//				while (buffer.hasRemaining()) {
//					char ch = (char) buffer.get();
//					System.out.print(ch);
//				}
//				buffer.clear();
//			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}
