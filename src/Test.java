import java.io.*;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author limeng
 * @date 2018/9/29 9:28
 */
public class Test {
    private static String basePath = "D:\\xiaozhi.properties";
    private static String path = "";

    /**
     * һ�� ʹ��java.util.Properties���load(InputStream in)��������properties�ļ�
     *
     * @return
     */
    public static String getPath1() {

        try {
            InputStream in = new BufferedInputStream(new FileInputStream(
                    new File(basePath)));
            Properties prop = new Properties();

            prop.load(in);

            path = prop.getProperty("path");

        } catch (FileNotFoundException e) {
            System.out.println("properties�ļ�·����д�������飡");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return path;
    }

    /**
     * ���� ʹ��java.util.ResourceBundle���getBundle()����
     * ע�⣺���getBundle()�����Ĳ���ֻ��д�ɰ�·��+properties�ļ������������쳣
     *
     * @return
     */
    public static String getPath2() {
        ResourceBundle rb = ResourceBundle
                .getBundle("com/test/modul/utils/prop");
        path = rb.getString("path");
        return path;
    }

    /**
     * ���� ʹ��java.util.PropertyResourceBundle��Ĺ��캯��
     *
     * @return
     */
    public static String getPath3() {
        InputStream in;
        try {
            in = new BufferedInputStream(new FileInputStream(basePath));
            ResourceBundle rb = new PropertyResourceBundle(in);
            path = rb.getString("path");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }

    /**
     * �ġ� ʹ��class������getResourceAsStream()����
     * ע�⣺getResourceAsStream()�����Ĳ�������ʽд����·��+properties�ļ���+.��׺
     *
     * @return
     */
    public static String getPath4() {
        InputStream in = Test.class
                .getResourceAsStream("/com/test/modul/utils/prop.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            path = p.getProperty("path");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }

    /**
     * �塢
     * ʹ��class.getClassLoader()���õ���java.lang.ClassLoader��getResourceAsStream()����
     * getResourceAsStream(name)�����Ĳ��������ǰ�·��+�ļ���+.��׺
     * ����ᱨ��ָ���쳣
     * @return
     */
    public static String getPath5() {
        InputStream in = Test.class.getClassLoader()
                .getResourceAsStream("com/test/modul/utils/prop.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            path = p.getProperty("path");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }

    /**
     * ���� ʹ��java.lang.ClassLoader���getSystemResourceAsStream()��̬����
     * getSystemResourceAsStream()�����Ĳ�����ʽҲ���й̶�Ҫ���
     *
     * @return
     */
    public static String getPath6() {
        InputStream in = ClassLoader
                .getSystemResourceAsStream("com/test/modul/utils/prop.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            path = p.getProperty("path");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }

    public static void main(String[] args) {
          //System.out.println(Test.getPath1());
          //System.out.println(LoadPropertiesFileUtil.getPath2());
          System.out.println(Test.getPath3());
          //System.out.println(LoadPropertiesFileUtil.getPath4());
          //System.out.println(LoadPropertiesFileUtil.getPath5());
          //System.out.println(LoadPropertiesFileUtil.getPath6());
    }



}