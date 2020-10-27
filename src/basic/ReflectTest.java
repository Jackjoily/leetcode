package basic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 
 * 获取类或者对象的字节码文件对象
 * 
 * @author jackjoily 1.Object类的getClass() 2.Class.forName() 3.类型的class属性
 */

public class ReflectTest {

	public static void main(String[] args) {
		String name = "java.lang.Integer";
		try {
			Class cl = Class.forName(name);
			Class clSuperClass = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0)
				System.out.println(modifiers + "");
			System.out.println("class" + name);
			if (clSuperClass != null && clSuperClass != Object.class)
				System.out.println("extends" + clSuperClass.getName());
			System.out.println("\n{\n");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
