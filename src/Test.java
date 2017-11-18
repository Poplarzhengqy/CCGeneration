


import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʵ����
 * 
 * @author С��
 * @�������� 2015-3-12
 */
class Person implements Externalizable {
	private static final long serialVersionUID = 1L;
	String userName;
	String password;
	String age;

	public Person(String userName, String password, String age) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public Person() {
		super();
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ���л���������չ��
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// ����һ���µĶ���
		Date date = new Date();
		out.writeObject(userName);
		out.writeObject(password);
		out.writeObject(date);
	}

	/**
	 * �����л�����չ��
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// ע������Ľ���˳���������Ƶ�Ŷ������Ļ�������
		// ����������write����A����Ļ�����ô�����Ƚ��ܵ�Ҳһ����A����...
		userName = (String) in.readObject();
		password = (String) in.readObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) in.readObject();
		System.out.println("�����л��������Ϊ:" + sdf.format(date));

	}

	@Override
	public String toString() {
		// ע������������ǲ��ᱻ���л��ģ������ڷ����л���ʱ���Ƕ�ȡ�������ݵ�
		return "�û���:" + userName + "�� ��:" + password + "����:" + age;
	}
}

/**
 * ���л��ͷ����л�����ز�����
 * 
 * @author С��
 * @�������� 2015-3-12
 */
class Operate {
	/**
	 * ���л�����
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void serializable(Person person) throws FileNotFoundException, IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("a.txt"));
		outputStream.writeObject(person);
	}

	/**
	 * �����л��ķ���
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public Person deSerializable() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
		return (Person) ois.readObject();
	}

}

/**
 * ����ʵ������
 * 
 * @author С��
 * @�������� 2015-3-12
 */
public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Operate operate = new Operate();
		Person person = new Person("С��", "123456", "20");
		System.out.println("Ϊ���л�֮ǰ�������������:\n" + person.toString());
		operate.serializable(person);
		Person newPerson = operate.deSerializable();
		System.out.println("-------------------------------------------------------");
		System.out.println("���л�֮��������������:\n" + newPerson.toString());
	}

}