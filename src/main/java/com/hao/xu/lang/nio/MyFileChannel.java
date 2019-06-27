package com.hao.xu.lang.nio;

import com.google.gson.Gson;
import com.hao.xu.lang.AspectLang.Operator;
import com.hao.xu.lang.entity.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:23 2019/6/26
 */
public class MyFileChannel {

	private static final Logger logger = LoggerFactory.getLogger(MyFileChannel.class);

	public static void main(String[] args) {

//		test1();
		write();
	}

	private static void write() {
		String str = "{\"id\":1,\"name\": \"lang\", \"department\": \"IT\", \"score\": 99}"+"\r\n";

		FileChannel channel = null;
		RandomAccessFile randomAccessFile = null;
		try {
			File file = new File("E:\\test2.txt");
			long length = file.length();
			logger.info("文件总长度："+length);
			if (!file.exists()) {
				if (file.createNewFile()) {
					logger.info("创建文件成功");
				}
			}
			//
			randomAccessFile = new RandomAccessFile(file, "rw");
			//设置文件指针偏移,追加源文件内容
			randomAccessFile.seek(randomAccessFile.length());
//			FileOutputStream fileOutputStream = new FileOutputStream(file, true);
			//通道
			channel = randomAccessFile.getChannel();
			//缓存区
			ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
			//写入文件
			for (int i = 0; i < 20000000; i++) {
				channel.write(wrap);
				System.out.println(randomAccessFile.getFilePointer());
				wrap.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				assert channel != null;
				channel.close();
				randomAccessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	private static void test1() {

		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\test.txt", "rw");
			FileChannel channel = randomAccessFile.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(48);
			int offset = 0;
			while ((offset = channel.read(buffer)) != -1) {
				buffer.flip();
				while (buffer.hasRemaining()) {
					char ch = (char) buffer.get();
					System.out.print(ch);
				}
				buffer.clear();
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
