/**
 * @author 将晖
 */


public class Stu {

    private String name;

    public Stu(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object stu) {

        //当前这个类的对象的地址是否相等于这个stu类的地址，实际上我们在比较同一个对象
        if (this == stu)
            return true;

        //判断传来的stu对象是否是空对象
        if (stu == null)
            return false;

        //判断强转是否成立：当前这个类是否等于传来stu的所对应的类，如果不是，说明不能进行强转
        if (this.getClass() != stu.getClass())
            return false;

        Stu another = (Stu) stu;
        //忽略大小写
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }


}
