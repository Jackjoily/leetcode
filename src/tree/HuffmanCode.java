package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {

	public static void main(String[] args) {
//		i like like like java do you like a java"
//		String content = "hi hello  i am jackjoily whats is your name";
//		byte[] cotentBytes = content.getBytes();
//		Node node = createHuffmanTree(getNode(cotentBytes));
//		getNode(node, "", sb);
//		System.out.println(huffmancode);
//		byte[] bytes = zip(cotentBytes, huffmancode);
//		System.out.println(Arrays.toString(bytes));
//		System.out.println(Arrays.toString(cotentBytes));
//		System.out.println(new String(decode(huffmancode, bytes)));
//		String srcFile = "C:\\Users\\jackjoily\\Desktop\\ppt汇报.ppt";
		String zipFile = "C:\\Users\\jackjoily\\Desktop\\dst.zip";
		String distFile = "C:\\Users\\jackjoily\\Desktop\\ppt汇报222.ppt";
//		zipFile(srcFile, dstFile);
		unZipFile(zipFile,distFile);
	}

	static Map<Byte, String> huffmancode = new HashMap<Byte, String>();
	static StringBuilder sb = new StringBuilder();

	// 编写方法对文件进行压缩

	public static void zipFile(String srcFile, String dstFile) {
		//
		FileInputStream fis = null;
		OutputStream fos = null;
		ObjectOutputStream os = null;
		try {
			fis = new FileInputStream(srcFile);
			// 创建一个和源文件的一样的数组
			byte[] b = new byte[fis.available()];
			fis.read(b);
			Node node = createHuffmanTree(getNode(b));
			getNode(node, "", sb);
			// 处理好的文件压缩后的字节数组
			byte[] bytes = zip(b, huffmancode);
			// 创建文件的输出流
			fos = new FileOutputStream(dstFile);
			// 创建一个和文件输出流关联的
			os = new ObjectOutputStream(fos);
			// 以对象流的方式写入文件
			os.writeObject(bytes);
			// 把哈夫曼编码也写入压缩文件
			os.writeObject(huffmancode);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * 完成对压缩文件的解压
	 */

	public static void unZipFile(String zipFile, String dstFile) {
		// 定义文件的输入流
		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream fos = null;
		try {
			is = new FileInputStream(zipFile);
			ois = new ObjectInputStream(is);
			fos = new FileOutputStream(dstFile);
			System.out.println(fos);
			byte[] huffmanBytes = (byte[]) ois.readObject();
			@SuppressWarnings("unchecked")
			Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
			byte[] bytes = decode(codes, huffmanBytes);
			fos.write(bytes);
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	
	}

	/**
	 * 
	 * @param huffmanCodes 哈夫曼编码表
	 * @param huffmanBytes 哈夫曼得到的字节数组
	 * @return
	 */
	private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
//1.先得到二进制字符串
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < huffmanBytes.length; i++) {
			boolean flag = (i == huffmanBytes.length - 1);
			sb.append(byteToString(flag, huffmanBytes[i]));
		}
		// 按照指定的哈夫曼编码进行解码
		Map<String, Byte> map = new HashMap<>();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		// 创建集合存放byte
		List<Byte> list = new ArrayList<>();
		for (int i = 0; i < sb.length();) {
			int count = 1;
			boolean flag = true;
			Byte b = null;
			while (flag) {
				String key = sb.substring(i, i + count);
				b = map.get(key);
				if (b == null) {
					count++;
				} else {
					flag = false;
				}
			}
			list.add(b);
			i += count;// 移动到count个位置
		}
		byte[] b = new byte[list.size()];
		for (int i = 0; i < list.size(); i++) {
			b[i] = list.get(i);
		}
		return b;
	}

	/**
	 * 将一个byte转换程二进制数组
	 * 
	 * @param bytes
	 * @return
	 */
	private static String byteToString(boolean flag, byte b) {
		int temp = b;
		// 返回的是temp的二进制对应补码
		// 正数需要进行补位
		if (temp > 0 && !flag) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		if (!flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}

	}

	/**
	 * 
	 * @param bytes        原始的byte数组
	 * @param huffmanCodes 哈夫曼编码表
	 * @return
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder sv = new StringBuilder();
		for (Byte b : bytes) {
			sv.append(huffmancode.get(b));
		}
		String str = sv.toString();
		// 将字符串转成byte数组
		int len;
		if (str.length() % 8 == 0) {
			len = str.length() / 8;
		} else {
			len = str.length() / 8 + 1;
		}
		//
		byte[] bt = new byte[len];
		int index = 0;
		for (int i = 0; i < str.length(); i += 8) {
			String strByte = null;
			if (i + 8 > str.length()) {
				strByte = str.substring(i);
			} else {
				strByte = str.substring(i, i + 8);
			}
			bt[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}
		return bt;
	}

	// 生成哈夫曼编码表
	public static void getNode(Node node, String code, StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		if (node != null) {// 如果node不等于空
			// 判断当前node是叶子节点还是非叶子节点
			if (node.c == null) {
				getNode(node.left, "0", sb2);
				getNode(node.right, "1", sb2);
			} else {
				// 表示找到页子节点
				huffmancode.put(node.c, sb2.toString());
			}
		}
	}

	public static void PreOrder(Node node) {
		if (node != null) {
			System.out.print(node.c + ":" + node.weight + "--->");
			PreOrder(node.left);
			PreOrder(node.right);
		}
	}

	private static List<Node> getNode(byte[] bytes) {
		// 创建一个ArrayList
		ArrayList<Node> nodes = new ArrayList<Node>();
		// 遍历bytes
		Map<Byte, Integer> counts = new HashMap<>();
		for (byte node : bytes) {
			Integer count = counts.get(node);
			if (count == null) {
				counts.put(node, 1);
			} else {
				counts.put(node, count + 1);
			}
		}
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}

		return nodes;
	}

	private static Node createHuffmanTree(List<Node> list) {
		while (list.size() != 1) {
			Collections.sort(list);
			Node left = list.get(0);
			Node right = list.get(1);
			Node parent = new Node(left.weight + right.weight);
			parent.left = left;
			parent.right = right;
			list.remove(left);
			list.remove(right);
			list.add(parent);
		}
		return list.get(0);
	}
	// 数据解压

}
