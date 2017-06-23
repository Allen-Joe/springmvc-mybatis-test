package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * @描述：Nio的FileChannel
 * @创建人：Chenliqiao
 * @创建时间：2017年6月21日下午12:18:32
 * @version v1.0
 */
public class FileChannelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		read("E:/niotest/nio-data.txt");
		transferFrom("E:/niotest/nio-data.txt", "E:/niotest/nio-data-transferfrom.txt");
		transferTo("E:/niotest/nio-data.txt", "E:/niotest/nio-data-transferto.txt");
	}
	
	/**
	 * 
	 * @描述:使用FileChannel读取数据到Buffer中
	 * @param file
	 * @throws IOException
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月21日下午3:14:32
	 */
	@SuppressWarnings("resource")
	private static void read(String file) throws IOException{
		
		RandomAccessFile aFile=new RandomAccessFile(file, "rw");
		FileChannel fileChannel=aFile.getChannel();
		
		ByteBuffer buffer=ByteBuffer.allocate(48);
		
		int bytesRead=fileChannel.read(buffer);
		while(bytesRead!=-1){
			System.out.println("read "+bytesRead);
			buffer.flip();
			
			while(buffer.hasRemaining()){
				System.out.print((char)buffer.get());
			}
			
			buffer.clear();
			bytesRead=fileChannel.read(buffer);
		}
		fileChannel.close();
		
	}
	
	/**
	 * 
	 * @描述:FileChannel的transferFrom()方法可以将数据从源通道传输到FileChannel中（译者注：这个方法在JDK文档中的解释为将字节从给定的可读取字节通道传输到此通道的文件中）
	 *      方法的输入参数position表示从position处开始向目标文件写入数据，count表示最多传输的字节数。如果源通道的剩余空间小于 count 个字节，则所传输的字节数要小于请求的字节数。
	 * @param from_File
	 * @param to_File
	 * @throws IOException
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月21日下午3:55:50
	 */
	@SuppressWarnings("resource")
	private static void transferFrom(String from_File,String to_File) throws IOException{
		
		RandomAccessFile fromFile=new RandomAccessFile(from_File, "rw");
		RandomAccessFile toFile=new RandomAccessFile(to_File, "rw");
		
		FileChannel fromChannel=fromFile.getChannel();
		FileChannel toChannel=toFile.getChannel();
		
		long position=0;
		long count=fromChannel.size();
		
		toChannel.transferFrom(fromChannel, position, count);
		
	}
	
	/**
	 * 
	 * @描述:transferTo()方法将数据从FileChannel传输到其他的channel中
	 * @param from_file
	 * @param to_file
	 * @throws IOException
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月21日下午3:56:29
	 */
	@SuppressWarnings("resource")
	private static void transferTo(String from_file,String to_file) throws IOException{
		
		RandomAccessFile fromFile=new RandomAccessFile(from_file, "rw");
		RandomAccessFile toFile=new RandomAccessFile(to_file, "rw");
		
		FileChannel fromChannel=fromFile.getChannel();
		FileChannel toChannel=toFile.getChannel();
		
		long position=0;
		long count=fromChannel.size();
				
		fromChannel.transferTo(position, count, toChannel);
	}
	
	

}
