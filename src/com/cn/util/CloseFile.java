

package com.cn.util;
import java.io.Closeable;
import java.io.IOException;
/**
 * �ر��ļ����ڲ�
 * @author Administrator
 *
 */
public class CloseFile implements Closeable{
	public static  Closeable cx;
	public static void free(Closeable c){
		cx = c;
		try {
			new CloseFile().close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	} 
	public void close() throws IOException {
    
		if(cx == null)
			return;
		cx.close();
	}
}