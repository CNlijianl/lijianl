import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Hello {
	public static void main(String[] args) {
		File f = new File("D:\\下载\\aaa.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("D:\\下载\\test.zip")));
			System.out.println("write!");
			int c;
			while((c = in.read()) !=-1) 
				out .write(c);
			in.close();
			out.close();
			System.out.println("read");
			BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("D:\\下载\\test.zip"))));
			char[] a = new char[100];
			while((in2.read()) !=-1)
				System.out.println(new String(a));
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}